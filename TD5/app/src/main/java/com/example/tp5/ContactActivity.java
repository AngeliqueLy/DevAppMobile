package com.example.tp5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {
    List<Contact> contacts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactactivity);
        //Recherche du recyclerview  dans le layout de l'activité
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);

        //Initialisation des contacts
        contacts.add(new Contact("Roronoa","Zoro","https://www.origamigne.com/shop/wp-content/uploads/2018/08/roronoa_zoro_evolution_origamigne_Migne_Huynh_cadre-1.jpg"));
       contacts.add(new Contact("Ackerman","Rivaille","https://www.thpanorama.com/img/images/levi-ackerman-historia-personalidad-y-frases.jpeg"));
        contacts.add(new Contact("Lamperouge","Lelouch","https://static.wikia.nocookie.net/codegeass/images/6/6a/LelouchviBritannia.jpg/revision/latest?cb=20120107132514"));
        contacts.add(new Contact("Tomioka","Giyu","https://d3isma7snj3lcx.cloudfront.net/images/news/30/3050836575/demon-slayer-la-minute-de-giyu-tomioka-7e2a4312.jpg"));
        contacts.add(new Contact("Mustang","Roy","https://static.wikia.nocookie.net/fma/images/3/3f/RoyMustangAnime.jpg/revision/latest?cb=20140311090441&path-prefix=fr"));
        contacts.add(new Contact("Ichimaru","Gin","https://besthqwallpapers.com/Uploads/14-9-2018/65836/thumb2-gin-ichimaru-close-up-manga-blue-eyes-bleach.jpg"));


        //Création d'un adapter avec initialisation du constructeur avec notre liste de conatct
        ContactsAdapter adapter = new ContactsAdapter(contacts);
        //On notifie au recyclerview notre adapter
        rvContacts.setAdapter(adapter);
        //On déclare quelle type de layoutManager on désire
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
    }
    }
