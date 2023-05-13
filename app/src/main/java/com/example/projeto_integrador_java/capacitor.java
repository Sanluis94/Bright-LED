package com.example.projeto_integrador_java;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class capacitor extends AppCompatActivity {

    private Button capacitorVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.capacitor);

        capacitorVoltar = findViewById(R.id.capacitorVoltar);

        capacitorVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(capacitor.this, howplay.class);
                startActivity(intent);

            }
        });
    }



}