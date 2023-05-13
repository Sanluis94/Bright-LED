package com.example.projeto_integrador_java.map;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.projeto_integrador_java.graphics.Sprite;
import com.example.projeto_integrador_java.graphics.SpriteSheet;

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
