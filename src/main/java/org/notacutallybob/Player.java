package org.notacutallybob;
import java.awt.Graphics2D;

import org.notacutallybob.Sprite.BoxSprite;
import org.notacutallybob.Sprite.ImageSprite;
import org.notacutallybob.Sprite.Sprite;

public class Player {
    GamePanel gamePanel;
    KeyHandler keyHandler;
    Sprite sprite;

    public Vector2D worldPosition;
    Vector2D collisionSize;
    
    int speed;
    String direction;

    public boolean collided = false;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        Vector2D spriteSize = new Vector2D(gamePanel.tileSize, gamePanel.tileSize);
        Vector2D spriteOffset = new Vector2D(-spriteSize.getX() / 2, -spriteSize.getY() / 2);
        this.sprite = new ImageSprite(spriteSize, spriteOffset, "/player/boy_up_1.png");

        this.collisionSize = new Vector2D(gamePanel.tileSize, gamePanel.tileSize);

        init();
    }

    public void init() {
        worldPosition = new Vector2D(gamePanel.tileSize * 8, gamePanel.tileSize * 6);
        gamePanel.camera.worldPosition = worldPosition;
        speed = 5;
        direction = "down";
    }

    public void update() {
        if(keyHandler.shootPressed) {
            gamePanel.projectiles.add(new Projectile(gamePanel, new Vector2D(worldPosition)));
        }

        if( keyHandler.upPressed ||
            keyHandler.downPressed ||
            keyHandler.leftPressed ||
            keyHandler.rightPressed) {

            if(keyHandler.upPressed) {
                direction = "up";
            } else if(keyHandler.downPressed) {
                direction = "down";
            }

            if(keyHandler.leftPressed) {
                direction = "left";
            } else if(keyHandler.rightPressed) {
                direction = "right";
            }

            if(!collided){
                moveVectorInDirection(worldPosition, direction);
            }
        }
    }

    public Vector2D moveVectorInDirection(Vector2D vector2d, String direction) {
        switch (direction) {
            case "up":
                vector2d.moveY(-speed);
                break;
            case "down":
                vector2d.moveY(speed);
                break;
            case "left":
                vector2d.moveX(-speed);
                break;
            case "right":
                vector2d.moveX(speed);
                break;
            default:
                break;
        }
        return vector2d;
    }

    public void draw(Graphics2D g2) {
        sprite.draw(g2, gamePanel.camera.getScreenPosition(worldPosition));

        // g2.setColor(Color.WHITE);
        // g2.fillRect(positionX, positionY, gamePanel.tileSize, gamePanel.tileSize);
    }
}
