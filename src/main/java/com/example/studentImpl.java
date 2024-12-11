package com.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class studentImpl implements studentDao {
    private Connection conn;

    public studentImpl(db  conn) {
        this.conn = conn.getConnection();
    }

    @Override
    public void addUser(student user) {
        try {
            String sql = "INSERT INTO students (id, nom, prenom) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user.getId());
            pstmt.setString(2, user.getNom());
            pstmt.setString(3, user.getPrenom());
         
            pstmt.executeUpdate();
          
            System.out.println("added");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public student getUserById(int id) {
        student user = null;
        try {
            String sql = "SELECT * FROM students WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new student(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("prenom")
                  
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<student> getAllUsers() {
        List<student> users = new ArrayList<>();
        try {
            String sql = "SELECT * FROM students";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                users.add(new student(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("prenom")
                  
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }


    @Override
    public void deleteUser(int id) {
        try {
            String sql = "DELETE FROM students WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(student user) {
        try {
            String sql = "UPDATE students SET nom= ?, prenom= ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getNom());
            pstmt.setString(2, user.getPrenom());
     
            pstmt.setInt(3, user.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

 

