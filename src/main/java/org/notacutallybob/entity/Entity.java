package org.notacutallybob.entity;

import java.awt.Rectangle;

import org.notacutallybob.GamePanel;
import org.notacutallybob.Vector2D;

public abstract class Entity {
    public GamePanel gamePanel;
    public Vector2D worldPosition;
    public Vector2D screenPosition = new Vector2D(0, 0);

    public int speed;
    public Vector2D size;
    
    public Rectangle collisionBox;
    public boolean collided = false;

    void updateScreenPosition(Vector2D cameraWorldPosition) {
        this.screenPosition.setX(worldPosition.getX() - cameraWorldPosition.getX() + gamePanel.screenWidth / 2 - size.getX() / 2);
        this.screenPosition.setY(worldPosition.getY() - cameraWorldPosition.getY() + gamePanel.screenHeigth / 2 - size.getY() / 2);
    }
}
