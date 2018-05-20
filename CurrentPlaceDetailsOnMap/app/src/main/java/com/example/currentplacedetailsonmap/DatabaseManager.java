package com.example.currentplacedetailsonmap;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.util.List;

public class DatabaseManager extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "Lieu.db";
    private static final int DATABASE_VERSION = 10;

    public DatabaseManager (Context context ) {

        super( context, DATABASE_NAME, null, DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        try {
            TableUtils.createTable(connectionSource, Parking.class);
            Log.i("DATABASE", "OnCreate parking appelé");
        } catch (Exception exception) {
            Log.e("DATABASE" , "OnCreate pas de création de la table parking" , exception);
        }

        try {
            TableUtils.createTable(connectionSource, Batiment.class);
            Log.i("DATABASE", "OnCreate batiment appelé");
        } catch (Exception exception) {
            Log.e("DATABASE" , "OnCreate pas de création de la table batiment" , exception);
        }

        try {
            TableUtils.createTable(connectionSource, LieuDetente.class);
            Log.i("DATABASE", "OnCreate LieuDetente appelé");
        } catch (Exception exception) {
            Log.e("DATABASE" , "OnCreate pas de création de la table LieuDetente" , exception);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, LieuDetente.class, true);
            onCreate(database, connectionSource);
            Log.i("DATABASE", "OnUpgrade LieuDetente appelé");
        } catch (Exception exception) {
            Log.e("DATABASE" , "OnUpgrade pas de création de la table lieuDetente" , exception);
        }

        try {
            TableUtils.dropTable(connectionSource, Batiment.class, true);
            onCreate(database, connectionSource);
            Log.i("DATABASE", "OnUpgrade batiment appelé");
        } catch (Exception exception) {
            Log.e("DATABASE" , "OnUpgrade pas de création de la table batiment" , exception);
        }

        try {
            TableUtils.dropTable(connectionSource, Parking.class, true);
            onCreate(database, connectionSource);
            Log.i("DATABASE", "OnUpgrade parking appelé");
        } catch (Exception exception) {
            Log.e("DATABASE" , "OnUpgrade pas de création de la base parking" , exception);
        }
    }

    public void insertionBatiment( Batiment batiment) {

        try {
            Dao<Batiment, Integer> dao = getDao( Batiment.class );
            dao.create( batiment );
            Log.i("DATABASE", "insertion batiment appelé");
        } catch (Exception exception) {
            Log.e("DATABASE" , "pas d'insertion dans la table batiment" , exception);
        }
    }

    public void insertionParking( Parking parking) {

        try {
            Dao<Parking, Integer> dao = getDao( Parking.class );
            dao.create( parking );
            Log.i("DATABASE", "insertion parking appelé");
        } catch (Exception exception) {
            Log.e("DATABASE" , "pas d'insertion dans la table parking" , exception);
        }
    }

    public void insertionLieuDetente( LieuDetente lieu_detente) {

        try {
            Dao<LieuDetente, Integer> dao = getDao( LieuDetente.class );
            dao.create( lieu_detente );
            Log.i("DATABASE", "insertion LieuDetente appelé");
        } catch (Exception exception) {
            Log.e("DATABASE" , "pas d'insertion dans la table LieuDetente" , exception);
        }
    }

    public List<Batiment> readTop5B() {
        try {
            Dao<Batiment, Integer> dao = getDao( Batiment.class );
            List<Batiment> lieux = dao.queryForAll();
            Log.i("DATABASE", "readTop5 appelé");
            return lieux;
        } catch (Exception exception) {
            Log.e("DATABASE" , "readTop5 non appelé" , exception);
            return null;
        }
    }


    public List<Parking> readTop5P() {
        try {
            Dao<Parking, Integer> dao = getDao( Parking.class );
            List<Parking> lieu = dao.queryForAll();
            Log.i("DATABASE", "readTop5 appelé");
            return lieu;
        } catch (Exception exception) {
            Log.e("DATABASE" , "readTop5 non appelé" , exception);
            return null;
        }
    }

    public List<LieuDetente> readTop5L() {
        try {
            Dao<LieuDetente, Integer> dao = getDao( LieuDetente.class );
            List<LieuDetente> places = dao.queryForAll();
            Log.i("DATABASE", "readTop5 appelé");
            return places;
        } catch (Exception exception) {
            Log.e("DATABASE" , "readTop5 non appelé" , exception);
            return null;
        }
    }


}