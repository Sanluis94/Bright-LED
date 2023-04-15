package com.example.projetointegrador;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

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

    public Player(Context context, double positionX, double positionY, double radius, MainActivity mainActivity){

        this.positionX = positionX;
        this.positionY = positionY;
        this.radius = radius;
        this.mainActivity = mainActivity;

        paint = new Paint();
        int color = ContextCompat.getColor(context,R.color.player);
        paint.setColor(color);
        paint2 = new Paint();
        int color2 = ContextCompat.getColor(context,R.color.white);
        paint2.setColor(color2);

    }

    public void draw(Canvas canvas) {
        canvas.drawCircle((float)positionX, (float)positionY, (float)radius, paint);
        canvas.drawCircle((float)positionX, (float)positionY, (float)radius*(float)mainActivity.getSensorValues(), paint2);
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
