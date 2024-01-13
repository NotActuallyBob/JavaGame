package org.notacutallybob.Sprite;

import java.awt.Graphics2D;

import org.notacutallybob.Vector2D;

public class BoxSprite extends Sprite {

    public BoxSprite(Vector2D size, Vector2D offset) {
        super(size, offset);
    }

    @Override
    public void draw(Graphics2D g2, Vector2D ownerScreenPosition) {
        g2.fillRect(ownerScreenPosition.getX() + offset.getX(), ownerScreenPosition.getY() + offset.getY(), size.getX(), size.getY());
    }
    
}
