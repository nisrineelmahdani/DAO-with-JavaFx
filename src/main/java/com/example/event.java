package com.example;

public class event {
    private int id;
    private String nom;
    private String date;
    private String description;
     public event(int id, String nom, String date, String description){
        this.id = id;
        this.nom = nom;
        this.date= date;
        this.description=description;
     }
   

 public int getId() {
    return id;
}


public void setId(int id) {
    this.id = id;
}


public String getNom() {
    return nom;
}

public void setNom(String nom) {
    this.nom = nom;
}


public String getDate() {
    return date;
}

public void setDate(String date) {
    this.date = date;
}


public String getDescription() {
    return description;
}


public void setDescription(String description) {
    this.description = description;
}


public String toString() {
    return "Event{" +
            "id=" + id +
            ", nom='" + nom + '\'' +
            ", date='" + date + '\'' +
            ", description='" + description + '\'' +
            '}';
}

}
