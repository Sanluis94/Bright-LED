package com.example.projeto_integrador_java.map;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.projeto_integrador_java.graphics.SpriteSheet;

abstract class Tile {

    protected final Rect mapLocationRect;

    public Tile(Rect mapLocationRect) {
        this.mapLocationRect = mapLocationRect;
    }

    public enum TileType {
        BLOCK0_TILE,
        BLOCK1_TILE,
        BLOCK2_TILE,
        BLOCK3_TILE,
        BLOCK4_TILE
    }

    public static Tile getTile(int idxTileType, SpriteSheet spriteSheet, Rect mapLocationRect) {

        switch(TileType.values()[idxTileType]) {

            case BLOCK0_TILE:
                return new Block0Tile(spriteSheet, mapLocationRect);
            case BLOCK1_TILE:
                return new Block1Tile(spriteSheet, mapLocationRect);
            case BLOCK2_TILE:
                return new Block2Tile(spriteSheet, mapLocationRect);
            case BLOCK3_TILE:
                return new Block3Tile(spriteSheet, mapLocationRect);
            default:
                return null;
        }

    }

    public abstract void draw(Canvas canvas);
}
