package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserImpl implements UserDao {
    private Connection conn;

    public UserImpl(db conn) {
        this.conn = conn.getConnection();
    }

    @Override
    public void addUser(User user) {
        try {
            String sql = "INSERT INTO users (id, nom, prenom, email, type) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user.getId());
            pstmt.setString(2, user.getNom());
            pstmt.setString(3, user.getPrenom());
            pstmt.setString(4, user.getEmail());
            pstmt.setString(5, user.getType());
            pstmt.executeUpdate();
            System.out.println("User added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        try {
            String sql = "SELECT * FROM users WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new User(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("email"),
                    rs.getString("type")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            String sql = "SELECT * FROM users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                users.add(new User(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("email"),
                    rs.getString("type")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void updateUser(User user) {
        try {
            String sql = "UPDATE users SET nom = ?, prenom = ?, email = ?, type = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getNom());
            pstmt.setString(2, user.getPrenom());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getType());
            pstmt.setInt(5, user.getId());
            pstmt.executeUpdate();
            System.out.println("User updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int id) {
        try {
            String sql = "DELETE FROM users WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("User deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
