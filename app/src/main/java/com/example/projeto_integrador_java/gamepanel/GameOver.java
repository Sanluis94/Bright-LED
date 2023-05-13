package com.example.projeto_integrador_java.gamepanel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.projeto_integrador_java.R;


/**
 * GameOver is a panel which draws the text Game Over to the screen.
 */
public class GameOver extends AppCompatActivity {

    private Context context;

    public GameOver(Context context) {
        this.context = context;
    }

    public void draw(Canvas canvas) {
        drawGameOver(canvas);
        drawContinue(canvas);
        drawMainMenu(canvas);
    }
    public void drawGameOver(Canvas canvas){
        String text = "Game Over";

        float x = 800;
        float y = 200;

        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.gameOver);
        paint.setColor(color);
        float textSize = 150;
        paint.setTextSize(textSize);

        canvas.drawText(text, x, y, paint);
    }
    public void drawContinue(Canvas canvas){
        String text = "Continue";

        float x = 1400;
        float y = 450;

        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.gameOver);
        paint.setColor(color);
        float textSize = 150;
        paint.setTextSize(textSize);

        canvas.drawText(text, x, y, paint);
    }
    public void drawMainMenu(Canvas canvas){
        String text = "Main Menu";

        float x = 1400;
        float y = 650;

        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.gameOver);
        paint.setColor(color);
        float textSize = 150;
        paint.setTextSize(textSize);

        canvas.drawText(text, x, y, paint);
    }
}
