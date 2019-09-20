package org.papaja.commons.converter.coder;

import org.papaja.commons.converter.Coder;
import org.papaja.commons.structure.tuple.Pair;

import static java.lang.String.format;

public class StringCoder implements Coder<String, String> {

    public static final Braces DEFAULT_BRACES      = new Braces("'", "'");
    public static final Braces DOUBLE_QUOTE_BRACES = new Braces('"', '"');
    public static final Braces CURLY_BRACES        = new Braces("{'", "'}");
    public static final Braces SQUARE_BRACES       = new Braces("['", "']");

    private             Braces braces              = DEFAULT_BRACES;

    @Override
    public String decode(String source) {
        boolean hasQuote = source.startsWith(braces.getA()) && source.endsWith(braces.getB());

        if (hasQuote) {
            source = source.substring(braces.sizeA());
            source = source.substring(0, source.lastIndexOf(braces.getB()));
        }

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

    private static class Braces extends Pair<String, String> {

        public Braces(String a, String b) {
            super(a, b);
        }

        public Braces(char a, char b) {
            this(new String(new char[]{a}), new String(new char[]{b}));
        }

        public int sizeA() {
            return getA().length();
        }

        public int sizeB() {
            return getA().length();
        }

    }

}
