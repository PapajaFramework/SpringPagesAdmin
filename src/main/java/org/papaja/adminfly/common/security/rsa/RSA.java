package org.papaja.adminfly.common.security.rsa;

import org.papaja.adminfly.common.data.coder.Base64;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public class RSA {

    private static final RSAKeyGenerator GENERATOR;
    private static final Base64 BASE_64;

    static {
        BASE_64 = new Base64();
        GENERATOR = new RSAKeyGenerator();
    }

    private void write(Writer writer, String value) throws IOException {
        writer.write(value);
    }

    private void write(OutputStream stream, String value) throws IOException {
        write(stream, value.getBytes());
    }

    private void write(OutputStream stream, byte[] bytes) throws IOException {
        stream.write(bytes);
    }

    private String publicKeyString() {
        return BASE_64.encode(publicKeyBytes());
    }

    private byte[] publicKeyBytes() {
        return GENERATOR.getPublicKey().getEncoded();
    }

    private String privateKeyString() {
        return BASE_64.encode(publicKeyBytes());
    }

    private byte[] privateKeyBytes() {
        return GENERATOR.getPublicKey().getEncoded();
    }

    public void publicKey(OutputStream stream) throws IOException {
        write(stream, publicKeyString());
    }

    public void publicKey(Writer writer) throws IOException {
        write(writer, publicKeyString());
    }

    public void privateKey(OutputStream stream) throws IOException {
        write(stream, publicKeyString());
    }

    public void privateKey(Writer writer) throws IOException {
        write(writer, privateKeyString());
    }

}
