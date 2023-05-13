package com.example.projeto_integrador_java.map;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.projeto_integrador_java.graphics.Sprite;
import com.example.projeto_integrador_java.graphics.SpriteSheet;

public class Block2Tile extends Tile {
    private final Sprite block2Sprite;

    public Block2Tile(SpriteSheet spriteSheet, Rect mapLocationRect) {
        super(mapLocationRect);
        block2Sprite = spriteSheet.getBlock2Sprite();
    }

    @Override
    public void draw(Canvas canvas) {
        block2Sprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);

    }
}
