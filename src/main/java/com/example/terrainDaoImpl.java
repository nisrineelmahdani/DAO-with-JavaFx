package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class terrainDaoImpl implements terrainDao {
         private Connection conn;
          public terrainDaoImpl(db cn){
         this.conn= cn.getConnection();
         }
    @Override
    public void addTerrain(terrain terrain) {
     try {
            String sql = "INSERT INTO terrains (id_terrain, nom_terrain, type) VALUES(?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, terrain.getIdTerrain());
            pstmt.setString(2, terrain.getNomTerrain());
            pstmt.setString(3, terrain.getType());
            pstmt.executeUpdate();
            System.out.println("terrain added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public terrain getTerrainById(int id) {
        terrain terrain = null;
        try {
            String sql = "select * from terrains where id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
         ResultSet rs = pstmt.executeQuery();
         while (rs.next()) {
            terrain = new terrain(rs.getInt("id_terrain"), rs.getString("nom_terrain"), rs.getString("type"));
         }
       
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return terrain;
    }

    @Override
    public List<terrain> getAllTerrains() {
           List<terrain> terrains = new ArrayList<>();
        try {
            String sql = "SELECT * FROM terrains";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                terrains.add(new terrain(
                    rs.getInt("id_terrain"),
                    rs.getString("nom_terrain"),
                    rs.getString("type")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return terrains;
    }

    @Override
    public void updateTerrain(terrain terrain) {
       try{
        String sql = "UPDATE terrains set nom_terrain=? , type=? where id=? ";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, terrain.getNomTerrain());
        pstmt.setString(2, terrain.getType());
        pstmt.setInt(3, terrain.getIdTerrain());
        pstmt.executeUpdate();
        System.out.println("terrain updated successfully!");
    } catch (SQLException e) {
        e.printStackTrace();
    }
       }
    

    @Override
    public void deleteTerrain(int id) {
       try {
        String sql = "DELETE from terrains where id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        System.out.println("terrain updated successfully!");

       } catch (Exception e) {
       e.printStackTrace();
       }
    }
    
}
