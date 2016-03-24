package com.example.adri.m08_androidproject.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.adri.m08_androidproject.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    public static String PREFS_NAME = "FitxerPreferencies";
    Button accept;
    EditText user;
    EditText pass;
    CheckBox recordar;
    TextView signup;
    String name = "";
    Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        accept = (Button) findViewById(R.id.bt_Aceptar);
        user = (EditText) findViewById(R.id.et_Nickname);
        pass = (EditText) findViewById(R.id.et_password);
        signup = (TextView) findViewById(R.id.tv_signUp);
        recordar = (CheckBox) findViewById(R.id.checkBox);

        signup.setOnClickListener(this);
        accept.setOnClickListener(this);

        SharedPreferences config = getSharedPreferences(PREFS_NAME, 0);
        //obtenim una preferencia anteriorment grabada
        name = config.getString("user", "");
        user.setText(name);

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
        Intent intent = null;
        switch (v.getId()) {
            case R.id.bt_Aceptar:
                aceptar();
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

    public void aceptar() {
        SharedPreferences config = getSharedPreferences(PREFS_NAME, 0);
        //editor per editar les preferencies
        SharedPreferences.Editor editor = config.edit();
        if (recordar.isChecked()) {
            //afegim una preferencia--> (clau=name, valor=pepe)
            editor.putString("user", String.valueOf(user.getText()));
            //Confirmar els canvis
            editor.commit();
            name = config.getString("user", null);
        } else {
            editor.putString("user", "");
            name = config.getString("user", null);
            editor.commit();
        }
    }


}
