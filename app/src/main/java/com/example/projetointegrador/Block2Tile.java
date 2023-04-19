package com.example.projetointegrador;

import android.graphics.Canvas;
import android.graphics.Rect;

public class Block2Tile extends Tile {
    private final Sprite sprite;

    public Block2Tile(SpriteSheet spriteSheet, Rect mapLocationRect) {
        super(mapLocationRect);
        sprite = spriteSheet.getBlock2Sprite();
    }

    @Override
    public void draw(Canvas canvas) {
        sprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);

    }
}
