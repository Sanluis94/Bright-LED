package com.example.projeto_integrador_java.gamepanel;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.example.projeto_integrador_java.Game;
import com.example.projetointegrador.R;

/**
 * GameOver is a panel which draws the text Game Over to the screen.
 */
public class GameOver extends AppCompatActivity {
    private Context context;
    private Paint paint;

    public GameOver(Context context) {
        this.context = context;
        paint = new Paint();
    }

    public void draw(Canvas canvas) {
        drawGameOver(canvas);
        drawContinue(canvas);
        drawMainMenu(canvas);
    }

    private void drawGameOver(Canvas canvas) {
        // Code for drawing the "Game Over" text
    }

    private void drawContinue(Canvas canvas) {
        String text = "Continue";

        float x = 1400;
        float y = 450;

        int color = ContextCompat.getColor(context, R.color.gameOver);
        paint.setColor(color);
        float textSize = 150;
        paint.setTextSize(textSize);

        canvas.drawText(text, x, y, paint);
    }

    private void drawMainMenu(Canvas canvas) {
        String text = "Main Menu";

        float x = 1400;
        float y = 650;

        int color = ContextCompat.getColor(context, R.color.gameOver);
        paint.setColor(color);
        float textSize = 150;
        paint.setTextSize(textSize);

        canvas.drawText(text, x, y, paint);
    }

    public void handleTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();

        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (isContinueButtonTouched(touchX, touchY)) {
                Intent intent = new Intent(GameOver.this, Game.class);
                startActivity(intent);
            } else if (isMainMenuButtonTouched(touchX, touchY)) {
                Intent intent = new Intent(GameOver.this, Game.class);
                startActivity(intent);
            }
        }
    }

    private boolean isContinueButtonTouched(float touchX, float touchY) {
        // Define the boundaries of the Continue button
        float buttonLeft = 1400;
        float buttonTop = 450 - 150;
        float buttonRight = 1400 + paint.measureText("Continue");
        float buttonBottom = 450;

        // Verifica se o texto pressionado está dentro do limite dos pixels
        return touchX >= buttonLeft && touchX <= buttonRight && touchY >= buttonTop && touchY <= buttonBottom;
    }

    private boolean isMainMenuButtonTouched(float touchX, float touchY) {
        // Define os limites do botão do Main Menu
        float buttonLeft = 1400;
        float buttonTop = 650 - 150;
        float buttonRight = 1400 + paint.measureText("Main Menu");
        float buttonBottom = 650;

        // Verifica se o toque de coordenadas estão dentro dos limites de pixels Main Menu
        return touchX >= buttonLeft && touchX <= buttonRight && touchY >= buttonTop && touchY <= buttonBottom;
    }

    private void showToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}