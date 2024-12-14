package com.example;

public class salle {
    private int id_salle;
    private String nom_salle;
    private int capacite;

    // Constructor
    public salle(int id_salle, String nom_salle, int capacite) {
        this.id_salle = id_salle;
        this.nom_salle = nom_salle;
        this.capacite = capacite;
    }

    // Getters
    public int getId_salle() {
        return id_salle;
    }

    public String getNom_salle() {
        return nom_salle;
    }

    public int getCapacite() {
        return capacite;
    }

    // Setters
    public void setId_salle(int id_salle) {
        this.id_salle = id_salle;
    }

    public void setNom_salle(String nom_salle) {
        this.nom_salle = nom_salle;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
    @Override
    public String toString(){
        return "id : " + id_salle+  " nom du salle: "+ nom_salle+"  capacité:  "+capacite;
    }
}
