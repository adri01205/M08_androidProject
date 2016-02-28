package com.example.adri.m08_androidproject.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.adri.m08_androidproject.R;

/**
 * Created by Sergio on 28/02/2016.
 */
public class MenuActivity extends Activity implements View.OnClickListener {

    Button newRace;
    Button history;
    Button logOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        newRace = (Button) findViewById(R.id.btn_newrace);
        history = (Button) findViewById(R.id.btn_history);
        logOut = (Button) findViewById(R.id.btn_logout);

        newRace.setOnClickListener(this);
        history.setOnClickListener(this);
        logOut.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;

        switch (v.getId()) {
            case R.id.btn_newrace:
                intent = new Intent(this, ChronoActivity.class);
                break;

        }
        if (intent != null) {
            startActivity(intent);
        }

    }
}
