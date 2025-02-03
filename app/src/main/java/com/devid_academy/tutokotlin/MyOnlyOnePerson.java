package com.devid_academy.tutokotlin;

public class MyOnlyOnePerson {

    private static MyOnlyOnePerson instance;
    private String nom, prenom;

    private MyOnlyOnePerson(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
    private MyOnlyOnePerson(){}

    public static MyOnlyOnePerson getInstance() {
        if(instance == null)
            instance = new MyOnlyOnePerson();
        return instance;
    }
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
