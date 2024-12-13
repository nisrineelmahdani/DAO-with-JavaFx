package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class eventImpl  implements eventDao{
         private Connection conn;

    public eventImpl(db  conn) {
        this.conn = conn.getConnection();
    }

    @Override
    public void addEvent(event event) {
       try {
            String sql = "INSERT INTO events (id, nom,date,description ,id_user ) VALUES (?, ?, ?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, event.getId());
            pstmt.setString(2, event.getNom());
            pstmt.setString(3, event.getDate());
            pstmt.setString(4, event.getDescription());
            pstmt.setInt(5, event.getUserId());
         
            pstmt.executeUpdate();
          
            System.out.println(" event added");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public event getEventById(int id) {
        event event = null;
       try {
        String sql = "SELECT * FROM events WHERE id= ? ";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
         ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                event = new event(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("date"),
                    rs.getString("description"),
                    rs.getInt("id_user")
                  
                );
            }
       } catch (Exception e) {
       
       }
       return event;
    }

    @Override
    public List<event> getAllEvents() {
        List <event> events = new ArrayList<>();
       try {
        String sql = "SELECT * FROM events";
        Statement stmt = conn.createStatement();
        
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            events.add(new event(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getString("date"),
                rs.getString("description"),
                rs.getInt("id_user")
            ));
        }
        
       } catch (Exception e) {
      
       }
       return events;
    }

    @Override
    public void updateEvent(event event) {
        try {
            String sql = "UPDATE events SET nom= ?, date= ?, description= ?, id_user= ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, event.getNom());
            pstmt.setString(2, event.getDate());
     
            pstmt.setString(3, event.getDescription());
            pstmt.setInt(4, event.getUserId());
            pstmt.setInt(5, event.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEvent(int id) {
        try {
            String sql = "DELETE FROM events WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
