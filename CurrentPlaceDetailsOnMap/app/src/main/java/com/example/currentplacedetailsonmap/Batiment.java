package com.example.currentplacedetailsonmap;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable( tableName = "batiment" )
public class Batiment extends Lieu {


    @DatabaseField
    protected String type;

    public Batiment() {
    }

    public Batiment( String type, String nom, String adresse, double lat, double lng) {
        this.setType(type);
        this.setNom(nom);
        this.setAdresse(adresse);
        this.setLat(lat);
        this.setLng(lng);
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public void setLat(double lat) {
        this.lat = lat;
    }

    @Override
    public void setLng(double lng) {
        this.lng = lng;
    }

    public String toString() {
        return super.toString() + " " + type + "\n\n";
    }

    public void show() {
        System.out.println(this);
    }
}