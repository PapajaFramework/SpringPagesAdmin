package org.papaja.adminfly.commons.geo;

import static java.util.Objects.nonNull;
import static org.papaja.adminfly.commons.geo.Language.Direction.RTL;

@SuppressWarnings({"unused", "SpellCheckingInspection"})
public enum Language {

    AF_ZA("af-ZA", "Afrikaans", "", Country.ZA),
    AM_ET("am-ET", "Amharic", "", Country.ET, RTL),
    AR_AE("ar-AE", "Arabic", "العَرَبِيَّة\u200E", Country.AE, RTL),
    AR_BH("ar-BH", "Arabic", "العَرَبِيَّة\u200E", Country.BH, RTL),
    AR_DZ("ar-DZ", "Arabic", "العَرَبِيَّة\u200E", Country.DZ, RTL),
    AR_EG("ar-EG", "Arabic", "العَرَبِيَّة\u200E", Country.EG, RTL),
    AR_IQ("ar-IQ", "Arabic", "العَرَبِيَّة\u200E", Country.IQ, RTL),
    AR_JO("ar-JO", "Arabic", "العَرَبِيَّة\u200E", Country.JO, RTL),
    AR_KW("ar-KW", "Arabic", "العَرَبِيَّة\u200E", Country.KW, RTL),
    AR_LB("ar-LB", "Arabic", "العَرَبِيَّة\u200E", Country.LB, RTL),
    AR_LY("ar-LY", "Arabic", "العَرَبِيَّة\u200E", Country.LY, RTL),
    AR_MA("ar-MA", "Arabic", "العَرَبِيَّة\u200E", Country.MA, RTL),
    AR_OM("ar-OM", "Arabic", "العَرَبِيَّة\u200E", Country.OM, RTL),
    AR_QA("ar-QA", "Arabic", "العَرَبِيَّة\u200E", Country.QA, RTL),
    AR_SA("ar-SA", "Arabic", "العَرَبِيَّة\u200E", Country.SA, RTL),
    AR_SY("ar-SY", "Arabic", "العَرَبِيَّة\u200E", Country.SY, RTL),
    AR_TN("ar-TN", "Arabic", "العَرَبِيَّة\u200E", Country.TN, RTL),
    AR_YE("ar-YE", "Arabic", "العَرَبِيَّة\u200E", Country.YE, RTL),
    AZ_AZ("az-AZ", "Azeri", "", Country.AZ),
    BE_BY("be-BY", "Belarusian", "", Country.BY),
    BN_BD("bn-BD", "Bengali", "", Country.BD),
    BG_BG("bg-BG", "Bulgarian", "", Country.BG),
    BS_BA("bs-BA", "Bosnian", "", Country.BA),
    CA_ES("ca-ES", "Catalan", "", Country.ES),
    CS_CZ("cs-CZ", "Czech", "", Country.CZ),
    CY_GB("cy-GB", "Welsh", "", Country.GB),
    DA_DK("da-DK", "Danish", "", Country.DK),
    DE_AT("de-AT", "German", "", Country.AT),
    DE_CH("de-CH", "German", "", Country.CH),
    DE_DE("de-DE", "German", "", Country.DE),
    DE_LI("de-LI", "German", "", Country.LI),
    DE_LU("de-LU", "German", "", Country.LU),
    DV_MV("dv-MV", "Divehi", "", Country.MV),
    EL_GR("el-GR", "Greek", "", Country.GR),
    EN_AU("en-AU", "English", "English", Country.AU),
    EN_BZ("en-BZ", "English", "English", Country.BZ),
    EN_CA("en-CA", "English", "English", Country.CA),
    EN_GB("en-GB", "English", "English", Country.GB),
    EN_IE("en-IE", "English", "English", Country.IE),
    EN_JM("en-JM", "English", "English", Country.JM),
    EN_NZ("en-NZ", "English", "English", Country.NZ),
    EN_PH("en-PH", "English", "English", Country.PH),
    EN_TT("en-TT", "English", "English", Country.TT),
    EN_US("en-US", "English", "English", Country.US),
    EN_ZA("en-ZA", "English", "English", Country.ZA),
    EN_ZW("en-ZW", "English", "English", Country.ZW),
    ES_AR("es-AR", "Spanish", "Español", Country.AR),
    ES_BO("es-BO", "Spanish", "Español", Country.BO),
    ES_CL("es-CL", "Spanish", "Español", Country.CL),
    ES_CO("es-CO", "Spanish", "Español", Country.CO),
    ES_CR("es-CR", "Spanish", "Español", Country.CR),
    ES_DO("es-DO", "Spanish", "Español", Country.DO),
    ES_EC("es-EC", "Spanish", "Español", Country.EC),
    ES_ES("es-ES", "Spanish", "Español", Country.ES),
    ES_GT("es-GT", "Spanish", "Español", Country.GT),
    ES_HN("es-HN", "Spanish", "Español", Country.HN),
    ES_MX("es-MX", "Spanish", "Español", Country.MX),
    ES_NI("es-NI", "Spanish", "Español", Country.NI),
    ES_PA("es-PA", "Spanish", "Español", Country.PA),
    ES_PE("es-PE", "Spanish", "Español", Country.PE),
    ES_PR("es-PR", "Spanish", "Español", Country.PR),
    ES_PY("es-PY", "Spanish", "Español", Country.PY),
    ES_SV("es-SV", "Spanish", "Español", Country.SV),
    ES_UY("es-UY", "Spanish", "Español", Country.UY),
    ES_VE("es-VE", "Spanish", "Español", Country.VE),
    ET_EE("et-EE", "Estonian", "", Country.EE),
    EU_ES("eu-ES", "Basque", "", Country.ES),
    FA_IR("fa-IR", "Farsi", "", Country.IR),
    FI_FI("fi-FI", "Finnish", "", Country.FI),
    FO_FO("fo-FO", "Faroese", "", Country.FO),
    FR_BE("fr-BE", "French", "Le français", Country.BE),
    FR_CA("fr-CA", "French", "Le français", Country.CA),
    FR_CH("fr-CH", "French", "Le français", Country.CH),
    FR_FR("fr-FR", "French", "Le français", Country.FR),
    FR_LU("fr-LU", "French", "Le français", Country.LU),
    FR_MC("fr-MC", "French", "Le français", Country.MC),
    GL_ES("gl-ES", "Galician", "", Country.ES),
    GU_IN("gu-IN", "Gujarati", "", Country.IN),
    HE_IL("he-IL", "Hebrew", "", Country.IL),
    HI_IN("hi-IN", "Hindi", "", Country.IN),
    HR_BA("hr-BA", "Croatian", "", Country.BA),
    HR_HR("hr-HR", "Croatian", "", Country.HR),
    HU_HU("hu-HU", "Hungarian", "", Country.HU),
    HY_AM("hy-AM", "Armenian", "", Country.AM),
    ID_ID("id-ID", "Indonesian","", Country.ID),
    IS_IS("is-IS", "Icelandic", "", Country.IS),
    IT_CH("it-CH", "Italian", "", Country.CH),
    IT_IT("it-IT", "Italian", "", Country.IT),
    JA_JP("ja-JP", "Japanese", "", Country.JP),
    KA_GE("ka-GE", "Georgian", "", Country.GE),
    KM_KH("km-KH", "Khmer", "", Country.KH),
    KK_KZ("kk-KZ", "Kazakh", "", Country.KZ),
    KN_IN("kn-IN", "Kannada", "", Country.IN),
    KO_KR("ko-KR", "Korean", "", Country.KR),
    KOK_IN("kok-IN", "Konkani", "", Country.IN),
    KY_KG("ky-KG", "Kyrgyz", "", Country.KG),
    LO_LA("lo-LA", "Lao", "", Country.LA),
    LT_LT("lt-LT", "Lithuanian", "", Country.LT),
    LV_LV("lv-LV", "Latvian", "", Country.LV),
    MI_NZ("mi-NZ", "Maori", "", Country.NZ),
    MK_MK("mk-MK", "FYRO Macedonian", "", Country.MK),
    MN_MN("mn-MN", "Mongolian", "", Country.MN),
    MR_IN("mr-IN", "Marathi", "", Country.IN),
    MS_BN("ms-BN", "Malay", "", Country.BN),
    MS_MY("ms-MY", "Malay", "", Country.MY),
    MT_MT("mt-MT", "Maltese", "", Country.MT),
    MY_MM("my-MM", "Burmese", "", Country.MM),
    NB_NO("nb-NO", "Norwegian", "Norsk", Country.NO),
    NL_BE("nl-BE", "Dutch", "Dutch", Country.BE),
    NL_NL("nl-NL", "Dutch", "Dutch", Country.NL),
    NS_ZA("ns-ZA", "Northern Sotho", "Sesotho sa Leboa", Country.ZA),
    PA_IN("pa-IN", "Punjabi", "پنجابی", Country.IN),
    PL_PL("pl-PL", "Polish", "Polski", Country.PL),
    PS_AF("ps-AF", "Pashto", "پښتو\u200E", Country.AF),
    PT_BR("pt-BR", "Portuguese", "Português", Country.BR),
    PT_PT("pt-PT", "Portuguese", "Português", Country.PT),
    QU_BO("qu-BO", "Quechua", "Runasimi", Country.BO),
    QU_EC("qu-EC", "Quechua", "Runasimi", Country.EC),
    QU_PE("qu-PE", "Quechua", "Runasimi", Country.PE),
    RO_RO("ro-RO", "Romanian", "Roumanian", Country.RO),
    RU_RU("ru-RU", "Russian", "Русский", Country.RU),
    SA_IN("sa-IN", "Sanskrit", "संस्कृतम्", Country.IN),
    SE_FI("se-FI", "Sami", "Sami", Country.FI),
    SE_NO("se-NO", "Sami", "Sami", Country.NO),
    SE_SE("se-SE", "Sami", "Sami", Country.SE),
    SK_SK("sk-SK", "Slovak", "Slovakian", Country.SK),
    SL_SI("sl-SI", "Slovenian", "Slovene", Country.SI),
    SQ_AL("sq-AL", "Albanian", "Gjuha shqipe", Country.AL),
    SR_BA("sr-BA", "Serbian", "Српски", Country.BA),
    SV_FI("sv-FI", "Swedish", "Svenska", Country.FI),
    SV_SE("sv-SE", "Swedish", "Svenska", Country.SE),
    SW_KE("sw-KE", "Swahili", "Kiswahili", Country.KE),
    SYR_SY("syr-SY", "Syriac", "ܠܫܢܐ ܣܘܪܝܝܐ", Country.SY, RTL),
    TA_IN("ta-IN", "Tamil", "தமிழ்", Country.IN),
    TE_IN("te-IN", "Telugu", "తెలుగు", Country.IN),
    TH_TH("th-TH", "Thai", "ภาษาไทย", Country.TH),
    TL_PH("tl-PH", "Tagalog", "Tagalog", Country.PH),
    TN_ZA("tn-ZA", "Tswana", "Setswana", Country.ZA),
    TR_TR("tr-TR", "Turkish", "Türkçe", Country.TR),
    TT_RU("tt-RU", "Tatar", "Українська мова", Country.RU),
    UK_UA("uk-UA", "Ukrainian", "", Country.UA),
    UR_PK("ur-PK", "Urdu", "لشکری\u200E", Country.PK, RTL),
    UZ_UZ("uz-UZ", "Uzbek", "Oʻzbek ", Country.UZ),
    VI_VN("vi-VN", "Vietnamese", "tiếng Việt", Country.VN),
    XH_ZA("xh-ZA", "Xhosa", "Xhosa", Country.ZA),
    ZH_CN("zh-CN", "Chinese", "中文", Country.CN),
    ZH_HK("zh-HK", "Chinese", "中文", Country.HK),
    ZH_MO("zh-MO", "Chinese", "中文", Country.MO),
    ZH_SG("zh-SG", "Chinese", "中文", Country.SG),
    ZH_TW("zh-TW", "Chinese", "中文", Country.TW),
    ZU_ZA("zu-ZA", "Zulu", "isiZulu", Country.ZA);

    private Direction direction;
    private String name;
    private String local;
    private String code;
    private Country country;

    Language(String code, String name) {
        this(code, name, null, null, Direction.LTR);
    }

    Language(String code, String name, String local) {
        this(code, name, local, null, Direction.LTR);
    }

    Language(String code, String name, Country country) {
        this(code, name, null, country, Direction.LTR);
    }

    Language(String code, String name, Direction direction) {
        this(code, name, null, null, direction);
    }

    Language(String code, String name, String local, Country country) {
        this(code, name, local, country, Direction.LTR);
    }

    Language(String code, String name, Country country, Direction direction) {
        this(code, name, null, country, direction);
    }

    Language(String code, String name, String local, Direction direction) {
        this(code, name, local, null, direction);
    }

    Language(String code, String name, String local, Country country, Direction direction) {
        this.direction = direction;
        this.code = code;
        this.local = local;
        this.name = name;
        this.country = country;

        if (nonNull(country)) {
            country.attach(this);
        }
    }

    public boolean isRTL() {
        return nonNull(direction) && direction.equals(RTL);
    }

    public boolean isLTR() {
        return nonNull(direction) && direction.equals(Direction.LTR);
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getLocal() {
        return local;
    }

    public Country getCountry() {
        return country;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return String.format("LanguageOld{name='%s', code='%s'}", name, code);
    }

    public enum Direction {
        RTL, LTR
    }

}
