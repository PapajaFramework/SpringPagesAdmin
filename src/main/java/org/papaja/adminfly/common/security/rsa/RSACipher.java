package org.papaja.adminfly.common.security.rsa;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;

public class RSACipher {

    private static final String RSA_ECB_PKCS1 = "RSA/ECB/PKCS1Padding";
    private static final RSAKeyFactory FACTORY;

    static {
        FACTORY = new RSAKeyFactory();
    }

    public byte[] decrypt(String input, String key) {
        return decrypt(input.getBytes(StandardCharsets.UTF_8), key);
    }

    public byte[] encrypt(String input, String key) {
        return encrypt(input.getBytes(StandardCharsets.UTF_8), key);
    }

    public byte[] decrypt(byte[] bytes, String key) {
        return decrypt(bytes, FACTORY.getPrivateKey(key));
    }

    public byte[] encrypt(byte[] bytes, String key) {
        return encrypt(bytes, FACTORY.getPublicKey(key));
    }

    public byte[] decrypt(byte[] bytes, PrivateKey key) {
        return convert(bytes, key, Cipher.DECRYPT_MODE);
    }

    public byte[] encrypt(byte[] bytes, PublicKey key) {
        return convert(bytes, key, Cipher.ENCRYPT_MODE);
    }

    private byte[] convert(byte[] bytes, Key key, int mode) {
        byte[] output = new byte[0];

        try {
            Cipher cipher = Cipher.getInstance(RSA_ECB_PKCS1);
            cipher.init(mode, key);
            output = cipher.doFinal(bytes);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return output;
    }

}
