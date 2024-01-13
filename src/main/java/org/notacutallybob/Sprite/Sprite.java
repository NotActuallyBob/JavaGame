package org.notacutallybob.Sprite;

import java.awt.Graphics2D;

import org.notacutallybob.Vector2D;

public abstract class Sprite {
    Vector2D size;
    Vector2D offset;

    public Sprite (Vector2D size, Vector2D offset) {
        this.size = size;
        this.offset = offset;
    }

    public abstract void draw(Graphics2D g2, Vector2D ownerScreenPosition);
}
