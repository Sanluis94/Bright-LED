package com.example.projetointegrador;

import android.graphics.Canvas;
import android.graphics.Rect;

public class Block1Tile extends Tile {
    private final Sprite sprite;

    public Block1Tile(SpriteSheet spriteSheet, Rect mapLocationRect) {
        super(mapLocationRect);
        sprite = spriteSheet.getBlock1Sprite();
    }

    @Override
    public void draw(Canvas canvas) {
        sprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);

    }
}
