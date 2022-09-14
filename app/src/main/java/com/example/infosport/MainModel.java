package com.example.infosport;

import java.io.Serializable;

public class MainModel implements Serializable {
    Integer langLogo;
    String langName,langDes,langtime, langRecipe;

    public MainModel(Integer langLogo, String langName,String langDes, String langtime, String langRecipe) {
        this.langLogo = langLogo;
        this.langName = langName;
        this.langDes = langDes;
        this.langtime = langtime;
        this.langRecipe = langRecipe;
    }

    public Integer getLangLogo() {
        return langLogo;
    }

    public String getLangName() {
        return langName;
    }

    public String getLangDes() {
        return langDes;
    }

    public String getLangtime() {
        return langtime;
    }

    public String getLangRecipe() {
        return langRecipe;
    }
}
