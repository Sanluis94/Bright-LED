package com.example.projetointegrador;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

import com.example.projetointegrador.Sprite;

public class Player {

    private static final double SPEED_PIXELS_PER_SECOND = 600.0;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND/GameLoop.MAX_UPS;
    private double positionX;
    private double positionY;
    private double radius;
    private Paint paint;
    private Paint paint2;
    private double velocityX;
    private double velocityY;
    private MainActivity mainActivity;
    private Sprite sprite;

    public Player(Context context, double positionX, double positionY, double radius, MainActivity mainActivity, Sprite sprite){

        this.positionX = positionX;
        this.positionY = positionY;
        this.radius = radius;
        this.mainActivity = mainActivity;
        this.sprite = sprite;
        paint = new Paint();
        int color = ContextCompat.getColor(context,R.color.black);
        paint.setColor(color);
        paint.setAlpha(200);
        paint.setStrokeWidth(1000);
        paint.setStyle(Paint.Style.STROKE);

    }

    public void draw(Canvas canvas, GameDisplay gameDisplay) {

        if(mainActivity.getSensorValues() >= 50){
            canvas.drawCircle((float) gameDisplay.gameToDisplayCoordinatesX(getPositionX()) - sprite.getWidth()/2,(float) gameDisplay.gameToDisplayCoordinatesY(getPositionY()) - sprite.getHeight()/2,(float)radius*50,paint);
        }
        else{
            canvas.drawCircle((float) gameDisplay.gameToDisplayCoordinatesX(getPositionX()) - sprite.getWidth()/2,(float) gameDisplay.gameToDisplayCoordinatesY(getPositionY()) - sprite.getHeight()/2,(float)radius*25,paint);
        }

        sprite.draw(
                canvas,
                (int) gameDisplay.gameToDisplayCoordinatesX(getPositionX()) - sprite.getWidth()/2,
                (int) gameDisplay.gameToDisplayCoordinatesY(getPositionY()) - sprite.getHeight()/2
        );
    }

    public void update(Joystick joystick) {

        velocityX = joystick.getActuatorX() * MAX_SPEED;
        velocityY = joystick.getActuatorY() * MAX_SPEED;
        positionX += velocityX;
        positionY += velocityY;

    }

    public void setPosition(double positionX, double positionY) {

        this.positionX = positionX;
        this.positionY = positionY;

    }
    public float getPositionX(){

        return (float)positionX;

    }
    public float getPositionY(){

        return (float)positionY;

    }
}
