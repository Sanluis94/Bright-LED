package com.example.projetointegrador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity  implements SensorEventListener {

    Sensor sensor;
    SensorManager sensorManager;

    double sensorValues;

    private Button botaoInicio;
    private Button comoJogar;

    Window window = getWindow();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        botaoInicio = findViewById(R.id.botaoInicio);
        comoJogar = findViewById(R.id.comojogar);

        botaoInicio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Game.class);
                startActivity(intent);

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
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause(){
        super.onPause();
        sensorManager.unregisterListener(this);
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