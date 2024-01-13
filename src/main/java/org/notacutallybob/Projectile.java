package org.notacutallybob;

import java.awt.Graphics2D;

public class Projectile {

    GamePanel gamePanel;
    Vector2D worldPosition;
    Vector2D screenPosition;
    Vector2D size;
    Vector2D drawSize;

    public Projectile(GamePanel gamePanel, Vector2D position) {
        this.gamePanel = gamePanel;

        this.screenPosition = new Vector2D(0, 0);
        this.worldPosition = position;
        this.size = new Vector2D(gamePanel.tileSize / 2 , gamePanel.tileSize / 2);
        this.drawSize = new Vector2D(gamePanel.tileSize, gamePanel.tileSize);
    }

    public void update() {
    }

    public void draw(Graphics2D g2) {
        // gamePanel.camera.getScreenPosition(screenPosition, worldPosition);
        // screenPosition.move(drawSize.getX() / 2, drawSize.getY() /2);
        // g2.drawRect(screenPosition.getX(), screenPosition.getY(), drawSize.getX(), drawSize.getY());
    }
}
