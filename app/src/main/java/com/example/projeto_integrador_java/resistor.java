package com.example.projeto_integrador_java;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class resistor extends AppCompatActivity {

    private Button resistorVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resistor);

        resistorVoltar = findViewById(R.id.resistorVoltar);

        resistorVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(resistor.this, howplay.class);
                startActivity(intent);

            }
        });
    }



}
