package org.notacutallybob;

public class CollisionManager {
    GamePanel gamePanel;
    
    public CollisionManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public boolean checkTile(Vector2D worldPosition, Vector2D size) {
        int entityLeftWorldX = worldPosition.getX() - size.getX() / 2;
        int entityRightWorldX = worldPosition.getX() + size.getX() / 2;
        int entityTopWorldY = worldPosition.getY() - size.getY() / 2;
        int entityBottomWorldY = worldPosition.getY() + size.getY() / 2;

        int entityLeftColumn = entityLeftWorldX / gamePanel.tileSize;
        int entityRightColumn = entityRightWorldX / gamePanel.tileSize;
        int entityTopRow = entityTopWorldY / gamePanel.tileSize;
        int entityBottomRow = entityBottomWorldY / gamePanel.tileSize;

        int tileType1 = gamePanel.tileManager.mapTileNum[entityLeftColumn][entityTopRow];
        int tileType2 = gamePanel.tileManager.mapTileNum[entityRightColumn][entityTopRow];
        int tileType3 = gamePanel.tileManager.mapTileNum[entityLeftColumn][entityBottomRow];
        int tileType4 = gamePanel.tileManager.mapTileNum[entityRightColumn][entityBottomRow];

        if(gamePanel.tileManager.tileTypes[tileType1].collision 
            || gamePanel.tileManager.tileTypes[tileType2].collision
            || gamePanel.tileManager.tileTypes[tileType3].collision
            || gamePanel.tileManager.tileTypes[tileType4].collision){
            return true;
        }
        return false;
    }
 }
