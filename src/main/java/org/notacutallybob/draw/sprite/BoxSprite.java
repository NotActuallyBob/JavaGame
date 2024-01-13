package org.notacutallybob.draw.sprite;

import org.notacutallybob.Camera;
import org.notacutallybob.Vector2D;
import org.notacutallybob.draw.Layer;

import java.awt.*;

public class BoxSprite extends Sprite {
    Color color;

    public BoxSprite(Vector2D ownerWorldPosition, Vector2D size, Vector2D offset, Layer layer, Color color) {
        super(ownerWorldPosition, size, offset, layer);
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2, Camera camera) {
        super.draw(g2, camera);
        g2.setColor(color);
        g2.fillRect(screenPosition.getX(), screenPosition.getY(), size.getX(), size.getY());
        g2.setColor(Color.BLACK);
    }
}
