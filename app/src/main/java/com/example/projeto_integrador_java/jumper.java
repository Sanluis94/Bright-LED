package com.example.projeto_integrador_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class jumper extends AppCompatActivity {

    private Button jumperVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jumper);

        jumperVoltar = findViewById(R.id.jumperVoltar);

        jumperVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(jumper.this, howplay.class);
                startActivity(intent);

            }
        });
    }



}
