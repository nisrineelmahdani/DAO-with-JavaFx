package com.example;

import java.util.List;

public interface salleDao {
     void addSalle(salle  salle);
    salle getSalleById(int id);
    List<salle> getAllSalles();
    void updateSalle(salle salle);
    void deleteSalle(int id);
}
