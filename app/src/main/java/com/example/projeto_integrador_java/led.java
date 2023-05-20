package com.example.projeto_integrador_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
public class led extends AppCompatActivity {

    private Button ledVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.led);

        ledVoltar = findViewById(R.id.ledVoltar);

        ledVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(led.this, howplay.class);
                startActivity(intent);

            }
        });
    }



}