package com.example.projeto_integrador_java.gameobject;

import android.content.Context;
import androidx.core.content.ContextCompat;
import android.graphics.Canvas;

import com.example.projeto_integrador_java.GameLoop;
import com.example.projeto_integrador_java.R;
import com.example.projeto_integrador_java.graphics.Sprite;
import com.example.projeto_integrador_java.GameDisplay;


public class Spell extends Circle {
    public static final double SPEED_PIXELS_PER_SECOND = 800.0;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;

    private Sprite sprite;
    float X;

    float Y;

    public Spell(Context context, Sprite sprite , Player spellcaster) {
        super(
            context,
            ContextCompat.getColor(context, R.color.spell),
            spellcaster.getPositionX(),
            spellcaster.getPositionY(),
      25
        );
        velocityX = spellcaster.getDirectionX()*MAX_SPEED;
        velocityY = spellcaster.getDirectionY()*MAX_SPEED;
        this.sprite = sprite;
    }

    @Override
    public void update() {
        positionX = positionX + velocityX;
        positionY = positionY + velocityY;

        }

    public void draw(Canvas canvas, GameDisplay gameDisplay){
        X = (int) gameDisplay.gameToDisplayCoordinatesX(positionX);
        Y = (int) gameDisplay.gameToDisplayCoordinatesY(positionY);
        sprite.draw(
                canvas,
                (int) X,
                (int) Y
        );
    }
}
