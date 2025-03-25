package com.medisanaspace.healthx.dataloft.smartwearables.domain;

import com.danubetech.verifiablecredentials.CredentialSubject;
import com.danubetech.verifiablecredentials.VerifiableCredential;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.helper.UserIdHelper;
import foundation.identity.jsonld.ConfigurableDocumentLoader;
import info.weboftrust.ldsignatures.jsonld.LDSecurityKeywords;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medisanaspace.healthx.dataloft.smartwearables.crypto.JWTJsonWebSignature2020LdSigner;
import org.springframework.web.server.ResponseStatusException;

import jakarta.annotation.security.RolesAllowed;
import java.net.URI;
import java.security.KeyPair;
import java.security.Principal;

import java.time.Instant;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/api/verifiable-credential")
@Slf4j
public class VerifiableCredentialController {

    @Value("${vc.signing.filename.publickey:#{''}}")
    private String rsaPublicKeyFilename;

    @Value("${vc.signing.filenname.privatekey:#{''}}")
    private String rsaPrivateKeyFilename;


    public VerifiableCredentialController() {

    }

    @Transactional
    @GetMapping(path = "/issue")
    @RolesAllowed("swc-user")
    @ResponseBody
    public VerifiableCredential issueVerifiedCredential(@RequestHeader(value = "User-Id", required = false) final String userId, Principal userPrincipal) {
        UUID subjectId = UserIdHelper.parseUserIdFromPrincipal(userPrincipal);
        UUID userUUID = subjectId != null ? subjectId : UUID.fromString(userId);

        Map<String, Object> claims = new LinkedHashMap<>();
        claims.put("uuid", (userUUID).toString());

        CredentialSubject credentialSubject = CredentialSubject.builder()
                //           .id(URI.create("did:example:ebfeb1f712ebc6f1c276e12ec21"))
                .claims(claims)
                .build();

        VerifiableCredential verifiableCredential = VerifiableCredential.builder()
                .context(URI.create("https://schema.org"))
                //     .context(VerifiableCredentialContexts.JSONLD_CONTEXT_W3C_2018_CREDENTIALS_EXAMPLES_V1)
                .type("ServiceAccountCredential")
                //   .id(URI.create("http://example.edu/credentials/3732"))
                .issuer(URI.create("did:web:dataloft-wearable-cloud-domain"))
                .issuanceDate(Date.from(Instant.now()))
                //  .issuanceDate(JsonLDUtils.stringToDate("2019-06-16T18:56:59Z"))
                //     .expirationDate(JsonLDUtils.stringToDate("2019-06-17T18:56:59Z"))
                .credentialSubject(credentialSubject)
                .build();

        ((ConfigurableDocumentLoader) verifiableCredential.getDocumentLoader()).setEnableHttp(true);
        ((ConfigurableDocumentLoader) verifiableCredential.getDocumentLoader()).setEnableHttps(true);

        try {
            JWTJsonWebSignature2020LdSigner jwtJsonWebSignature2020LdSigner = new JWTJsonWebSignature2020LdSigner();
            KeyPair keyPair = new KeyPair(jwtJsonWebSignature2020LdSigner.getPublicKey(rsaPublicKeyFilename), jwtJsonWebSignature2020LdSigner.getPrivateKey(rsaPrivateKeyFilename));
            jwtJsonWebSignature2020LdSigner.sign(verifiableCredential, keyPair, claims, LDSecurityKeywords.JSONLD_TERM_ASSERTIONMETHOD,URI.create("did:web:dataloft-wearable-cloud-domain#jwstoken"));
        } catch (Exception e) {
            log.error("Failed to sign Verifiable Credential due to an error: ", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return verifiableCredential;
    }



}
