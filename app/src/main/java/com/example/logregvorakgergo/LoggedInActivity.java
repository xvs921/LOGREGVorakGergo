package com.example.logregvorakgergo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoggedInActivity extends AppCompatActivity {

    private dbhelper adatbazisSegito;
    private TextView tvKiiras;
    private Button btnKijelentkezes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        tvKiiras.setText("Üdvözöllek ");
        btnKijelentkezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoggedInActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void init() {
        adatbazisSegito = new dbhelper((this));
        tvKiiras = findViewById(R.id.tvKiiras);
        btnKijelentkezes = findViewById(R.id.btnKijelentkezes);
    }
}
