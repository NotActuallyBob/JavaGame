package org.notacutallybob;

import org.notacutallybob.entity.Character;
import org.notacutallybob.entity.Entity;

public class CollisionManager {
    GamePanel gamePanel;
    
    public CollisionManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void checkTile(Character entity) {
        int entityLeftWorldX = entity.worldPosition.getX() + entity.collisionBox.x;
        int entityRightWorldX = entity.worldPosition.getX() + entity.collisionBox.x + entity.collisionBox.width;
        int entityTopWorldY = entity.worldPosition.getY() + entity.collisionBox.y;
        int entityBottomWorldY = entity.worldPosition.getY() + entity.collisionBox.y + entity.collisionBox.height;

        int entityLeftColumn = entityLeftWorldX / gamePanel.tileSize;
        int entityRightColumn = entityRightWorldX / gamePanel.tileSize;
        int entityTopRow = entityTopWorldY / gamePanel.tileSize;
        int entityBottomRow = entityBottomWorldY / gamePanel.tileSize;

        int tileType1, tileType2;

        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / gamePanel.tileSize;
                tileType1 = gamePanel.tileManager.mapTileNum[entityLeftColumn][entityTopRow];
                tileType2 = gamePanel.tileManager.mapTileNum[entityRightColumn][entityTopRow];
                if(gamePanel.tileManager.tileTypes[tileType1].collision || gamePanel.tileManager.tileTypes[tileType2].collision){
                    entity.collided = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed) / gamePanel.tileSize;
                tileType1 = gamePanel.tileManager.mapTileNum[entityLeftColumn][entityBottomRow];
                tileType2 = gamePanel.tileManager.mapTileNum[entityRightColumn][entityBottomRow];
                if(gamePanel.tileManager.tileTypes[tileType1].collision || gamePanel.tileManager.tileTypes[tileType2].collision){
                    entity.collided = true;
                }
                break;
            case "left":
                entityLeftColumn = (entityLeftWorldX - entity.speed) / gamePanel.tileSize;
                tileType1 = gamePanel.tileManager.mapTileNum[entityLeftColumn][entityTopRow];
                tileType2 = gamePanel.tileManager.mapTileNum[entityLeftColumn][entityBottomRow];
                if(gamePanel.tileManager.tileTypes[tileType1].collision || gamePanel.tileManager.tileTypes[tileType2].collision){
                    entity.collided = true;
                }
                break;
            case "right":
                entityRightColumn = (entityRightWorldX + entity.speed) / gamePanel.tileSize;
                tileType1 = gamePanel.tileManager.mapTileNum[entityRightColumn][entityTopRow];
                tileType2 = gamePanel.tileManager.mapTileNum[entityRightColumn][entityBottomRow];
                if(gamePanel.tileManager.tileTypes[tileType1].collision || gamePanel.tileManager.tileTypes[tileType2].collision){
                    entity.collided = true;
                }
                break;
            default:
                break;
        }
    }
 }
