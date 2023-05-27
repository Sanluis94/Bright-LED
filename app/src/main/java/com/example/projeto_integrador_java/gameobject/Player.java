package com.example.projeto_integrador_java.gameobject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

import com.example.projeto_integrador_java.GameDisplay;
import com.example.projeto_integrador_java.GameLoop;
import com.example.projeto_integrador_java.MainActivity;
import com.example.projeto_integrador_java.R;
import com.example.projeto_integrador_java.gamepanel.HealthBar;
import com.example.projeto_integrador_java.gamepanel.Joystick;
import com.example.projeto_integrador_java.Utils;
import com.example.projeto_integrador_java.graphics.Animator;

/**
 * Player is the main character of the game, which the user can control with a touch joystick.
 * The player class is an extension of a Circle, which is an extension of a GameObject
 */
public class Player extends Circle {
    public static final double SPEED_PIXELS_PER_SECOND = 400.0;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;
    public static final int MAX_HEALTH_POINTS = 5;
    private Joystick joystick;
    private HealthBar healthBar;
    private int healthPoints = MAX_HEALTH_POINTS;
    private Animator animator;
    private PlayerState playerState;

    private Paint paint;
    private MainActivity mainActivity;

    public Player(Context context, Joystick joystick, double positionX, double positionY, double radius, Animator animator, MainActivity mainActivity) {
        super(context, ContextCompat.getColor(context, R.color.red), positionX, positionY, radius);
        this.joystick = joystick;
        this.healthBar = new HealthBar(context, this);
        this.animator = animator;
        this.playerState = new PlayerState(this);
        this.mainActivity = mainActivity;
        paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.black);
        paint.setColor(color);
        paint.setAlpha(200);
        paint.setStrokeWidth(1000);
        paint.setStyle(Paint.Style.STROKE);
    }

    public void update() {

        // Update velocity based on actuator of joystick
        velocityX = joystick.getActuatorX()*MAX_SPEED;
        velocityY = joystick.getActuatorY()*MAX_SPEED;

        // Update position
        positionX += velocityX;
        positionY += velocityY;

        // Update direction
        if (velocityX != 0 || velocityY != 0) {
            // Normalize velocity to get direction (unit vector of velocity)
            double distance = Utils.getDistanceBetweenPoints(0, 0, velocityX, velocityY);
            directionX = velocityX/distance;
            directionY = velocityY/distance;
        }

        playerState.update();
    }

    public void draw(Canvas canvas, GameDisplay gameDisplay) {
        if(mainActivity.getSensorValues() >= 50){
            canvas.drawCircle((float) animator.getX(),(float) animator.getY(),(float)radius*50,paint);
        }
        else{
            canvas.drawCircle((float) animator.getX(),(float) animator.getY(),(float)radius*25,paint);
        }
        animator.draw(canvas, gameDisplay, this);

        healthBar.draw(canvas, gameDisplay);
    }

    public int getHealthPoint() {
        return healthPoints;
    }

    public void setHealthPoint(int healthPoints) {
        // Only allow positive values
        if (healthPoints >= 0)
            this.healthPoints = healthPoints;
    }

    public PlayerState getPlayerState() {
        return playerState;
    }
}
