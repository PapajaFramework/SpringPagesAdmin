package org.papaja.adminfly.data;

import org.papaja.adminfly.commons.geo.Language;

import java.util.Arrays;
import java.util.List;

public class AvailableLocales {

    private static final List<Language> LOCALES;

    static {
        LOCALES = Arrays.asList(
            Language.UK_UA, Language.BE_BY,
            Language.RU_RU, Language.EN_US,
            Language.KA_GE, Language.PT_PT,
            Language.ES_ES, Language.DE_DE,
            Language.FR_FR, Language.PL_PL,
            Language.NB_NO, Language.ID_ID,
            Language.EL_GR, Language.MY_MM,
            Language.HI_IN, Language.ZH_CN,
            Language.JA_JP, Language.AM_ET,
            Language.LO_LA, Language.KM_KH,
            Language.TH_TH, Language.KO_KR,
            Language.BN_BD
        );
    }

    public List<Language> getLocales() {
        return LOCALES;
    }
}
