package com.example.projeto_integrador_java;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.projetointegrador.R;

/**
 * MainActivity is the entry point to our application.
 */
public class MainActivity extends Activity implements SensorEventListener {

    private Game game;

    Sensor sensor;
    SensorManager sensorManager;

    double sensorValues;

    private Button botaoInicio;
    private Button comoJogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MainActivity.java", "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        if (sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT) != null) {
            sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        } else {
            Toast.makeText(this, "Este sensor não existe neste dispositivo", Toast.LENGTH_SHORT).show();
        }

        // Set content view to game, so that objects in the Game class can be rendered to the screen
        game = new Game(this,this);

        botaoInicio = findViewById(R.id.botaoInicio);
        comoJogar = findViewById(R.id.comojogar);

        botaoInicio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                setContentView(game);

            }
        });

        comoJogar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, howplay.class);
                startActivity(intent);
            }
        }));
    }

    @Override
    protected void onStart() {
        Log.d("MainActivity.java", "onStart()");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("MainActivity.java", "onResume()");
        super.onResume();
        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        Log.d("MainActivity.java", "onPause()");
        game.pause();
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onStop() {
        Log.d("MainActivity.java", "onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("MainActivity.java", "onDestroy()");
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        // Comment out "super.onBackPressed()" to disable button
        //super.onBackPressed();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        sensorValues = (double)event.values[0];

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
    public double getSensorValues(){

        return sensorValues;

    }
}
