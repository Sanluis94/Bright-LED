package com.example.projeto_integrador_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
public class howplay extends AppCompatActivity {

    private Button voltarmenu;
    private Button resistorAbrir;
    private Button tutorialAbrir;

    private Button capacitorAbrir;
    private Button ledAbrir;

    private Button jumperAbrir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.howplay);

        voltarmenu = findViewById(R.id.voltarmenu);

        resistorAbrir = findViewById(R.id.resistorAbrir);

        tutorialAbrir = findViewById(R.id.tutorialAbrir);

        ledAbrir = findViewById(R.id.ledAbrir);

        capacitorAbrir = findViewById(R.id.capacitorAbrir);

        jumperAbrir = findViewById(R.id.jumperAbrir);

        //AO CLICAR NO BOTAO JOGAR
        voltarmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(howplay.this, MainActivity.class);
                startActivity(intent);

            }
        });

        //RESISTOR

        resistorAbrir.setOnClickListener((new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(howplay.this, resistor.class);
                startActivity(intent);
            }
        }));

        //TUTORIAL


        tutorialAbrir.setOnClickListener((new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                Intent intent = new Intent(howplay.this, tutorial.class);
                startActivity(intent);
            }
        }));

        //LED



        ledAbrir.setOnClickListener((new View.OnClickListener() {



            @Override
            public void onClick(View view) {

                Intent intent = new Intent(howplay.this, led.class);
                startActivity(intent);
            }
        }));

        //CAPACITOR



        capacitorAbrir.setOnClickListener((new View.OnClickListener() {




            @Override
            public void onClick(View view) {

                Intent intent = new Intent(howplay.this, capacitor.class);
                startActivity(intent);
            }
        }));

        //JUMPER



        jumperAbrir.setOnClickListener((new View.OnClickListener() {




            @Override
            public void onClick(View view) {

                Intent intent = new Intent(howplay.this, jumper.class);
                startActivity(intent);
            }
        }));



    }


}

