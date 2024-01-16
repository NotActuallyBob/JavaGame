package org.notacutallybob;

import org.notacutallybob.draw.Drawable;

public class Camera {
    public GamePanel gamePanel;
    public Vector2D worldPosition;
    public Vector2D captureSize;

    public Camera (GamePanel gamePanel, Vector2D worldPosition, Vector2D captureSize) {
        this.gamePanel = gamePanel;
        this.worldPosition = worldPosition;
        this.captureSize = captureSize;
    }

    public Vector2D updateScreenPosition (Vector2D gameObjectWorldPosition) {
        Vector2D screenPosition = new Vector2D(
                gamePanel.windowMargin.getX() + gameObjectWorldPosition.getX() - worldPosition.getX() + gamePanel.screenWidth / 2,
                gamePanel.windowMargin.getY() + gameObjectWorldPosition.getY() - worldPosition.getY() + gamePanel.screenHeigth / 2);
        return screenPosition;
    }

    public boolean isVisible(Drawable drawable) {
        if(worldPosition.getX() - drawable.getPosition().getX() - drawable.getSize().getX() > captureSize.getX() / 2){
            return false;
        }
        if(drawable.getPosition().getX() - worldPosition.getX() > captureSize.getX() / 2) {
            return false;
        }
        if(worldPosition.getY() - drawable.getPosition().getY() - drawable.getSize().getY() > captureSize.getY() / 2){
            return false;
        }
        if(drawable.getPosition().getY() - worldPosition.getY() > captureSize.getY() / 2) {
            return false;
        }
        return true;
    }
}
