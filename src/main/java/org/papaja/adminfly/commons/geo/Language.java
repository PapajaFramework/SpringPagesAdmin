package org.papaja.adminfly.commons.geo;

import static java.util.Objects.nonNull;

@SuppressWarnings({"unused", "SpellCheckingInspection"})
public enum Language {

    AF("af", "Afrikaans"),
    AF_ZA("af-ZA", "Afrikaans_South_Africa"),
    AM_ET("am-ET", "Amharic"),
    AR("ar", "Arabic"),
    AR_AE("ar-AE", "Arabic_UAE"),
    AR_BH("ar-BH", "Arabic_Bahrain"),
    AR_DZ("ar-DZ", "Arabic_Algeria"),
    AR_EG("ar-EG", "Arabic_Egypt"),
    AR_IQ("ar-IQ", "Arabic_Iraq"),
    AR_JO("ar-JO", "Arabic_Jordan"),
    AR_KW("ar-KW", "Arabic_Kuwait"),
    AR_LB("ar-LB", "Arabic_Lebanon"),
    AR_LY("ar-LY", "Arabic_Libya"),
    AR_MA("ar-MA", "Arabic_Morocco"),
    AR_OM("ar-OM", "Arabic_Oman"),
    AR_QA("ar-QA", "Arabic_Qatar"),
    AR_SA("ar-SA", "Arabic_Saudi_Arabia"),
    AR_SY("ar-SY", "Arabic_Syria"),
    AR_TN("ar-TN", "Arabic_Tunisia"),
    AR_YE("ar-YE", "Arabic_Yemen"),
    AZ("az", "Azeri_Latin"),
    AZ_AZ("az-AZ", "Azeri_LatinAzerbaijan"),
    BE("be", "Belarusian"),
    BE_BY("be-BY", "Belarusian_Belarus"),
    BG("bg", "Bulgarian"),
    BG_BG("bg-BG", "Bulgarian_Bulgaria"),
    BS_BA("bs-BA", "Bosnian_Bosnia_and_Herzegovina"),
    CA("ca", "Catalan"),
    CA_ES("ca-ES", "Catalan_Spain"),
    CS("cs", "Czech"),
    CS_CZ("cs-CZ", "Czech_Czech_Republic"),
    CY("cy", "Welsh"),
    CY_GB("cy-GB", "Welsh_United_Kingdom"),
    DA("da", "Danish"),
    DA_DK("da-DK", "Danish_Denmark"),
    DE("de", "German"),
    DE_AT("de-AT", "German_Austria"),
    DE_CH("de-CH", "German_Switzerland"),
    DE_DE("de-DE", "German_Germany"),
    DE_LI("de-LI", "German_Liechtenstein"),
    DE_LU("de-LU", "German_Luxembourg"),
    DV("dv", "Divehi"),
    DV_MV("dv-MV", "Divehi_Maldives"),
    EL("el", "Greek"),
    EL_GR("el-GR", "Greek_Greece"),
    EN("en", "English"),
    EN_AU("en-AU", "English_Australia"),
    EN_BZ("en-BZ", "English_Belize"),
    EN_CA("en-CA", "English_Canada"),
    EN_CB("en-CB", "English_Caribbean"),
    EN_GB("en-GB", "English_United_Kingdom"),
    EN_IE("en-IE", "English_Ireland"),
    EN_JM("en-JM", "English_Jamaica"),
    EN_NZ("en-NZ", "English_New_Zealand"),
    EN_PH("en-PH", "English_Republic_of_the_Philippines"),
    EN_TT("en-TT", "English_Trinidad_and_Tobago"),
    EN_US("en-US", "English_United_States"),
    EN_ZA("en-ZA", "English_South_Africa"),
    EN_ZW("en-ZW", "English_Zimbabwe"),
    EO("eo", "Esperanto"),
    ES("es", "Spanish"),
    ES_AR("es-AR", "Spanish_Argentina"),
    ES_BO("es-BO", "Spanish_Bolivia"),
    ES_CL("es-CL", "Spanish_Chile"),
    ES_CO("es-CO", "Spanish_Colombia"),
    ES_CR("es-CR", "Spanish_Costa_Rica"),
    ES_DO("es-DO", "Spanish_Dominican_Republic"),
    ES_EC("es-EC", "Spanish_Ecuador"),
    ES_ES("es-ES", "Spanish_Spain"),
    ES_GT("es-GT", "Spanish_Guatemala"),
    ES_HN("es-HN", "Spanish_Honduras"),
    ES_MX("es-MX", "Spanish_Mexico"),
    ES_NI("es-NI", "Spanish_Nicaragua"),
    ES_PA("es-PA", "Spanish_Panama"),
    ES_PE("es-PE", "Spanish_Peru"),
    ES_PR("es-PR", "Spanish_Puerto_Rico"),
    ES_PY("es-PY", "Spanish_Paraguay"),
    ES_SV("es-SV", "Spanish_El_Salvador"),
    ES_UY("es-UY", "Spanish_Uruguay"),
    ES_VE("es-VE", "Spanish_Venezuela"),
    ET("et", "Estonian"),
    ET_EE("et-EE", "Estonian_Estonia"),
    EU("eu", "Basque"),
    EU_ES("eu-ES", "Basque_Spain"),
    FA("fa", "Farsi"),
    FA_IR("fa-IR", "Farsi_Iran"),
    FI("fi", "Finnish"),
    FI_FI("fi-FI", "Finnish_Finland"),
    FO("fo", "Faroese"),
    FO_FO("fo-FO", "Faroese_Faroe_Islands"),
    FR("fr", "French"),
    FR_BE("fr-BE", "French_Belgium"),
    FR_CA("fr-CA", "French_Canada"),
    FR_CH("fr-CH", "French_Switzerland"),
    FR_FR("fr-FR", "French_France"),
    FR_LU("fr-LU", "French_Luxembourg", Country.LU),
    FR_MC("fr-MC", "French_Principality_of_Monaco"),
    GL("gl", "Galician"),
    GL_ES("gl-ES", "Galician_Spain"),
    GU("gu", "Gujarati"),
    GU_IN("gu-IN", "Gujarati_India"),
    HE("he", "Hebrew"),
    HE_IL("he-IL", "Hebrew_Israel"),
    HI("hi", "Hindi"),
    HI_IN("hi-IN", "Hindi_India"),
    HR("hr", "Croatian"),
    HR_BA("hr-BA", "Croatian_Bosnia_and_Herzegovina"),
    HR_HR("hr-HR", "Croatian_Croatia"),
    HU("hu", "Hungarian"),
    HU_HU("hu-HU", "Hungarian_Hungary"),
    HY("hy", "Armenian"),
    HY_AM("hy-AM", "Armenian_Armenia"),
    ID("id", "Indonesian"),
    ID_ID("id-ID", "Indonesian_Indonesia"),
    IS("is", "Icelandic"),
    IS_IS("is-IS", "Icelandic_Iceland"),
    IT("it", "Italian"),
    IT_CH("it-CH", "Italian_Switzerland"),
    IT_IT("it-IT", "Italian_Italy"),
    JA("ja", "Japanese"),
    JA_JP("ja-JP", "Japanese_Japan"),
    KA("ka", "Georgian"),
    KA_GE("ka-GE", "Georgian_Georgia"),
    KK("kk", "Kazakh"),
    KM_KH("km", "Khmer_Cambodia"),
    KK_KZ("kk-KZ", "Kazakh_Kazakhstan"),
    KN("kn", "Kannada"),
    KN_IN("kn-IN", "Kannada_India"),
    KO("ko", "Korean"),
    KO_KR("ko-KR", "Korean_Korea"),
    KOK("kok", "Konkani"),
    KOK_IN("kok-IN", "Konkani_India"),
    KY("ky", "Kyrgyz"),
    KY_KG("ky-KG", "Kyrgyz_Kyrgyzstan"),
    LO_LA("lo-LA", "Lao"),
    LT("lt", "Lithuanian"),
    LT_LT("lt-LT", "Lithuanian_Lithuania"),
    LV("lv", "Latvian"),
    LV_LV("lv-LV", "Latvian_Latvia"),
    MI("mi", "Maori"),
    MI_NZ("mi-NZ", "Maori_New_Zealand"),
    MK("mk", "FYRO_Macedonian"),
    MK_MK("mk-MK", "FYRO_Macedonian_Former_Yugoslav_Republic_of_Macedonia"),
    MN("mn", "Mongolian"),
    MN_MN("mn-MN", "Mongolian_Mongolia"),
    MR("mr", "Marathi"),
    MR_IN("mr-IN", "Marathi_India"),
    MS("ms", "Malay"),
    MS_BN("ms-BN", "Malay_Brunei_Darussalam"),
    MS_MY("ms-MY", "Malay_Malaysia"),
    MT("mt", "Maltese"),
    MT_MT("mt-MT", "Maltese_Malta"),
    MY_MM("my-MM", "Burmese_Myanmar"),
    NB("nb", "l"),
    NB_NO("nb-NO", "Norwegian"),
    NL("nl", "Dutch"),
    NL_BE("nl-BE", "Dutch_Belgium"),
    NL_NL("nl-NL", "Dutch_Netherlands"),
    NN_NO("nn-NO", "Norwegian_NynorskNorway"),
    NS("ns", "Northern_Sotho"),
    NS_ZA("ns-ZA", "Northern_Sotho_South_Africa"),
    PA("pa", "Punjabi"),
    PA_IN("pa-IN", "Punjabi_India"),
    PL("pl", "Polish"),
    PL_PL("pl-PL", "Polish_Poland"),
    PS("ps", "Pashto"),
    PS_AR("ps-AR", "Pashto_Afghanistan"),
    PT("pt", "Portuguese"),
    PT_BR("pt-BR", "Portuguese_Brazil"),
    PT_PT("pt-PT", "Portuguese_Portugal"),
    QU("qu", "Quechua"),
    QU_BO("qu-BO", "Quechua_Bolivia"),
    QU_EC("qu-EC", "Quechua_Ecuador"),
    QU_PE("qu-PE", "Quechua_Peru"),
    RO("ro", "Romanian"),
    RO_RO("ro-RO", "Romanian_Romania"),
    RU("ru", "Russian"),
    RU_RU("ru-RU", "Russian_Russia"),
    SA("sa", "Sanskrit"),
    SA_IN("sa-IN", "Sanskrit_India"),
    SE("se", "Sami_Northern"),
    SE_FI("se-FI", "Sami_NorthernFinland"),
    SE_NO("se-NO", "Sami_NorthernNorway"),
    SE_SE("se-SE", "Sami_NorthernSweden"),
    SK("sk", "Slovak"),
    SK_SK("sk-SK", "Slovak_Slovakia"),
    SL("sl", "Slovenian"),
    SL_SI("sl-SI", "Slovenian_Slovenia"),
    SQ("sq", "Albanian"),
    SQ_AL("sq-AL", "Albanian_Albania"),
    SR_BA("sr-BA", "Serbian_LatinBosnia_and_Herzegovina"),
    SR_SP("sr-SP", "Serbian_LatinSerbia_and_Montenegro"),
    SV("sv", "Swedish"),
    SV_FI("sv-FI", "Swedish_Finland"),
    SV_SE("sv-SE", "Swedish_Sweden"),
    SW("sw", "Swahili"),
    SW_KE("sw-KE", "Swahili_Kenya"),
    SYR("syr", "Syriac"),
    SYR_SY("syr-SY", "Syriac_Syria"),
    TA("ta", "Tamil"),
    TA_IN("ta-IN", "Tamil_India"),
    TE("te", "Telugu"),
    TE_IN("te-IN", "Telugu_India"),
    TH("th", "Thai", Country.TH),
    TH_TH("th-TH", "Thai", Country.TH),
    TL("tl", "Tagalog", Country.PH),
    TL_PH("tl-PH", "Tagalog", Country.PH),
    TN("tn", "Tswana", Country.ZA),
    TN_ZA("tn-ZA", "Tswana", Country.ZA),
    TR("tr", "Turkish", Country.TR),
    TR_TR("tr-TR", "Turkish", Country.TR),
    TT("tt", "Tatar", Country.RU),
    TT_RU("tt-RU", "Tatar", Country.RU),
    TS("ts", "Tsonga", Country.ZA),
    UK("uk", "Ukrainian", Country.UA),
    UK_UA("uk-UA", "Ukrainian", Country.UA),
    UR("ur", "Urdu", Country.PK),
    UR_PK("ur-PK", "Urdu", Country.PK),
    UZ("uz", "Uzbek", Country.UZ),
    UZ_UZ("uz-UZ", "Uzbek", Country.UZ),
    VI("vi", "Vietnamese", Country.VN),
    VI_VN("vi-VN", "Vietnamese", Country.VN),
    XH("xh", "Xhosa", Country.ZA),
    XH_ZA("xh-ZA", "Xhosa", Country.ZA),
    ZH("zh", "Chinese", Country.CN),
    ZH_CN("zh-CN", "Chinese", Country.CN),
    ZH_HK("zh-HK", "Chinese", Country.HK),
    ZH_MO("zh-MO", "Chinese", Country.MO),
    ZH_SG("zh-SG", "Chinese", Country.SG),
    ZH_TW("zh-TW", "Chinese", "中文", Country.TW),
    ZU("zu", "Zulu", "isiZulu", Country.ZA),
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

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return String.format("LanguageOld{name='%s', code='%s'}", name, code);
    }

    public enum Direction {
        RTL, LTR
    }

}
