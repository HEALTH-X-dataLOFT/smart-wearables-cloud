package com.medisanaspace.healthx.dataloft.smartwearables.crypto;

import foundation.identity.jsonld.JsonLDObject;
import info.weboftrust.ldsignatures.LdProof;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.SecureDigestAlgorithm;
import org.apache.commons.codec.binary.Base64;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

public class JWTJsonWebSignature2020LdSigner {

    public LdProof sign(JsonLDObject jsonLdObject, KeyPair keyPair, Map<String, Object> claims, String proofPurpose, URI verificationMethod) {
        SecureDigestAlgorithm<PrivateKey, PublicKey> alg = Jwts.SIG.RS512;
        String jwtProof = Jwts.builder()
                .claims(claims)
                .header()
                    .add("typ","JWT")
                .and()
                .signWith(keyPair.getPrivate(), alg)
                .compact();

        LdProof ldProof = LdProof.builder()
                .created(Date.from(Instant.now()))
                .jws(jwtProof)
                .proofPurpose(proofPurpose)
                .type("JsonWebSignature2020")
                .verificationMethod(verificationMethod)
                .build();

        ldProof.addToJsonLDObject(jsonLdObject);

        return ldProof;
    }

    private static String getKey(String filename) throws IOException {
        // Read key from file
        StringBuilder strKeyPEMStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                strKeyPEMStringBuilder.append(line).append("\n");
            }
        }
        return strKeyPEMStringBuilder.toString();
    }

    public static RSAPrivateKey getPrivateKey(String filename) throws IOException, GeneralSecurityException {
        String privateKeyPEM = getKey(filename);
        return getPrivateKeyFromString(privateKeyPEM);
    }

    public static RSAPrivateKey getPrivateKeyFromString(String key) throws GeneralSecurityException {
        String privateKeyPEM = key;
        privateKeyPEM = privateKeyPEM.replace("-----BEGIN PRIVATE KEY-----\n", "");
        privateKeyPEM = privateKeyPEM.replace("-----END PRIVATE KEY-----", "");
        byte[] encoded = Base64.decodeBase64(privateKeyPEM);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
        return (RSAPrivateKey) kf.generatePrivate(keySpec);
    }


    public static RSAPublicKey getPublicKey(String filename) throws IOException, GeneralSecurityException {
        String publicKeyPEM = getKey(filename);
        return getPublicKeyFromString(publicKeyPEM);
    }

    public static RSAPublicKey getPublicKeyFromString(String key) throws GeneralSecurityException {
        String publicKeyPEM = key;
        publicKeyPEM = publicKeyPEM.replace("-----BEGIN PUBLIC KEY-----\n", "");
        publicKeyPEM = publicKeyPEM.replace("-----END PUBLIC KEY-----", "");
        byte[] encoded = Base64.decodeBase64(publicKeyPEM);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return (RSAPublicKey) kf.generatePublic(new X509EncodedKeySpec(encoded));
    }
}
