package com.example.infosport;

public class MainModel1 {
    Integer langL;
    String langN, langD, langt,langRe;

    public MainModel1(Integer langLogo, String langName, String langDes, String langtime,String langRe) {
        this.langL = langLogo;
        this.langN = langName;
        this.langD = langDes;
        this.langt = langtime;
        this.langRe = langRe;
    }

    public Integer getLangLogo() {
        return langL;
    }

    public String getLangName() {
        return langN;
    }

    public String getLangDes() {
        return langD;
    }

    public String getLangtime() {
        return langt;
    }

    public String getLangRe() {
        return langRe;
    }
}
