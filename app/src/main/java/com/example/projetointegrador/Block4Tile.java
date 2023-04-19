package com.example.projetointegrador;

import android.graphics.Canvas;
import android.graphics.Rect;

public class Block4Tile extends Tile {
    private final Sprite sprite;

    public Block4Tile(SpriteSheet spriteSheet, Rect mapLocationRect) {
        super(mapLocationRect);
        sprite = spriteSheet.getBlock4Sprite();
    }

    @Override
    public void draw(Canvas canvas) {
        sprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);

    }
}
