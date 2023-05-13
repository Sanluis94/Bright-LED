package com.example.projeto_integrador_java.map;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.projeto_integrador_java.graphics.Sprite;
import com.example.projeto_integrador_java.graphics.SpriteSheet;

public class Block3Tile extends Tile {
    private final Sprite sprite;

    public Block3Tile(SpriteSheet spriteSheet, Rect mapLocationRect) {
        super(mapLocationRect);
        sprite = spriteSheet.getBlock3Sprite();
    }

    @Override
    public void draw(Canvas canvas) {
        sprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);

    }
}
