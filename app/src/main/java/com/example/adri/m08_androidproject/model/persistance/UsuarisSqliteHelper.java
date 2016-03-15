package com.example.adri.m08_androidproject.model.persistance;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sergio on 28/02/2016.
 */
public class UsuarisSqliteHelper extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE user " +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " name TEXT NOT NULL ) " +

            "CREATE TABLE run " +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            " time TEXT NOT NULL, " +
            " id_user INTEGER NOT NULL, " +
            "FOREIGN KEY(id_user) REFERENCES user(id) )" ;

    public UsuarisSqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);

        db.execSQL(
                "INSERT INTO user (id, name) " +
                        "VALUES (1, 'test')");
        db.execSQL(
                "INSERT INTO run (id, time, id_user) " +
                        "VALUES (1, 'test', 1)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int versionAnterior, int versionNueva) {
        //NOTA: Por simplicidad, se elimina la tabla existente y
        // secrea de nuevo vacía con el nuevo formato
        db.execSQL("DROP TABLE IF EXISTS user");
        db.execSQL("DROP TABLE IF EXISTS run");

        db.execSQL(sqlCreate);
    }
}
