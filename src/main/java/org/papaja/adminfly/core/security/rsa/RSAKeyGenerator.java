package org.papaja.adminfly.core.security.rsa;

import java.security.*;

@SuppressWarnings({"unused"})
public class RSAKeyGenerator {

    private static final String  ALGORITHM    = "RSA";
    private static final Integer RSA_KEY_SIZE = 2048;

    private KeyPairGenerator generator;
    private KeyPair          pair;

    public RSAKeyGenerator() {
        this(RSA_KEY_SIZE);
    }

    public RSAKeyGenerator(Integer keySize) {
        try {
            generator = KeyPairGenerator.getInstance(ALGORITHM);
            generator.initialize(keySize);
        } catch (NoSuchAlgorithmException exception) { }

        generate();
    }

    public void generate() {
        this.pair = generator.generateKeyPair();
    }

    public PublicKey getPublicKey() {
        return pair.getPublic();
    }

    public PrivateKey getPrivateKey() {
        return pair.getPrivate();
    }

}
