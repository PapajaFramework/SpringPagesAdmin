package org.papaja.adminfly.data;

import org.papaja.adminfly.core.geo.Country;

import java.util.Arrays;
import java.util.List;

public class AvailableLocales {

    private static final List<Country> LOCALES;

    static {
        LOCALES = Arrays.asList(
            Country.UA, Country.BY, Country.RU, Country.GB,
            Country.GE, Country.PT, Country.ES, Country.DE,
            Country.FR, Country.PL, Country.NO, Country.ID,
            Country.GR, Country.MM, Country.IN, Country.CN,
            Country.JP, Country.ET, Country.LA, Country.KH,
            Country.TH, Country.BD
        );
    }

    public List<Country> getLocales() {
        return LOCALES;
    }
}
