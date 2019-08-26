package org.papaja.adminfly.common.converter.coder;

import org.papaja.adminfly.common.converter.Coder;
import org.papaja.adminfly.common.util.structure.BiValue;

import static java.lang.String.format;

public class QuotedStringCoder implements Coder<String, String> {

    private static final Braces BRACES;

    static {
        BRACES = new Braces("['", "']");
    }

    @Override
    public String decode(String source) {
        System.out.println(source);
        source = source.substring(BRACES.sizeA());

        System.out.println(source);
        System.out.println(source.length());
        System.out.println(source.lastIndexOf(BRACES.getB()));

        source = source.substring(0, source.lastIndexOf(BRACES.getB()));

        return source;
    }

    @Override
    public String encode(String source) {
        return format("%s%s%s", BRACES.getA(), source, BRACES.getB());
    }

    private static class Braces extends BiValue<String, String> {

        public Braces(String a, String b) {
            super(a, b);
        }

        public int sizeA() {
            return getA().length();
        }

        public int sizeB() {
            return getA().length();
        }

    }

}
