package com.example.adri.m08_androidproject.controller;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Spinner;

import com.example.adri.m08_androidproject.*;
import com.example.adri.m08_androidproject.controller.adapters.RunsAdapter;
import com.example.adri.m08_androidproject.model.persistance.UserConversor;


public class HistoryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historyview);

        UserConversor userConversor = new UserConversor(this);

        Cursor reg = userConversor.getCursorRunsByUser("test");
        ((Spinner)findViewById(R.id.spinner)).setAdapter(new RunsAdapter(this,reg));
    }
}
