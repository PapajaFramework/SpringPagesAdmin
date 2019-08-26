package org.papaja.adminfly.common.formatter;

public class StringFormatter extends RawFormatter {

    @Override
    public String format(Object object) {
        return String.format("'%s'", super.format(object));
    }

}
