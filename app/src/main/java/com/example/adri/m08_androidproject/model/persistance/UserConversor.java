package com.example.adri.m08_androidproject.model.persistance;

import android.app.Activity;
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
    public static final String BD_NAME = "TRINEER_BD4";
    public static final int BD_VERSION = 3;
    private UserSqliteHelper helper;


    public UserConversor(Activity context) {
        this.helper = new UserSqliteHelper(context, UserConversor.BD_NAME , null, UserConversor.BD_VERSION);
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

        dades.put("run_time", run.getRun_time());
        dades.put("run_date", run.getRun_date());
        dades.put("id_user", run.getId_user());


        try {
            index = db.insertOrThrow("run", null, dades);
        }
        catch(Exception e) {
            Log.e("ERROR_BUG","Error on insert the run");
        }
        return index;
    }

    public User getUsers(String name) {
        if(name.trim().equals("")){
            return null;
        }
        Cursor c = getCursorUsersByName(name);

        if(c==null && c.getCount()==0){
            return null;
        }
        c.moveToFirst();
        return new User(c.getInt(0),c.getString(1));
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

    public Cursor getCursorRunsByUser(User user) {
        SQLiteDatabase db = helper.getReadableDatabase();
        return db.query(true,
                "run",
                new String[]{"id", "run_time", "run_date", "id_user"},
                "id_user = ?",
                new String[] { user.getId() + "" },
                null,
                null,
                null,
                "run_date");
    }

    public Cursor getCursorRunsByUser(String userName) {
        SQLiteDatabase db = helper.getReadableDatabase();
        User user = this.getUsers(userName);
        int id;
        if(user != null) {
             id = user.getId();
        }else{
            id = 0;
        }

        return db.query(true,
                "run",
                new String[]{"id", "run_time", "run_date", "id_user"},
                "id_user = ?",
                new String[] { id + "" },
                null,
                null,
                null,
                null);
    }

}
