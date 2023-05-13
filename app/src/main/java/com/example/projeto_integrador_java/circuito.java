package com.example.projeto_integrador_java;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class circuito extends AppCompatActivity {


    private Button circuitoVoltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circuito);

        circuitoVoltar = findViewById(R.id.circuitoVoltar);

        circuitoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(circuito.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }



}