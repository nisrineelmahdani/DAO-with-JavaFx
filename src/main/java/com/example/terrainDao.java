package com.example;

import java.util.List;

public interface terrainDao {
    void addTerrain(terrain terrain);
    terrain getTerrainById(int id);
    List<terrain> getAllTerrains();
    void updateTerrain(terrain terrain );
    void deleteTerrain(int id);
}


