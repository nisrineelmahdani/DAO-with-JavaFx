package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class salleDaoImpl implements salleDao {

    private Connection conn;

    public salleDaoImpl(db conn) {
        this.conn = conn.getConnection();
    }

    @Override
    public void addSalle(salle salle) {
        try {
            String sql = "INSERT INTO salles (id_salle, nom_salle, capacite) VALUES(?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, salle.getId_salle());
            pstmt.setString(2, salle.getNom_salle());
            pstmt.setInt(3, salle.getCapacite());
            pstmt.executeUpdate();
            System.out.println("Salle added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public salle getSalleById(int id) {
        salle salle = null;
        try {
            String sql = "SELECT * FROM salles WHERE id_salle = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                salle = new salle(
                        rs.getInt("id_salle"),
                        rs.getString("nom_salle"),
                        rs.getInt("capacite")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salle;
    }

    @Override
    public List<salle> getAllSalles() {
        List<salle> salles = new ArrayList<>();
        try {
            String sql = "SELECT * FROM salles";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                salle salle = new salle(
                        rs.getInt("id_salle"),
                        rs.getString("nom_salle"),
                        rs.getInt("capacite")
                );
                salles.add(salle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salles;
    }

    @Override
    public void updateSalle(salle salle) {
        try {
            String sql = "UPDATE salles SET nom_salle = ?, capacite = ? WHERE id_salle = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, salle.getNom_salle());
            pstmt.setInt(2, salle.getCapacite());
            pstmt.setInt(3, salle.getId_salle());
            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Salle updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSalle(int id) {
        try {
            String sql = "DELETE FROM salles WHERE id_salle = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Salle deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
