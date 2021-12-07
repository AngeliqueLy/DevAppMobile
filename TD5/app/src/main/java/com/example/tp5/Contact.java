package com.example.tp5;



public class Contact {
    private String nom;
    private String prenom;
    private String image;

    public Contact(String n, String p, String image){

        this.nom = n;
        this.prenom = p;
        this.image = image;

    }

    public String getPrenom() {
        return this.prenom;
    }
    public String getNom() {
        return this.nom;
    }
    public String getImage() {
        return this.image;
    }

}
