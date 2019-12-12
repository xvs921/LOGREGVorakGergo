package com.example.logregvorakgergo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private dbhelper adatbazisSegito;
    private EditText etEmail, etFelhnev, etJelszo,etTeljesnev;
    private Button btnRegisztracio,btnVissza;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();
        adatRogzites();
        btnVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void init()
    {
        adatbazisSegito=new dbhelper((this));
        etEmail=findViewById(R.id.etEmail);
        etFelhnev=findViewById(R.id.etFelhnev);
        etJelszo=findViewById(R.id.etJelszo);
        etTeljesnev=findViewById(R.id.etTeljesnev);
        btnRegisztracio=findViewById(R.id.btnRegisztracio);
        btnVissza=findViewById(R.id.btnVissza);
    }
    public void adatRogzites()
    {
        String email=etEmail.getText().toString();
        String felhnev=etFelhnev.getText().toString();
        String jelszo=etJelszo.getText().toString();
        String teljesnev=etTeljesnev.getText().toString();
        Boolean eredmeny=adatbazisSegito.adatRogzites(email,felhnev,jelszo,teljesnev);
        if (eredmeny==true && !etEmail.toString().isEmpty() && !etFelhnev.toString().isEmpty() && !etJelszo.toString().isEmpty() && !etTeljesnev.toString().isEmpty())
        {
            Toast.makeText(this,"Sikeres felhasználófelvétel!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Sikertelen felhasználófelvétel!", Toast.LENGTH_SHORT).show();
        }

    }
}
