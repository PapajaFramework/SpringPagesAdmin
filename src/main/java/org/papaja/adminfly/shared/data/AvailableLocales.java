package org.papaja.adminfly.shared.data;

import org.papaja.adminfly.common.geo.Locale;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Arrays;
import java.util.List;

public class AvailableLocales {

    private static final List<Locale> LOCALES;

    static {
        LOCALES = Arrays.asList(
            Locale.UK_UA, Locale.BE_BY,
            Locale.RU_RU, Locale.EN_US,
            Locale.KA_GE, Locale.PT_PT,
            Locale.ES_ES, Locale.DE_DE,
            Locale.FR_FR, Locale.PL_PL,
            Locale.NB_NO, Locale.IN_ID,
            Locale.EL_GR, Locale.MY_MM,
            Locale.HI_IN, Locale.GU_IN,
            Locale.JA_JP, Locale.AM_ET,
            Locale.LO_LA, Locale.KM_KH,
            Locale.TH_TH, Locale.KO_KR,
            Locale.BN_BD, Locale.ZH_CN
        );
    }

    public Locale getCurrentLocale() {
        return Locale.getLocale(
                LocaleContextHolder.getLocale().toString()
        );
    }

    public List<Locale> getLocales() {
        return LOCALES;
    }
}
