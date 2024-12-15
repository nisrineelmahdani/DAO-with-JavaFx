package com.example;

import java.util.List;

public interface reservationDao {
      void addReservation(reservation  reservation);
    reservation getReservationById(int id);
    List<reservation> getAllReservations();
    void updateReservation(reservation reservation);
    void deleteReservation(int id);
}
