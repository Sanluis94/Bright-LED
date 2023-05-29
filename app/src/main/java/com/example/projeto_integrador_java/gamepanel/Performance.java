package com.example.projeto_integrador_java.gamepanel;

import static android.os.SystemClock.currentThreadTimeMillis;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

import com.example.projeto_integrador_java.GameLoop;
import com.example.projeto_integrador_java.MainActivity;
import com.example.projeto_integrador_java.R;
import com.example.projeto_integrador_java.gameobject.Player;
public class Performance {
    private GameLoop gameLoop;
    private Context context;
    private MainActivity mainActivity;

    public Performance(Context context, GameLoop gameLoop, MainActivity mainActivity) {
        this.context = context;
        this.gameLoop = gameLoop;
        this.mainActivity = mainActivity;
    }

    public void draw(Canvas canvas) {
        //drawUPS(canvas);
        //drawFPS(canvas);
        //drawLumenValue(canvas);
        drawTimer(canvas);
    }
    public void drawUPS(Canvas canvas) {
        String averageUPS = Double.toString(gameLoop.getAverageUPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.magenta);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("UPS: " + averageUPS, 100, 100, paint);
    }

    public void drawFPS(Canvas canvas) {
        String averageFPS = Double.toString(gameLoop.getAverageFPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.magenta);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("FPS: " + averageFPS, 100, 200, paint);
    }
    public void drawLumenValue(Canvas canvas){

        String lumenValue =  Double.toString(mainActivity.getSensorValues());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.red);
        paint.setColor(color);
        paint.setTextSize(20);
        canvas.drawText("Valor do Lumen: "+lumenValue, 100,300,paint);

    }

    private int getSecondsText() {

        int seconds = (int) ((currentThreadTimeMillis())*0.001);
        return seconds;
    }


    public void drawTimer(Canvas canvas) {
            String timer = String.valueOf(getSecondsText());
            Paint paint = new Paint();
            int color = ContextCompat.getColor(context, R.color.red);
            paint.setColor(color);
            paint.setTextSize(60);
            canvas.drawText("Timer: " + timer, 1000, 100, paint);

    }
}