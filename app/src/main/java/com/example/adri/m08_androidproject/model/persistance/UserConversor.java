package com.example.adri.m08_androidproject.model.persistance;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.adri.m08_androidproject.model.business.Run;
import com.example.adri.m08_androidproject.model.business.User;

/**
 * Created by Sergio on 28/02/2016.
 */
public class UserConversor {
    public static final String BD_NAME = "TRINEER_BD3";
    private UserSqliteHelper helper;


    public UserConversor(UserSqliteHelper helper) {
        this.helper = helper;
    }


    public long saveUser(User user) {
        long index = -1;
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues dades = new ContentValues();

        dades.put("name", user.getName());


        try {
            index = db.insertOrThrow("user", null, dades);
        }
        catch(Exception e) {
            Log.e("ERROR_BUG","Error on insert the user");
        }
        return index;
    }

    public long saveRun(Run run) {
        long index = -1;
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues dades = new ContentValues();

        dades.put("time", run.getTemps());
        dades.put("id_user", run.getId_user());


        try {
            index = db.insertOrThrow("run", null, dades);
        }
        catch(Exception e) {
            Log.e("ERROR_BUG","Error on insert the run");
        }
        return index;
    }

//    (SQliteDatabase) db.query(
//              "mytable" /* table */,
//            new String[] { "name" } /* columns */,
//            "id = ?" /* where or selection */,
//            new String[] { "john" } /* selectionArgs i.e. value to replace ? */,
//            null /* groupBy */,
//            null /* having */,
//            null /* orderBy */
//            );

    public User getUsers(String name) {
        if(name.trim().equals("")){
            return null;
        }
        Cursor c = getCursorUsersByName(name);
        c.moveToFirst();


        return new User(c.getInt(c.getColumnIndex("id")),c.getString(c.getColumnIndex("name")));
    }

    public Cursor getCursorUsersByName(String name) {
        SQLiteDatabase db = helper.getReadableDatabase();

        return db.query(true,
                "user",
                new String[]{"id","name"},
                "name = ?",
                new String[] { name },
                null,
                null,
                null,
                null);
    }


    public Cursor getAllRuns() {
        SQLiteDatabase db = helper.getReadableDatabase();

        return db.query(true,
                "Tasks",
                new String[]{"TaskID","Date","TeamID","Report","Company"},
                null,
                null,
                null,
                null,
                null,
                null);
    }

}
