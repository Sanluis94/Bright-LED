package com.example.projeto_integrador_java.gameobject;

import android.content.Context;
import android.graphics.Canvas;

import androidx.core.content.ContextCompat;

import com.example.projeto_integrador_java.GameDisplay;
import com.example.projeto_integrador_java.GameLoop;
import com.example.projeto_integrador_java.R;
import com.example.projeto_integrador_java.graphics.Sprite;

/**
 * Enemy is a character which always moves in the direction of the player.
 * The Enemy class is an extension of a Circle, which is an extension of a GameObject
 */
public class Enemy extends Circle {

    private static final double SPEED_PIXELS_PER_SECOND = Player.SPEED_PIXELS_PER_SECOND*0.6;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;
    private static final double SPAWNS_PER_MINUTE = 20;
    private static final double SPAWNS_PER_SECOND = SPAWNS_PER_MINUTE/60.0;
    private static final double UPDATES_PER_SPAWN = GameLoop.MAX_UPS/SPAWNS_PER_SECOND;
    float X;
    float Y;
    private static double updatesUntilNextSpawn = UPDATES_PER_SPAWN;
    private Player player;
    private Sprite sprite;

    public Enemy(Context context, Player player, double positionX, double positionY, double radius) {
        super(context, ContextCompat.getColor(context, R.color.enemy), positionX, positionY, radius);
        this.player = player;
    }

    /**
     * Enemy is an overload constructor used for spawning enemies in random locations
     * @param context
     * @param player
     */
    public Enemy(Context context, Player player, Sprite sprite) {
        super(
            context,
            ContextCompat.getColor(context, R.color.enemy),
   Math.random()*1000,
   Math.random()*1000,
     30
        );
        this.player = player;
        this.sprite = sprite;
    }

    /**
     * readyToSpawn checks if a new enemy should spawn, according to the decided number of spawns
     * per minute (see SPAWNS_PER_MINUTE at top)
     * @return
     */
    public static boolean readyToSpawn() {
        if (updatesUntilNextSpawn <= 0) {
            updatesUntilNextSpawn += UPDATES_PER_SPAWN;
            return true;
        } else {
            updatesUntilNextSpawn --;
            return false;
        }
    }

    public void update() {
        // =========================================================================================
        //   Update velocity of the enemy so that the velocity is in the direction of the player
        // =========================================================================================
        // Calculate vector from enemy to player (in x and y)
        double distanceToPlayerX = player.getPositionX() - positionX;
        double distanceToPlayerY = player.getPositionY() - positionY;

        // Calculate (absolute) distance between enemy (this) and player
        double distanceToPlayer = GameObject.getDistanceBetweenObjects(this, player);

        // Calculate direction from enemy to player
        double directionX = distanceToPlayerX/distanceToPlayer;
        double directionY = distanceToPlayerY/distanceToPlayer;

        // Set velocity in the direction to the player
        if(distanceToPlayer > 0) { // Avoid division by zero
            velocityX = directionX*MAX_SPEED;
            velocityY = directionY*MAX_SPEED;
        } else {
            velocityX = 0;
            velocityY = 0;
        }

        // =========================================================================================
        //   Update position of the enemy
        // =========================================================================================
        positionX += velocityX;
        positionY += velocityY;
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

