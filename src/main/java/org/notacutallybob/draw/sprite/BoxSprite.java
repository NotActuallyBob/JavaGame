package org.notacutallybob.draw.sprite;

import org.notacutallybob.Camera;
import org.notacutallybob.Vector2D;
import org.notacutallybob.draw.Layer;

import java.awt.*;

public class BoxSprite extends Sprite {
    private Color color;

    public BoxSprite(Vector2D ownerWorldPosition, Vector2D size, Vector2D offset, Layer layer, Color color) {
        super(ownerWorldPosition, size, offset, layer);
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2, Camera camera) {
        updateSpritePosition(camera);
        g2.setColor(color);
        g2.fillRect(screenPosition.getX(), screenPosition.getY(), size.getX(), size.getY());
        g2.setColor(Color.BLACK);
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
