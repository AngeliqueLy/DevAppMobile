package com.example.tp;

import java.util.ArrayList;


public class ListApp extends android.app.Application {


    String langueselectionner;
    String languelocale;

    @Override
    public void onCreate() {
        super.onCreate();
        this.langueselectionner ="fr-FR";
        this.languelocale ="fr";

    }

    public String getLangueselectionner() {
        return langueselectionner;
    }

    public void setLangueselectionner(String langue) {
        this.langueselectionner = langue;
    }

    public String getLanguelocale() {
        return languelocale;
    }

    public void setLanguelocale(String languelocale) {
        this.languelocale = languelocale;
    }
}