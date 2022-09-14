package com.example.infosport;

public class MainModel4 {
    Integer langL;
    String langN, langD, langt,langRece;

    public MainModel4(Integer langLogo, String langName, String langDes, String langtime,String langRece) {
        this.langL = langLogo;
        this.langN = langName;
        this.langD = langDes;
        this.langt = langtime;
        this.langRece =langRece;
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

    public String getLangRece() {
        return langRece;
    }
}