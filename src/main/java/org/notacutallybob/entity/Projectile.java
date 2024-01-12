package org.notacutallybob.entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import org.notacutallybob.GamePanel;
import org.notacutallybob.Vector2D;

public class Projectile extends Entity {

    public Projectile(GamePanel gamePanel, Vector2D position) {
        this.gamePanel = gamePanel;

        this.worldPosition = position;
        this.size = new Vector2D(gamePanel.tileSize / 2 , gamePanel.tileSize);

        collisionBox = new Rectangle();
        collisionBox.x = 8;
        collisionBox.y = 16;
        collisionBox.width = 32;
        collisionBox.height = 32; 
    }

    public void update() {
        updateScreenPosition(gamePanel.player.worldPosition);
    }

    public void draw(Graphics2D g2) {
        g2.drawRect(screenPosition.getX(), screenPosition.getY(), size.getX(), size.getY());
    }
}
