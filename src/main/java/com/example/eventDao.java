package com.example;

import java.util.List;

public interface eventDao {
  
    void addEvent(event event );
    event getEventById(int id);
    List<event> getAllEvents();
    void updateEvent(event  event);
    void deleteEvent(int id);

    
}
