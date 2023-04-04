package com.example.projetointegrador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends Activity  implements SensorEventListener {

    Sensor sensor;
    SensorManager sensorManager;
    int sensorValues;
    Window window = getWindow();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);


        setContentView(new Game(this));

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

        switch((int)event.values[0]){
            case 0:
                sensorValues = 0;
            case 10:
                sensorValues = 10;
            case 20:
                sensorValues = 20;
            case 30:
                sensorValues = 30;
            case 40:
                sensorValues = 40;
        };

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    public int getSensorValues(){

        return sensorValues;

    }
}