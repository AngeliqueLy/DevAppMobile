package com.example.tp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class Langue extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_langue);
        setTitle(getResources().getString(R.string.language));

        //Bouton pour les différentes langues
        Button fr = findViewById(R.id.fr);
        Button zh = findViewById(R.id.zh);
        Button en = findViewById(R.id.en);
        Button th = findViewById(R.id.th);
        Button vi = findViewById(R.id.vi);
        Button kr = findViewById(R.id.kr);
        Button jp = findViewById(R.id.jp);
        Intent intentpop = new Intent(Langue.this, PopularMovie.class);
        ListApp app = (ListApp) getApplicationContext();

        fr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //On sélectionne la langue pour l'appel api
                    app.setLangueselectionner("fr-FR")  ;

        //On change la langue locale du tel
                Locale myLocale = new Locale("fr");
                Resources res = getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                Configuration conf = res.getConfiguration();
                conf.locale = myLocale;
                res.updateConfiguration(conf, dm);
                    startActivity(intentpop);
                    finish();

            }
        });
       en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.setLangueselectionner("en-EN")  ;

                Locale myLocale = new Locale("en");
                Resources res = getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                Configuration conf = res.getConfiguration();
                conf.locale = myLocale;
                res.updateConfiguration(conf, dm);
                startActivity(intentpop);
                finish();
                startActivity(intentpop);
                finish();

            }
        });
        vi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.setLangueselectionner("vi-VN")  ;

                Locale myLocale = new Locale("vi");
                Resources res = getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                Configuration conf = res.getConfiguration();
                conf.locale = myLocale;
                res.updateConfiguration(conf, dm);
                startActivity(intentpop);
                finish();
                startActivity(intentpop);
                finish();

            }
        });
       zh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.setLangueselectionner("zh-CN")  ;

                Locale myLocale = new Locale("zh");
                Resources res = getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                Configuration conf = res.getConfiguration();
                conf.locale = myLocale;
                res.updateConfiguration(conf, dm);
                startActivity(intentpop);
                finish();

            }
        });
        jp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.setLangueselectionner("ja-JP")  ;

                Locale myLocale = new Locale("ja");
                Resources res = getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                Configuration conf = res.getConfiguration();
                conf.locale = myLocale;
                res.updateConfiguration(conf, dm);
                startActivity(intentpop);
                finish();

            }
        });
        th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.setLangueselectionner("th-TH")  ;

                Locale myLocale = new Locale("th");
                Resources res = getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                Configuration conf = res.getConfiguration();
                conf.locale = myLocale;
                res.updateConfiguration(conf, dm);
                startActivity(intentpop);
                finish();

            }
        });
        kr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.setLangueselectionner("ko-KR")  ;

                Locale myLocale = new Locale("ko");
                Resources res = getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                Configuration conf = res.getConfiguration();
                conf.locale = myLocale;
                res.updateConfiguration(conf, dm);
                startActivity(intentpop);
                finish();

            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bottom_nav_menu, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intentpop= new Intent(Langue.this, PopularMovie.class);
        Intent intentsear = new Intent(Langue.this, Search.class);
        Intent intentup = new Intent(Langue.this, UpcomingMovie.class);
        switch (item.getItemId()) {

            case R.id.popular:
                startActivity(intentpop);
                finish();

                return true;
            case R.id.favorite:
                return true;
            case R.id.upcoming:
                startActivity(intentup);
                finish();
                return true;
            case R.id.research:
                startActivity(intentsear);
                finish();

                return true;
        }
        return false;
    }

    }
