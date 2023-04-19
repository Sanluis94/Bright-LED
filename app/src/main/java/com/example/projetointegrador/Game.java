package com.example.projetointegrador;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.core.content.ContextCompat;

class Game extends SurfaceView implements SurfaceHolder.Callback {
    private final Joystick joystick;
    private final Tilemap tilemap;
    private GameLoop gameLoop ;
    private MainActivity mainActivity;
    private Context context;
    private final Player player;
    private GameDisplay gameDisplay;

    public Game(Context context,MainActivity mainActivity) {

        super(context);

        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        this.mainActivity = mainActivity;

        gameLoop = new GameLoop(this, surfaceHolder);

        joystick = new Joystick(275,700,70,40);

        SpriteSheet spriteSheet = new SpriteSheet(context);
        player = new Player(context,2*500,500,30,mainActivity, spriteSheet.getPlayerSprite());

        setFocusable(true);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity)getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        gameDisplay = new GameDisplay(displayMetrics.widthPixels, displayMetrics.heightPixels, player);
        
        tilemap = new Tilemap(spriteSheet);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(joystick.isPressed((double)event.getX(),(double)event.getY())){
                    joystick.setIsPressed(true);
                }
                return true;
            case MotionEvent.ACTION_MOVE:
                if(joystick.getIsPressed()) {
                    joystick.setActuator((double) event.getX(), (double) event.getY());
                }
                return true;

            case MotionEvent.ACTION_UP:
                joystick.setIsPressed(false);
                joystick.resetActuator();
        }

        return super.onTouchEvent(event);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

        gameLoop.startLoop();

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        tilemap.draw(canvas, gameDisplay);
        player.draw(canvas, gameDisplay);
        drawUPS(canvas);
        drawFPS(canvas);
        drawLumenValue(canvas);
        
        joystick.draw(canvas);
    }

    public void drawUPS(Canvas canvas){

        String averageUPS = Double.toString(gameLoop.getAverageUPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(getContext(),R.color.red);
        paint.setColor(color);
        paint.setTextSize(20);
        canvas.drawText("UPS: "+averageUPS, 100,100,paint);

    }

    public void drawFPS(Canvas canvas){

        String averageFPS = Double.toString(gameLoop.getAverageFPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(getContext(),R.color.red);
        paint.setColor(color);
        paint.setTextSize(20);
        canvas.drawText("FPS: "+averageFPS, 100,200,paint);

    }

    public void drawLumenValue(Canvas canvas){

        String lumenValue =  Double.toString(mainActivity.getSensorValues());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(getContext(),R.color.red);
        paint.setColor(color);
        paint.setTextSize(20);
        canvas.drawText("Valor do Lumen: "+lumenValue, 100,300,paint);

    }

    public void update() {

        joystick.update();
        player.update(joystick);
        gameDisplay.update();
    }

}
