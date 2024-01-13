package org.notacutallybob.draw;

import org.notacutallybob.Camera;
import org.notacutallybob.Vector2D;

import java.awt.*;

public interface Drawable {
    public void draw(Graphics2D g2, Camera camera);
    public Layer getLayer();

    public Vector2D getSize();
    public Vector2D getPosition();
}
