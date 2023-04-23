package com.example.projetointegrador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class howplay extends AppCompatActivity {

    private Button voltarmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.howplay);

        voltarmenu = findViewById(R.id.voltarmenu);

        //AO CLICAR NO BOTAO JOGAR
        voltarmenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(howplay.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}