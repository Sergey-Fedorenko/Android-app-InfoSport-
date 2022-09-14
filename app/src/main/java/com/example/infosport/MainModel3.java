package com.example.infosport;

public class MainModel3 {
    Integer langLog;
    String langNam, langDesc, langtim,langRec;

    public MainModel3(Integer langLog, String langNam, String langDesc, String langtim,String langRec) {
        this.langLog = langLog;
        this.langNam = langNam;
        this.langDesc = langDesc;
        this.langtim = langtim;
        this.langRec = langRec;
    }

    public Integer getLangLogo() {
        return langLog;
    }

    public String getLangName() {
        return langNam;
    }

    public String getLangDes() {
        return langDesc;
    }

    public String getLangtime() {
        return langtim;
    }

    public String getLangRec() {
        return langRec;
    }
}
