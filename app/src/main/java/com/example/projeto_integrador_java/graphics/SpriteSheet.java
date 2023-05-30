package com.example.projeto_integrador_java.graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.example.projeto_integrador_java.R;


public class SpriteSheet {
    private static final int SPRITE_WIDTH_PIXELS = 64;
    private static final int SPRITE_HEIGHT_PIXELS = 64;
    private Bitmap bitmap;

    public SpriteSheet(Context context){
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inScaled = false;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.sprite_sheet, bitmapOptions);

    }

    public Sprite getEnemySprite() {
        return new Sprite(this, new Rect(2*64, 3*64, 3*64, 4*64));

    }

    public Sprite getSpellSprite() {
        return new Sprite(this, new Rect(0*64, 3*64,1*64, 4*64 ));

    }

    public Sprite getCapacitorSprite() {
        return new Sprite(this, new Rect(1*64, 3*64, 2*64, 4*64));
    }
    public Sprite[] getPlayerSpriteArray() {
        Sprite[] spriteArray = new Sprite[12];
        spriteArray[0] = new Sprite(this, new Rect(0*64, 0, 1*64, 64));
        spriteArray[1] = new Sprite(this, new Rect(1*64, 0, 2*64, 64));
        spriteArray[2] = new Sprite(this, new Rect(2*64, 0, 3*64, 64));
        spriteArray[3] = new Sprite(this, new Rect(4*64, 0, 4*64, 64));
        spriteArray[4] = new Sprite(this, new Rect(5*64, 0, 5*64, 64));
        spriteArray[5] = new Sprite(this, new Rect(6*64, 0, 6*64, 64));
        spriteArray[6] = new Sprite(this, new Rect(7*64, 0, 7*64, 64));
        spriteArray[7] = new Sprite(this, new Rect(8*64, 0, 8*64, 64));
        spriteArray[8] = new Sprite(this, new Rect(9*64, 0, 9*64, 64));
        spriteArray[9] = new Sprite(this, new Rect(10*64, 0, 10*64, 64));
        spriteArray[10] = new Sprite(this, new Rect(11*64, 0, 11*64, 64));
        spriteArray[11] = new Sprite(this, new Rect(12*64, 0, 12*64, 64));
        return spriteArray;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }


    public Sprite getBlock0Sprite() {
        return getSpriteByIndex(1, 0);
    }

    public Sprite getBlock1Sprite() {
        return getSpriteByIndex(1, 1);
    }

    public Sprite getBlock2Sprite() {
        return getSpriteByIndex(1, 2);
    }

    public Sprite getBlock3Sprite() {
        return getSpriteByIndex(1, 3);
    }


    private Sprite getSpriteByIndex(int idxRow, int idxCol) {
        return new Sprite(this, new Rect(
                idxCol * SPRITE_WIDTH_PIXELS,
                idxRow * SPRITE_HEIGHT_PIXELS,
                (idxCol + 1) * SPRITE_WIDTH_PIXELS,
                (idxRow + 1) * SPRITE_HEIGHT_PIXELS
        ));
    }
}
