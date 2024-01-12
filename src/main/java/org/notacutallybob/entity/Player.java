package org.notacutallybob.entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.notacutallybob.GamePanel;
import org.notacutallybob.KeyHandler;
import org.notacutallybob.Vector2D;
import org.notacutallybob.entity.Animation.PlayerAnimation;

public class Player extends Character {
    KeyHandler keyHandler;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        this.size = new Vector2D(gamePanel.tileSize, gamePanel.tileSize);
        this.animation = new PlayerAnimation();

        collisionBox = new Rectangle();
        collisionBox.x = 8;
        collisionBox.y = 16;
        collisionBox.width = 32;
        collisionBox.height = 32; 

        init();
    }

    public void init() {
        worldPosition = new Vector2D(gamePanel.tileSize * 25, gamePanel.tileSize * 25);
        speed = 5;
        direction = "down";
    }

    

    public void update() {
        updateScreenPosition(worldPosition);

        if(keyHandler.shootPressed) {
            gamePanel.projectiles.add(new Projectile(gamePanel, new Vector2D(worldPosition)));
        }

        if( keyHandler.upPressed ||
            keyHandler.downPressed ||
            keyHandler.leftPressed ||
            keyHandler.rightPressed) {

            animation.tick();

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

            collided = false;
            gamePanel.collisionManager.checkTile(this);

            if(!collided){
                switch (direction) {
                    case "up":
                        worldPosition.moveY(-speed);
                        break;
                    case "down":
                        worldPosition.moveY(speed);
                        break;
                    case "left":
                        worldPosition.moveX(-speed);
                        break;
                    case "right":
                        worldPosition.moveX(speed);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(animation.getImage(direction), screenPosition.getX(), screenPosition.getY(), gamePanel.tileSize, gamePanel.tileSize, null);

        // g2.setColor(Color.WHITE);
        // g2.fillRect(positionX, positionY, gamePanel.tileSize, gamePanel.tileSize);
    }
}
