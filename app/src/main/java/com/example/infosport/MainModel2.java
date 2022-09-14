package com.example.infosport;

public class MainModel2 {
    Integer langLo;
    String langNa, langDe, langti,langRe;

    public MainModel2(Integer langLo, String langNa, String langDe, String langti,String langRe) {
        this.langLo = langLo;
        this.langNa = langNa;
        this.langDe = langDe;
        this.langti = langti;
        this.langRe = langRe;
    }

    public Integer getLangLogo() {
        return langLo;
    }

    public String getLangName() {
        return langNa;
    }

    public String getLangDes() {
        return langDe;
    }

    public String getLangtime() {
        return langti;
    }

    public String getLangRe() {
        return langRe;
    }
}
