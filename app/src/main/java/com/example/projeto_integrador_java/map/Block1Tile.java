package com.example.projeto_integrador_java.map;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.projeto_integrador_java.graphics.Sprite;
import com.example.projeto_integrador_java.graphics.SpriteSheet;

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
