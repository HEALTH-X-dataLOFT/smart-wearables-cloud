package com.medisanaspace.healthx.dataloft.smartwearables.dataspace.rundsp;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.factories.DefaultJWEDecrypterFactory;
import com.nimbusds.jose.crypto.factories.DefaultJWSVerifierFactory;
import com.nimbusds.jose.proc.*;
import com.nimbusds.jwt.*;
import com.nimbusds.jwt.proc.*;

import java.security.Key;
import java.text.ParseException;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class HealthXJWTProcessor<C extends SecurityContext> implements ConfigurableJWTProcessor<C> {
    private JOSEObjectTypeVerifier<C> jwsTypeVerifier;
    private JOSEObjectTypeVerifier<C> jweTypeVerifier;
    private JWSKeySelector<C> jwsKeySelector;
    private JWTClaimsSetAwareJWSKeySelector<C> claimsSetAwareJWSKeySelector;
    private JWEKeySelector<C> jweKeySelector;
    private JWSVerifierFactory jwsVerifierFactory;
    private JWEDecrypterFactory jweDecrypterFactory;
    private JWTClaimsSetVerifier<C> claimsVerifier;

    public HealthXJWTProcessor() {
        this.jwsTypeVerifier = DefaultJOSEObjectTypeVerifier.JWT;
        this.jweTypeVerifier = DefaultJOSEObjectTypeVerifier.JWT;
        this.jwsVerifierFactory = new DefaultJWSVerifierFactory();
        this.jweDecrypterFactory = new DefaultJWEDecrypterFactory();
        this.claimsVerifier = new DefaultJWTClaimsVerifier((JWTClaimsSet)null, (Set)null);
    }

    public JOSEObjectTypeVerifier<C> getJWSTypeVerifier() {
        return this.jwsTypeVerifier;
    }

    public void setJWSTypeVerifier(JOSEObjectTypeVerifier<C> jwsTypeVerifier) {
        this.jwsTypeVerifier = jwsTypeVerifier;
    }

    public JWSKeySelector<C> getJWSKeySelector() {
        return this.jwsKeySelector;
    }

    public void setJWSKeySelector(JWSKeySelector<C> jwsKeySelector) {
        this.jwsKeySelector = jwsKeySelector;
    }

    public JWTClaimsSetAwareJWSKeySelector<C> getJWTClaimsSetAwareJWSKeySelector() {
        return this.claimsSetAwareJWSKeySelector;
    }

    public void setJWTClaimsSetAwareJWSKeySelector(JWTClaimsSetAwareJWSKeySelector<C> jwsKeySelector) {
        this.claimsSetAwareJWSKeySelector = jwsKeySelector;
    }

    public JOSEObjectTypeVerifier<C> getJWETypeVerifier() {
        return this.jweTypeVerifier;
    }

    public void setJWETypeVerifier(JOSEObjectTypeVerifier<C> jweTypeVerifier) {
        this.jweTypeVerifier = jweTypeVerifier;
    }

    public JWEKeySelector<C> getJWEKeySelector() {
        return this.jweKeySelector;
    }

    public void setJWEKeySelector(JWEKeySelector<C> jweKeySelector) {
        this.jweKeySelector = jweKeySelector;
    }

    public JWSVerifierFactory getJWSVerifierFactory() {
        return this.jwsVerifierFactory;
    }

    public void setJWSVerifierFactory(JWSVerifierFactory factory) {
        this.jwsVerifierFactory = factory;
    }

    public JWEDecrypterFactory getJWEDecrypterFactory() {
        return this.jweDecrypterFactory;
    }

    public void setJWEDecrypterFactory(JWEDecrypterFactory factory) {
        this.jweDecrypterFactory = factory;
    }

    public JWTClaimsSetVerifier<C> getJWTClaimsSetVerifier() {
        return this.claimsVerifier;
    }

    public void setJWTClaimsSetVerifier(JWTClaimsSetVerifier<C> claimsVerifier) {
        this.claimsVerifier = claimsVerifier;
    }

    private JWTClaimsSet extractJWTClaimsSet(JWT jwt) throws BadJWTException {
        try {
            return jwt.getJWTClaimsSet();
        } catch (ParseException var3) {
            ParseException e = var3;
            throw new BadJWTException(e.getMessage(), e);
        }
    }

    private JWTClaimsSet verifyClaims(JWTClaimsSet claimsSet, C context) throws BadJWTException {
        if (this.getJWTClaimsSetVerifier() != null) {
            this.getJWTClaimsSetVerifier().verify(claimsSet, context);
        }

        return claimsSet;
    }

    private List<? extends Key> selectKeys(JWSHeader header, JWTClaimsSet claimsSet, C context) throws KeySourceException, BadJOSEException {
        if (this.getJWTClaimsSetAwareJWSKeySelector() != null) {
            return this.getJWTClaimsSetAwareJWSKeySelector().selectKeys(header, claimsSet, context);
        } else if (this.getJWSKeySelector() != null) {
            return this.getJWSKeySelector().selectJWSKeys(header, context);
        } else {
            throw new BadJOSEException("Signed JWT rejected: No JWS key selector is configured");
        }
    }

    public JWTClaimsSet process(String jwtString, C context) throws ParseException, BadJOSEException, JOSEException {
        return this.process(JWTParser.parse(jwtString), context);
    }

    public JWTClaimsSet process(JWT jwt, C context) throws BadJOSEException, JOSEException {
        if (jwt instanceof SignedJWT) {
            return this.process((SignedJWT)jwt, context);
        } else if (jwt instanceof EncryptedJWT) {
            return this.process((EncryptedJWT)jwt, context);
        } else if (jwt instanceof PlainJWT) {
            return this.process((PlainJWT)jwt, context);
        } else {
            throw new JOSEException("Unexpected JWT object type: " + jwt.getClass());
        }
    }

    public JWTClaimsSet process(PlainJWT plainJWT, C context) throws BadJOSEException, JOSEException {
        if (this.jwsTypeVerifier == null) {
            throw new BadJOSEException("Plain JWT rejected: No JWS header typ (type) verifier is configured");
        } else {
            this.jwsTypeVerifier.verify(plainJWT.getHeader().getType(), context);
            throw new BadJOSEException("Unsecured (plain) JWTs are rejected, extend class to handle");
        }
    }

    public JWTClaimsSet process(SignedJWT signedJWT, C context) throws BadJOSEException, JOSEException {
        if (this.jwsTypeVerifier == null) {
            throw new BadJOSEException("Signed JWT rejected: No JWS header typ (type) verifier is configured");
        } else {
            this.jwsTypeVerifier.verify(signedJWT.getHeader().getType(), context);
            if (this.getJWSKeySelector() == null && this.getJWTClaimsSetAwareJWSKeySelector() == null) {
                throw new BadJOSEException("Signed JWT rejected: No JWS key selector is configured");
            } else if (this.getJWSVerifierFactory() == null) {
                throw new JOSEException("No JWS verifier is configured");
            } else {
                JWTClaimsSet claimsSet = this.extractJWTClaimsSet(signedJWT);
                List<? extends Key> keyCandidates = this.selectKeys(signedJWT.getHeader(), claimsSet, context);
                if (keyCandidates != null && !keyCandidates.isEmpty()) {
                    ListIterator<? extends Key> it = keyCandidates.listIterator();

                    while(it.hasNext()) {
                        JWSVerifier verifier = this.getJWSVerifierFactory().createJWSVerifier(signedJWT.getHeader(), (Key)it.next());
                        if (verifier != null) {
                            boolean validSignature = signedJWT.verify(verifier);
                            if (validSignature) {
                                return this.verifyClaims(claimsSet, context);
                            }

                            if (!it.hasNext()) {
                                throw new BadJWSException("Signed JWT rejected: Invalid signature");
                            }
                        }
                    }

                    throw new BadJOSEException("JWS object rejected: No matching verifier(s) found");
                } else {
                    throw new BadJOSEException("Signed JWT rejected: Another algorithm expected, or no matching key(s) found");
                }
            }
        }
    }

    public JWTClaimsSet process(EncryptedJWT encryptedJWT, C context) throws BadJOSEException, JOSEException {
        if (this.jweTypeVerifier == null) {
            throw new BadJOSEException("Encrypted JWT rejected: No JWE header typ (type) verifier is configured");
        } else {
            this.jweTypeVerifier.verify(encryptedJWT.getHeader().getType(), context);
            if (this.getJWEKeySelector() == null) {
                throw new BadJOSEException("Encrypted JWT rejected: No JWE key selector is configured");
            } else if (this.getJWEDecrypterFactory() == null) {
                throw new JOSEException("No JWE decrypter is configured");
            } else {
                List<? extends Key> keyCandidates = this.getJWEKeySelector().selectJWEKeys(encryptedJWT.getHeader(), context);
                if (keyCandidates != null && !keyCandidates.isEmpty()) {
                    ListIterator<? extends Key> it = keyCandidates.listIterator();

                    while(true) {
                        JWEDecrypter decrypter;
                        do {
                            if (!it.hasNext()) {
                                throw new BadJOSEException("Encrypted JWT rejected: No matching decrypter(s) found");
                            }

                            decrypter = this.getJWEDecrypterFactory().createJWEDecrypter(encryptedJWT.getHeader(), (Key)it.next());
                        } while(decrypter == null);

                        try {
                            encryptedJWT.decrypt(decrypter);
                            break;
                        } catch (JOSEException var7) {
                            JOSEException e = var7;
                            if (!it.hasNext()) {
                                throw new BadJWEException("Encrypted JWT rejected: " + e.getMessage(), e);
                            }
                        }
                    }

                    String contentType = encryptedJWT.getHeader().getContentType();
                    boolean contentTypeJWTOrUnspecified = contentType == null || "".equalsIgnoreCase(contentType) || "JWT".equalsIgnoreCase(contentType);
                    if (contentTypeJWTOrUnspecified) {
                        SignedJWT signedJWTPayload = encryptedJWT.getPayload().toSignedJWT();
                        if (signedJWTPayload == null) {
                            throw new BadJWTException("The payload is not a nested signed JWT");
                        } else {
                            return this.process(signedJWTPayload, context);
                        }
                    } else {
                        JWTClaimsSet claimsSet = this.extractJWTClaimsSet(encryptedJWT);
                        return this.verifyClaims(claimsSet, context);
                    }
                } else {
                    throw new BadJOSEException("Encrypted JWT rejected: Another algorithm expected, or no matching key(s) found");
                }
            }
        }
    }
}

