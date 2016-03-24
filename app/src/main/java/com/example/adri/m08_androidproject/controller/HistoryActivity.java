package com.example.adri.m08_androidproject.controller;

import android.app.Activity;
import android.os.Bundle;

import com.example.adri.m08_androidproject.R;


public class HistoryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historyview);
/*
        UserConversor userConversor = new UserConversor(this);

        Cursor reg = userConversor.getCursorRunsByUser("test");
        ((Spinner)findViewById(R.id.spinner)).setAdapter(new RunsAdapter(this,reg));
        */
    }


}
