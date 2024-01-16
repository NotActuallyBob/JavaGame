package org.notacutallybob.tile;

import org.notacutallybob.Vector2D;
import org.notacutallybob.draw.sprite.Sprite;

public class Tile {
    Vector2D worldPosition;
    Sprite sprite;

    public Tile(Vector2D worldPosition, Sprite sprite) {
        this.worldPosition = worldPosition;
        this.sprite = sprite;
    }
}
