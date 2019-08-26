package org.papaja.adminfly.common.converter.coder;

import org.papaja.adminfly.common.converter.Coder;
import org.papaja.adminfly.common.util.structure.BiValue;

import static java.lang.String.format;

public class QuotedStringCoder implements Coder<String, String> {

    public static final Braces DEFAULT_BRACES = new Braces("'", "'");
    private             Braces braces         = DEFAULT_BRACES;

    @Override
    public String decode(String source) {
        source = source.substring(braces.sizeA());
        source = source.substring(0, source.lastIndexOf(braces.getB()));

        return source;
    }

    @Override
    public String encode(String source) {
        return format("%s%s%s", braces.getA(), source, braces.getB());
    }

    public void setBraces(String a, String b) {
        setBraces(new Braces(a, b));
    }

    public void setBraces(Braces braces) {
        this.braces = braces;
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
