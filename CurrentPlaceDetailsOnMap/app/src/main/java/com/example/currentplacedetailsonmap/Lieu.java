package com.example.currentplacedetailsonmap;

import com.j256.ormlite.field.DatabaseField;


public abstract class Lieu {

    @DatabaseField( columnName = "id" , generatedId = true )
    protected int id=0;
    @DatabaseField
    protected String nom;
    @DatabaseField
    protected String adresse;
    @DatabaseField
    protected double lat;
    @DatabaseField
    protected double lng;

    public abstract void setNom(String nom);
    public abstract void setAdresse(String adresse);
    public abstract void setLat(double lat);
    public abstract void setLng(double lng);

    public String toString() {
        return id + " " + nom + " " + adresse + " " + lat + " " + lng;
    }

    public void show() {
        System.out.println(this);
    }
}
