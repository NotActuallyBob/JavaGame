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

public class Player extends Character {
    GamePanel gamePanel;
    KeyHandler keyHandler;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        this.screenX = gamePanel.screenWidth / 2 - gamePanel.tileSize /2;
        this.screenY = gamePanel.screenHeigth / 2 - gamePanel.tileSize /2;

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
        getPlayerImage();
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void update() {
        if( keyHandler.upPressed ||
            keyHandler.downPressed ||
            keyHandler.leftPressed ||
            keyHandler.rightPressed) {
            spriteCounter++;
            if(spriteCounter > 12) {
                if(spriteNumber == 1) {
                    spriteNumber = 2;
                } else if (spriteNumber == 2) {
                    spriteNumber = 1;
                }
                spriteCounter = 0;
            }

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

            collisionOn = false;
            gamePanel.collisionManager.checkTile(this);

            if(!collisionOn){
                switch (direction) {
                    case "up":
                        worldPosition.setY(worldPosition.getY() - speed);
                        break;
                    case "down":
                        worldPosition.setY(worldPosition.getY() + speed);
                        break;
                    case "left":
                        worldPosition.setX(worldPosition.getX() - speed);
                        break;
                    case "right":
                        worldPosition.setX(worldPosition.getX() + speed);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch (direction) {
            case "up":
                if(spriteNumber == 1){
                    image = up1;    
                }
                if(spriteNumber == 2) {
                    image = up2;
                }
                
                break;
        
            case "down":
                if(spriteNumber == 1){
                    image = down1;    
                }
                if(spriteNumber == 2) {
                    image = down2;
                }
                
                break;
            
            case "left":
                if(spriteNumber == 1){
                    image = left1;    
                }
                if(spriteNumber == 2) {
                    image = left2;
                }
                
                break;
        
            case "right":
                if(spriteNumber == 1){
                    image = right1;    
                }
                if(spriteNumber == 2) {
                    image = right2;
                }
                
                break;

            default:
                break;
        }

        g2.drawImage(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);

        // g2.setColor(Color.WHITE);
        // g2.fillRect(positionX, positionY, gamePanel.tileSize, gamePanel.tileSize);
    }
}
