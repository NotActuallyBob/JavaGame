package org.notacutallybob.entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.notacutallybob.GamePanel;
import org.notacutallybob.KeyHandler;

public class Player extends Entity {
    GamePanel gamePanel;
    KeyHandler keyHandler;

    public int worldX;
    public int worldY;
    public final int screenX;
    public final int screenY;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        this.screenX = gamePanel.screenWidth / 2 - gamePanel.tileSize /2;
        this.screenY = gamePanel.screenHeigth / 2 - gamePanel.tileSize /2;

        init();
    }

    public void init() {
        worldX = gamePanel.tileSize * 25;
        worldY = gamePanel.tileSize * 25;
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
        if(keyHandler.upPressed) {
            worldY -= speed;
            direction = "up";
        } else if(keyHandler.downPressed) {
            worldY += speed;
            direction = "down";
        }

        if(keyHandler.leftPressed) {
            worldX -= speed;
            direction = "left";
        } else if(keyHandler.rightPressed) {
            worldX += speed;
            direction = "right";
        }

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
