package org.papaja.commons.geo;

import static java.lang.String.format;

@SuppressWarnings({"unused", "SpellCheckingInspection"})
public enum Locale {

    AF_ZA(Language.AF, Country.ZA),
    AM_ET(Language.AM, Country.ET),
    AR_AE(Language.AR, Country.AE),
    AR_BH(Language.AR, Country.BH),
    AR_DZ(Language.AR, Country.DZ),
    AR_EG(Language.AR, Country.EG),
    AR_IQ(Language.AR, Country.IQ),
    AR_JO(Language.AR, Country.JO),
    AR_KW(Language.AR, Country.KW),
    AR_LB(Language.AR, Country.LB),
    AR_LY(Language.AR, Country.LY),
    AR_MA(Language.AR, Country.MA),
    AR_OM(Language.AR, Country.OM),
    AR_QA(Language.AR, Country.QA),
    AR_SA(Language.AR, Country.SA),
    AR_SY(Language.AR, Country.SY),
    AR_TN(Language.AR, Country.TN),
    AR_YE(Language.AR, Country.YE),
    AZ_AZ(Language.AZ, Country.AZ),
    BE_BY(Language.BE, Country.BY),
    BN_BD(Language.BN, Country.BD),
    BG_BG(Language.BG, Country.BG),
    BS_BA(Language.BS, Country.BA),
    CA_ES(Language.CA, Country.ES),
    CS_CZ(Language.CS, Country.CZ),
    CY_GB(Language.CY, Country.GB),
    DA_DK(Language.DA, Country.DK),
    DE_AT(Language.DE, Country.AT),
    DE_CH(Language.DE, Country.CH),
    DE_DE(Language.DE, Country.DE),
    DE_LI(Language.DE, Country.LI),
    DE_LU(Language.DE, Country.LU),
    DV_MV(Language.DV, Country.MV),
    EL_GR(Language.EL, Country.GR),
    EN_AU(Language.EN, Country.AU),
    EN_BZ(Language.EN, Country.BZ),
    EN_CA(Language.EN, Country.CA),
    EN_GB(Language.EN, Country.GB),
    EN_IE(Language.EN, Country.IE),
    EN_JM(Language.EN, Country.JM),
    EN_NZ(Language.EN, Country.NZ),
    EN_PH(Language.EN, Country.PH),
    EN_US(Language.EN, Country.US),
    EN_ZA(Language.EN, Country.ZA),
    EN_ZW(Language.EN, Country.ZW),
    ES_AR(Language.ES, Country.AR),
    ES_BO(Language.ES, Country.BO),
    ES_CL(Language.ES, Country.CL),
    ES_CO(Language.ES, Country.CO),
    ES_CR(Language.ES, Country.CR),
    ES_DO(Language.ES, Country.DO),
    ES_EC(Language.ES, Country.EC),
    ES_ES(Language.ES, Country.ES),
    ES_GT(Language.ES, Country.GT),
    ES_HN(Language.ES, Country.HN),
    ES_MX(Language.ES, Country.MX),
    ES_NI(Language.ES, Country.NI),
    ES_PA(Language.ES, Country.PA),
    ES_PE(Language.ES, Country.PE),
    ES_PR(Language.ES, Country.PR),
    ES_PY(Language.ES, Country.PY),
    ES_SV(Language.ES, Country.SV),
    ES_UY(Language.ES, Country.UY),
    ES_VE(Language.ES, Country.VE),
    ET_EE(Language.ET, Country.EE),
    EU_ES(Language.EU, Country.ES),
    FA_IR(Language.FA, Country.IR),
    FI_FI(Language.FI, Country.FI),
    FO_FO(Language.FO, Country.FO),
    FR_BE(Language.FR, Country.BE),
    FR_CA(Language.FR, Country.CA),
    FR_CH(Language.FR, Country.CH),
    FR_FR(Language.FR, Country.FR),
    FR_LU(Language.FR, Country.LU),
    FR_MC(Language.FR, Country.MC),
    GL_ES(Language.GL, Country.ES),
    GU_IN(Language.GU, Country.IN),
    HE_IL(Language.HE, Country.IL),
    HI_IN(Language.HI, Country.IN),
    HR_BA(Language.HR, Country.BA),
    HR_HR(Language.HR, Country.HR),
    HU_HU(Language.HU, Country.HU),
    HY_AM(Language.HY, Country.AM),
    IN_ID(Language.IN, Country.ID),
    IS_IS(Language.IS, Country.IS),
    IT_CH(Language.IT, Country.CH),
    IT_IT(Language.IT, Country.IT),
    JA_JP(Language.JA, Country.JP),
    KA_GE(Language.KA, Country.GE),
    KM_KH(Language.KM, Country.KH),
    KK_KZ(Language.KK, Country.KZ),
    KN_IN(Language.KN, Country.IN),
    KO_KR(Language.KO, Country.KR),
    KOK_IN(Language.KOK, Country.IN),
    KY_KG(Language.KY, Country.KG),
    LO_LA(Language.LO, Country.LA),
    LT_LT(Language.LT, Country.LT),
    LV_LV(Language.LV, Country.LV),
    MI_NZ(Language.MI, Country.NZ),
    MK_MK(Language.MK, Country.MK),
    MN_MN(Language.MN, Country.MN),
    MR_IN(Language.MR, Country.IN),
    MS_BN(Language.MS, Country.BN),
    MS_MY(Language.MS, Country.MY),
    MT_MT(Language.MT, Country.MT),
    MY_MM(Language.MY, Country.MM),
    NB_NO(Language.NB, Country.NO),
    NL_BE(Language.NL, Country.BE),
    NL_NL(Language.NL, Country.NL),
    NS_ZA(Language.NS, Country.ZA),
    PA_IN(Language.PA, Country.IN),
    PL_PL(Language.PL, Country.PL),
    PS_AF(Language.PS, Country.AF),
    PT_BR(Language.PT, Country.BR),
    PT_PT(Language.PT, Country.PT),
    QU_BO(Language.QU, Country.BO),
    QU_EC(Language.QU, Country.EC),
    QU_PE(Language.QU, Country.PE),
    RO_RO(Language.RO, Country.RO),
    RU_RU(Language.RU, Country.RU),
    SA_IN(Language.SA, Country.IN),
    SE_FI(Language.SE, Country.FI),
    SE_NO(Language.SE, Country.NO),
    SE_SE(Language.SE, Country.SE),
    SK_SK(Language.SK, Country.SK),
    SL_SI(Language.SL, Country.SI),
    SQ_AL(Language.SQ, Country.AL),
    SR_BA(Language.SR, Country.BA),
    SR_RS(Language.SR, Country.RS),
    SV_FI(Language.SV, Country.FI),
    SV_SE(Language.SV, Country.SE),
    SW_KE(Language.SW, Country.KE),
    SYR_SY(Language.SYR, Country.SY),
    TA_IN(Language.TA, Country.IN),
    TE_IN(Language.TE, Country.IN),
    TH_TH(Language.TH, Country.TH),
    TL_PH(Language.TL, Country.PH),
    TN_ZA(Language.TN, Country.ZA),
    TR_TR(Language.TR, Country.TR),
    TT_RU(Language.TT, Country.RU),
    UK_UA(Language.UK, Country.UA),
    UR_PK(Language.UR, Country.PK),
    UZ_UZ(Language.UZ, Country.UZ),
    VI_VN(Language.VI, Country.VN),
    XH_ZA(Language.XH, Country.ZA),
    ZH_CN(Language.ZH, Country.CN),
    ZH_HK(Language.ZH, Country.HK),
    ZH_MO(Language.ZH, Country.MO),
    ZH_SG(Language.ZH, Country.SG),
    ZH_TW(Language.ZH, Country.TW),
    ZU_ZA(Language.ZU, Country.ZA);

    private Language language;
    private Country  country;

    Locale(Language language, Country country) {
        this.language = language;
        this.country = country;
    }

    public Language getLanguage() {
        return language;
    }

    public Country getCountry() {
        return country;
    }

    public String getCode() {
        return format("%s_%s", language.getCode(), country.getCode());
    }

    public static Locale getLocale(String value) {
        return Enum.valueOf(Locale.class, value.toUpperCase());
    }

}
