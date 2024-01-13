package org.notacutallybob;

public class Camera {
    public GamePanel gamePanel;
    public Vector2D worldPosition;
    public Vector2D captureSize;

    public Camera (GamePanel gamePanel, Vector2D worldPosition, Vector2D captureSize) {
        this.gamePanel = gamePanel;
        this.worldPosition = worldPosition;
        this.captureSize = captureSize;
    }

    public void updateScreenPosition (Vector2D screenPosition, Vector2D gameObjectWorldPosition) {
        screenPosition.setX(gamePanel.windowMargin.getX() + gameObjectWorldPosition.getX() - worldPosition.getX() + gamePanel.screenWidth / 2 );
        screenPosition.setY(gamePanel.windowMargin.getY() + gameObjectWorldPosition.getY() - worldPosition.getY() + gamePanel.screenHeigth / 2);
    }

    public boolean isVisible(Vector2D gameObjectWorldPosition, Vector2D drawSize) {
        if(worldPosition.getX() - gameObjectWorldPosition.getX() - drawSize.getX() > captureSize.getX() / 2){
            return false;
        }
        if(gameObjectWorldPosition.getX() - worldPosition.getX() > captureSize.getX() / 2) {
            return false;
        }
        if(worldPosition.getY() - gameObjectWorldPosition.getY() - drawSize.getY() > captureSize.getY() / 2){
            return false;
        }
        if(gameObjectWorldPosition.getY() - worldPosition.getY() > captureSize.getY() / 2) {
            return false;
        }
        return true;
    }
}
