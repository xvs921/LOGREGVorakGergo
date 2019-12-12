package com.example.logregvorakgergo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private dbhelper adatbazisSegito;
    private EditText etAzonosito, etJelszo;
    private Button btnBejelentkezes,btnRegisztracio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnRegisztracio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnBejelentkezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LoggedInActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void init()
    {
        adatbazisSegito=new dbhelper((this));
        etAzonosito=findViewById(R.id.etAzonosito);
        etJelszo=findViewById(R.id.etJelszo);
        btnBejelentkezes=findViewById(R.id.btnBejelentkezes);
        btnRegisztracio=findViewById(R.id.btnRegisztracio);
    }
    public void bejelentkezes()
    {
        String felhnev=etAzonosito.getText().toString();
        String jelszo=etJelszo.getText().toString();
        Cursor eredmeny=adatbazisSegito.felhasznaloKereses(felhnev,jelszo);
        int fiok=eredmeny.getCount();
        if (fiok==1)
        {
            Toast.makeText(this,"Bejelentkezés", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Bejelentkezés sikertelen!", Toast.LENGTH_SHORT).show();
        }
    }

}
