package com.example;

public class reservation {
    private int id;
    private int id_user;
    private int id_event;
    private  int id_salle;
    private int id_terrain;
    private String date_reservation;
    public reservation(int id, int id_user, int id_event, int id_salle, int id_terrain, String date_reservation) {
        this.id = id;
        this.id_user = id_user;
        this.id_event = id_event;
        this.id_salle = id_salle;
        this.id_terrain = id_terrain;
        this.date_reservation = date_reservation;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public int getId_salle() {
        return id_salle;
    }

    public void setId_salle(int id_salle) {
        this.id_salle = id_salle;
    }

    public int getId_terrain() {
        return id_terrain;
    }

    public void setId_terrain(int id_terrain) {
        this.id_terrain = id_terrain;
    }

    public String getDate_reservation() {
        return date_reservation;
    }

    public void setDate_reservation(String date_reservation) {
        this.date_reservation = date_reservation;
    }

    // Méthode toString pour afficher les informations d'une réservation
    @Override
    public String toString() {
        return "Reservation {" +
                "id=" + id +
                ", id_user=" + id_user +
                ", id_event=" + id_event +
                ", id_salle=" + id_salle +
                ", id_terrain=" + id_terrain +
                ", date_reservation='" + date_reservation + '\'' +
                '}';
    }
}
