package com.example.adri.m08_androidproject.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.adri.m08_androidproject.R;
import com.example.adri.m08_androidproject.model.persistance.UserConversor;
import com.example.adri.m08_androidproject.model.persistance.UserSqliteHelper;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    public static String PREFS_NAME = "FitxerPreferencies";
    Button aceptar;
    EditText user;
    EditText pass;
    CheckBox recordar;
    ProgressBar bar;
    TextView signup;
    String nom = "";
    Intent intent;
    //timer
    private Handler timerHandler = new Handler();
    private int seconds = 10, barProg = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        aceptar = (Button) findViewById(R.id.bt_Aceptar);
        user = (EditText) findViewById(R.id.et_Nickname);
        pass = (EditText) findViewById(R.id.et_password);
        signup = (TextView) findViewById(R.id.tv_signUp);
        recordar = (CheckBox) findViewById(R.id.checkBox);
        bar = (ProgressBar) findViewById(R.id.progressBar);
        bar.setMax(100);

        signup.setOnClickListener(this);
        aceptar.setOnClickListener(this);

        SharedPreferences config = getSharedPreferences(PREFS_NAME, 0);
        //obtenim una preferencia anteriorment grabada
        nom = config.getString("user", "");
        user.setText(nom);

//        UserSqliteHelper ushelper = new UserSqliteHelper(this, UserConversor.BD_NAME , null, 2);
//        UserConversor uc = new UserConversor(ushelper);
//        System.out.println(uc.getUsers("test").getName());
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

    /*public void aceptar() {
        SharedPreferences config = getSharedPreferences(PREFS_NAME, 0);
        //editor per editar les preferencies
        SharedPreferences.Editor editor = config.edit();
        if (recordar.isChecked()) {
            //afegim una preferencia--> (clau=name, valor=pepe)
            editor.putString("user", String.valueOf(user.getText()));
            //Confirmar els canvis
            editor.commit();
            nom = config.getString("user", null);
        } else {
            editor.putString("user", "");
            nom = config.getString("user", null);
            editor.commit();
        }
        timerHandler.postDelayed(timerRunnable, 0);
    }*/

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.bt_Aceptar:
                //aceptar();
                intent = new Intent(this, MenuActivity.class);
                break;
            case R.id.tv_signUp:
                intent = new Intent(this, RegisterActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }

    /*private Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {

            if (bar.getProgress() < 100) {
                long millis = System.currentTimeMillis() - seconds;
                bar.setProgress(bar.getProgress() + barProg);
                timerHandler.postDelayed(this, 1);
                seconds = barProg / 10;
            } else {

            }
        }
    };*/
}
