package com.example;

public class terrain {
    private int idTerrain;
    private String nomTerrain;
    private String type;


    public terrain(int idTerrain, String nomTerrain, String type) {
        this.idTerrain = idTerrain;
        this.nomTerrain = nomTerrain;
        this.type = type;
    }

  

 
    public int getIdTerrain() {
        return idTerrain;
    }

    public void setIdTerrain(int idTerrain) {
        this.idTerrain = idTerrain;
    }

    public String getNomTerrain() {
        return nomTerrain;
    }

    public void setNomTerrain(String nomTerrain) {
        this.nomTerrain = nomTerrain;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Terrain{" +
                "idTerrain=" + idTerrain +
                ", nomTerrain='" + nomTerrain + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
