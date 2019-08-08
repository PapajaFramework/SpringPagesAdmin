package org.papaja.adminfly.commons.geo;

import static java.util.Objects.nonNull;
import static org.papaja.adminfly.commons.geo.Locale.Direction.LTR;
import static org.papaja.adminfly.commons.geo.Locale.Direction.RTL;

@SuppressWarnings({"unused", "SpellCheckingInspection"})
public enum Locale {

    AF_ZA("af-ZA", "Afrikaans", "Afrikaans", Country.ZA),
    AM_ET("am-ET", "Amharic", "ኣማርኛ", Country.ET, RTL),
    AR_AE("ar-AE", "Arabic", "العربية", Country.AE, RTL),
    AR_BH("ar-BH", "Arabic", "العربية", Country.BH, RTL),
    AR_DZ("ar-DZ", "Arabic", "العربية", Country.DZ, RTL),
    AR_EG("ar-EG", "Arabic", "العربية", Country.EG, RTL),
    AR_IQ("ar-IQ", "Arabic", "العربية", Country.IQ, RTL),
    AR_JO("ar-JO", "Arabic", "العربية", Country.JO, RTL),
    AR_KW("ar-KW", "Arabic", "العربية", Country.KW, RTL),
    AR_LB("ar-LB", "Arabic", "العربية", Country.LB, RTL),
    AR_LY("ar-LY", "Arabic", "العربية", Country.LY, RTL),
    AR_MA("ar-MA", "Arabic", "العربية", Country.MA, RTL),
    AR_OM("ar-OM", "Arabic", "العربية", Country.OM, RTL),
    AR_QA("ar-QA", "Arabic", "العربية", Country.QA, RTL),
    AR_SA("ar-SA", "Arabic", "العربية", Country.SA, RTL),
    AR_SY("ar-SY", "Arabic", "العربية", Country.SY, RTL),
    AR_TN("ar-TN", "Arabic", "العربية", Country.TN, RTL),
    AR_YE("ar-YE", "Arabic", "العربية", Country.YE, RTL),
    AZ_AZ("az-AZ", "Azerbaijani", "Azərbaycan dili", Country.AZ),
    BE_BY("be-BY", "Belarusian", "Беларуская", Country.BY),
    BN_BD("bn-BD", "Bengali", "বাংলা", Country.BD),
    BG_BG("bg-BG", "Bulgarian", "Български език", Country.BG),
    BS_BA("bs-BA", "Bosnian", "Босански", Country.BA),
    CA_ES("ca-ES", "Catalan", "Català", Country.ES),
    CS_CZ("cs-CZ", "Czech", "Čeština", Country.CZ),
    CY_GB("cy-GB", "Welsh", "Cymraeg", Country.GB),
    DA_DK("da-DK", "Danish", "Dansk", Country.DK),
    DE_AT("de-AT", "German", "Deutsch", Country.AT),
    DE_CH("de-CH", "German", "Deutsch", Country.CH),
    DE_DE("de-DE", "German", "Deutsch", Country.DE),
    DE_LI("de-LI", "German", "Deutsch", Country.LI),
    DE_LU("de-LU", "German", "Deutsch", Country.LU),
    DV_MV("dv-MV", "Maldivian", "ދިވެހި", Country.MV),
    EL_GR("el-GR", "Greek", "Ελληνικά", Country.GR),
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
    ET_EE("et-EE", "Estonian", "Eesti", Country.EE),
    EU_ES("eu-ES", "Basque", "Euskara", Country.ES),
    FA_IR("fa-IR", "Farsi", "فارسی", Country.IR),
    FI_FI("fi-FI", "Finnish", "Suomi", Country.FI),
    FO_FO("fo-FO", "Faroese", "Føroyskt", Country.FO),
    FR_BE("fr-BE", "French", "Français", Country.BE),
    FR_CA("fr-CA", "French", "Français", Country.CA),
    FR_CH("fr-CH", "French", "Français", Country.CH),
    FR_FR("fr-FR", "French", "Français", Country.FR),
    FR_LU("fr-LU", "French", "Français", Country.LU),
    FR_MC("fr-MC", "French", "Français", Country.MC),
    GL_ES("gl-ES", "Galician", "Galego", Country.ES),
    GU_IN("gu-IN", "Gujarati", "ગુજરાતી", Country.IN),
    HE_IL("he-IL", "Hebrew", "עברית", Country.IL),
    HI_IN("hi-IN", "Hindi", "फिजी बात", Country.IN),
    HR_BA("hr-BA", "Croatian", "Hrvatski", Country.BA),
    HR_HR("hr-HR", "Croatian", "Hrvatski", Country.HR),
    HU_HU("hu-HU", "Hungarian", "Magyar", Country.HU),
    HY_AM("hy-AM", "Armenian", "Հայերեն", Country.AM),
    ID_ID("id-ID", "Indonesian","Bahasa Indonesia", Country.ID),
    IS_IS("is-IS", "Icelandic", "Íslenska", Country.IS),
    IT_CH("it-CH", "Italian", "Italiano", Country.CH),
    IT_IT("it-IT", "Italian", "Italiano", Country.IT),
    JA_JP("ja-JP", "Japanese", "日本語", Country.JP),
    KA_GE("ka-GE", "Georgian", "ქართული", Country.GE),
    KM_KH("km-KH", "Khmer", "ភាសាខ្មែរ", Country.KH),
    KK_KZ("kk-KZ", "Kazakh", "Қазақ Tілі", Country.KZ),
    KN_IN("kn-IN", "Kannada", "ಕನ್ನಡ", Country.IN),
    KO_KR("ko-KR", "Korean", "한국어", Country.KR),
    KOK_IN("kok-IN", "Konkani", "കൊങ്കണി", Country.IN),
    KY_KG("ky-KG", "Kyrgyz", "قىرعىزچا", Country.KG),
    LO_LA("lo-LA", "Lao", "ພາສາລາວ", Country.LA),
    LT_LT("lt-LT", "Lithuanian", "Lietuvių", Country.LT),
    LV_LV("lv-LV", "Latvian", "Latviešu", Country.LV),
    MI_NZ("mi-NZ", "Maori", "Māori", Country.NZ),
    MK_MK("mk-MK", "Macedonian", "Mакедонски", Country.MK),
    MN_MN("mn-MN", "Mongolian", "Монгол Хэл", Country.MN),
    MR_IN("mr-IN", "Marathi", "मराठी", Country.IN),
    MS_BN("ms-BN", "Malay", "بهاس جاوي,", Country.BN),
    MS_MY("ms-MY", "Malay", "بهاس جاوي,", Country.MY),
    MT_MT("mt-MT", "Maltese", "Malti", Country.MT),
    MY_MM("my-MM", "Burmese", "မြန်မာစာ", Country.MM),
    NB_NO("nb-NO", "Norwegian", "Norsk", Country.NO),
    NL_BE("nl-BE", "Dutch", "Dutch", Country.BE),
    NL_NL("nl-NL", "Dutch", "Nederlands", Country.NL),
    NS_ZA("ns-ZA", "Northern Sotho", "Sesotho sa Leboa", Country.ZA),
    PA_IN("pa-IN", "Punjabi", "پنجابی", Country.IN),
    PL_PL("pl-PL", "Polish", "Polski", Country.PL),
    PS_AF("ps-AF", "Pashto", "پښتو", Country.AF),
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
    TT_RU("tt-RU", "Tatar", "Татарча", Country.RU),
    UK_UA("uk-UA", "Ukrainian", "Українська", Country.UA),
    UR_PK("ur-PK", "Urdu", "اُردُو", Country.PK, RTL),
    UZ_UZ("uz-UZ", "Uzbek", "Oʻzbek ", Country.UZ),
    VI_VN("vi-VN", "Vietnamese", "Tiếng", Country.VN),
    XH_ZA("xh-ZA", "Xhosa", "Xhosa", Country.ZA),
    ZH_CN("zh-CN", "Chinese", "汉语", Country.CN),
    ZH_HK("zh-HK", "Chinese", "汉语", Country.HK),
    ZH_MO("zh-MO", "Chinese", "汉语", Country.MO),
    ZH_SG("zh-SG", "Chinese", "汉语", Country.SG),
    ZH_TW("zh-TW", "Chinese", "汉语", Country.TW),
    ZU_ZA("zu-ZA", "Zulu", "Zulu", Country.ZA);

    private Direction direction;
    private String name;
    private String local;
    private String code;
    private Country country;

    Locale(String code, String name) {
        this(code, name, null, null, LTR);
    }

    Locale(String code, String name, String local) {
        this(code, name, local, null, LTR);
    }

    Locale(String code, String name, Country country) {
        this(code, name, null, country, LTR);
    }

    Locale(String code, String name, Direction direction) {
        this(code, name, null, null, direction);
    }

    Locale(String code, String name, String local, Country country) {
        this(code, name, local, country, LTR);
    }

    Locale(String code, String name, Country country, Direction direction) {
        this(code, name, null, country, direction);
    }

    Locale(String code, String name, String local, Direction direction) {
        this(code, name, local, null, direction);
    }

    Locale(String code, String name, String local, Country country, Direction direction) {
        this.direction = direction;
        this.code = code;
        this.local = local;
        this.name = name;
        this.country = country;
    }

    public boolean isRTL() {
        return nonNull(direction) && direction.equals(RTL);
    }

    public boolean isLTR() {
        return nonNull(direction) && direction.equals(LTR);
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
        return String.format("Language{name='%s', local = '%s' code='%s'}", name, local, code);
    }

    public enum Direction {
        RTL, LTR
    }

}
