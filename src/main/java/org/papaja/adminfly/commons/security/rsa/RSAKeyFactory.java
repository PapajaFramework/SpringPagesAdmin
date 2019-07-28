package org.papaja.adminfly.commons.security.rsa;

import org.papaja.adminfly.commons.security.Base64;
import org.papaja.adminfly.commons.security.Decoder;

import java.security.Key;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

@SuppressWarnings({"unused"})
public class RSAKeyFactory {

    private static final Base64 BASE_64;

    static {
        BASE_64 = new Base64();
    }

    public PrivateKey getPrivateKey(String key) {
        return getPrivateKey(BASE_64.decode(key));
    }

    public PublicKey getPublicKey(String key) {
        return getPublicKey(BASE_64.decode(key));
    }

    public PrivateKey getPrivateKey(byte[] bytes) {
        return new PrivateKeyDecoder().getKey(bytes);
    }

    public PublicKey getPublicKey(byte[] bytes) {
        return new PublicKeyDecoder().getKey(bytes);
    }

    private class PublicKeyDecoder implements Decoder<PublicKey>, KeyCoder<PublicKey> {

        @Override
        public PublicKey getKey(byte[] bytes) {
            return decode(bytes);
        }

        @Override
        public PublicKey decode(byte[] bytes) {
            PublicKey key = null;

            try {
                key = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bytes));
            } catch (Exception exception) {
                exception.printStackTrace();
            }

            return key;
        }

    }

    private class PrivateKeyDecoder implements Decoder<PrivateKey>, KeyCoder<PrivateKey> {

        @Override
        public PrivateKey getKey(byte[] bytes) {
            return decode(bytes);
        }

        @Override
        public PrivateKey decode(byte[] bytes) {
            PrivateKey key = null;

            try {
                key = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bytes));
            } catch (Exception exception) {
                exception.printStackTrace();
            }

            return key;
        }

    }

    interface KeyCoder<K extends Key> {
        K getKey(byte[] bytes);
    }

}
