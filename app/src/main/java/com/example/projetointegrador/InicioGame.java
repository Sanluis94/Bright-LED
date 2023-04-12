package com.example.projetointegrador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class InicioGame extends AppCompatActivity {

    private Button botaoInicio;
    private Button comoJogar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoInicio = findViewById(R.id.botaoInicio);
        comoJogar = findViewById(R.id.comojogar);

        //AO CLICAR NO BOTAO JOGAR
        botaoInicio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(InicioGame.this, MainActivity.class);
                startActivity(intent);

            }
        });

        //AO CLICAR NO BOTAO COMO JOGAR
        comoJogar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(InicioGame.this, howplay.class);
                startActivity(intent);
            }
        }));


    }

}
