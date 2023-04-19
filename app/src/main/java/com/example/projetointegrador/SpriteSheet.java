package com.example.projetointegrador;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class SpriteSheet {
    private static final int SPRITE_WIDTH_PIXELS = 64;
    private static final int SPRITE_HEIGHT_PIXELS = 64;
    private Bitmap bitmap;

    public SpriteSheet(Context context){
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inScaled = false;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.sprite_sheet, bitmapOptions);

    }

    public Sprite getPlayerSprite() {
        return new Sprite(this, new Rect(0, 0, 64, 64));

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

    public Sprite getBlock4Sprite() {
        return getSpriteByIndex(1, 4);
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
