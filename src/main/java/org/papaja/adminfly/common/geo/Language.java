package org.papaja.adminfly.common.geo;

@SuppressWarnings({"unused", "SpellCheckingInspection"})
public enum Language {

    AF("af", "Afrikaans", "Afrikaans"),
    AM("am", "Amharic", "ኣማርኛ"),
    AR("ar", "Arabic", "العربية"),
    AZ("az", "Azerbaijani", "Azərbaycan dili"),
    BE("be", "Belarusian", "Беларуская"),
    BN("bn", "Bengali", "বাংলা"),
    BG("bg", "Bulgarian", "Български език"),
    BS("bs", "Bosnian", "Босански"),
    CA("ca", "Catalan", "Català"),
    CS("cs", "Czech", "Čeština"),
    CY("cy", "Welsh", "Cymraeg"),
    DA("da", "Danish", "Dansk"),
    DE("de", "German", "Deutsch"),
    DV("dv", "Maldivian", "ދިވެހި"),
    EL("el", "Greek", "Ελληνικά"),
    EN("en", "English", "English"),
    ES("es", "Spanish", "Español"),
    ET("et", "Estonian", "Eesti"),
    EU("eu", "Basque", "Euskara"),
    FA("fa", "Farsi", "فارسی"),
    FI("fi", "Finnish", "Suomi"),
    FO("fo", "Faroese", "Føroyskt"),
    FR("fr", "French", "Français"),
    GL("gl", "Galician", "Galego"),
    GU("gu", "Gujarati", "ગુજરાતી"),
    HE("he", "Hebrew", "עברית"),
    HI("hi", "Hindi", "फिजी बात"),
    HR("hr", "Croatian", "Hrvatski"),
    HU("hu", "Hungarian", "Magyar"),
    HY("hy", "Armenian", "Հայերեն"),
    ID("id", "Indonesian", "Bahasa Indonesia"),
    IS("is", "Icelandic", "Íslenska"),
    IT("it", "Italian", "Italiano"),
    JA("ja", "Japanese", "日本語"),
    KA("ka", "Georgian", "ქართული"),
    KM("km", "Khmer", "ភាសាខ្មែរ"),
    KK("kk", "Kazakh", "Қазақ Tілі"),
    KN("kn", "Kannada", "ಕನ್ನಡ"),
    KO("ko", "Korean", "한국어"),
    KOK("kok", "Konkani", "കൊങ്കണി"),
    KY("ky", "Kyrgyz", "قىرعىزچا"),
    LO("lo", "Lao", "ພາສາລາວ"),
    LT("lt", "Lithuanian", "Lietuvių"),
    LV("lv", "Latvian", "Latviešu"),
    MI("mi", "Maori", "Māori"),
    MK("mk", "Macedonian", "Mакедонски"),
    MN("mn", "Mongolian", "Монгол Хэл"),
    MR("mr", "Marathi", "मराठी"),
    MS("ms", "Malay", "بهاس جاوي,"),
    MT("mt", "Maltese", "Malti"),
    MY("my", "Burmese", "မြန်မာစာ"),
    NB("nb", "Norwegian", "Norsk"),
    NL("nl", "Dutch", "Dutch"),
    NS("ns", "Northern Sotho", "Sesotho sa Leboa"),
    PA("pa", "Punjabi", "پنجابی"),
    PL("pl", "Polish", "Polski"),
    PS("ps", "Pashto", "پښتو"),
    PT("pt", "Portuguese", "Português"),
    QU("qu", "Quechua", "Runasimi"),
    RO("ro", "Romanian", "Roumanian"),
    RU("ru", "Russian", "Русский"),
    SA("sa", "Sanskrit", "संस्कृतम्"),
    SE("se", "Sami", "Sami"),
    SK("sk", "Slovak", "Slovakian"),
    SL("sl", "Slovenian", "Slovene"),
    SQ("sq", "Albanian", "Gjuha shqipe"),
    SR("sr", "Serbian", "Српски"),
    SV("sv", "Swedish", "Svenska"),
    SW("sw", "Swahili", "Kiswahili"),
    SYR("syr", "Syriac", "ܠܫܢܐ ܣܘܪܝܝܐ"),
    TA("ta", "Tamil", "தமிழ்"),
    TE("te", "Telugu", "తెలుగు"),
    TH("th", "Thai", "ภาษาไทย"),
    TL("tl", "Tagalog", "Tagalog"),
    TN("tn", "Tswana", "Setswana"),
    TR("tr", "Turkish", "Türkçe"),
    TT("tt", "Tatar", "Татарча"),
    UK("uk", "Ukrainian", "Українська"),
    UR("ur", "Urdu", "اُردُو"),
    UZ("uz", "Uzbek", "Oʻzbek "),
    VI("vi", "Vietnamese", "Tiếng"),
    XH("xh", "Xhosa", "Xhosa"),
    ZH("zh", "Chinese", "汉语"),
    ZU("zu", "Zulu", "isiZulu");

    private String  code;
    private String  local;
    private String  name;

    Language(String code, String name, String local) {
        this.code = code;
        this.local = local;
        this.name = name;
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

    @Override
    public String toString() {
        return String.format("Language{name='%s', local = '%s' code='%s'}", name, local, code);
    }

    public enum Direction {RTL, LTR}

}
