package com.example.projeto_integrador_java;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
public class tutorial extends AppCompatActivity {

    private Button tutorialVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial);

        tutorialVoltar = findViewById(R.id.tutorialVoltar);

        tutorialVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(tutorial.this, howplay.class);
                startActivity(intent);

            }
        });
    }



}
