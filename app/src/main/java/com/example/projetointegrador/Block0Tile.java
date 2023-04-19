package com.example.projetointegrador;

import android.graphics.Canvas;
import android.graphics.Rect;

public class Block0Tile extends Tile {
    private final Sprite sprite;

    public Block0Tile(SpriteSheet spriteSheet, Rect mapLocationRect) {
        super(mapLocationRect);
        sprite = spriteSheet.getBlock0Sprite();
    }

    @Override
    public void draw(Canvas canvas) {
        sprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);

    }
}
