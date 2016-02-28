package com.example.adri.m08_androidproject.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.adri.m08_androidproject.R;

/**
 * Created by Sergio on 28/02/2016.
 */
public class ChronoActivity extends Activity implements View.OnClickListener {

    TextView minute, second;
    ImageButton startStop;
    Button cancel, save;
    Boolean stoped = true;
    //timer
    private Handler timerHandler = new Handler();
    private int seconds = 00, min = 00;
    private Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {

            if (stoped == false) {
                seconds++;
                second.setText(String.valueOf(seconds));
                minute.setText(String.valueOf(min));
                if (seconds == 59) {
                    seconds = 00;
                    min++;
                }
                timerHandler.postDelayed(this, 1000);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chrono);

        startStop = (ImageButton) findViewById(R.id.ibtn_startStop);
        cancel = (Button) findViewById(R.id.btn_cancel);
        save = (Button) findViewById(R.id.btn_save);
        second = (TextView) findViewById(R.id.tv_sec);
        minute = (TextView) findViewById(R.id.tv_min);

        startStop.setOnClickListener(this);
        save.setOnClickListener(this);
        cancel.setOnClickListener(this);


    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if (v.getId() == R.id.btn_save) {

        } else if (v.getId() == R.id.btn_cancel) {
            intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.ibtn_startStop) {
            if (stoped == true) {
                stoped = false;
                startStop.setImageResource(R.mipmap.stop);
                timerHandler.postDelayed(timerRunnable, 0);
            } else {
                stoped = true;
                startStop.setImageResource(R.mipmap.start);

            }
        }

    }
}
