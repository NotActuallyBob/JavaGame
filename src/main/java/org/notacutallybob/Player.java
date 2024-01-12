package org.notacutallybob;

import java.awt.Graphics2D;

import org.notacutallybob.Animation.Animation;
import org.notacutallybob.Animation.PlayerAnimation;

public class Player {
    GamePanel gamePanel;
    KeyHandler keyHandler;
    Animation animation;
    public Vector2D worldPosition;
    public Vector2D screenPosition;
    Vector2D collisionSize;
    Vector2D drawSize;
    int speed;
    String direction;

    public boolean collided = false;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        this.screenPosition = new Vector2D(0, 0);

        this.collisionSize = new Vector2D(gamePanel.tileSize/2, gamePanel.tileSize/2);
        this.drawSize = new Vector2D(gamePanel.tileSize, gamePanel.tileSize);
        this.animation = new PlayerAnimation();

        init();
    }

    public void init() {
        worldPosition = new Vector2D(gamePanel.tileSize * 25, gamePanel.tileSize * 25);
        gamePanel.cameraPosition = worldPosition;
        speed = 5;
        direction = "down";
    }

    void updateScreenPosition() {
        this.screenPosition.setX(worldPosition.getX() - gamePanel.cameraPosition.getX() + gamePanel.screenWidth / 2 - drawSize.getX() / 2);
        this.screenPosition.setY(worldPosition.getY() - gamePanel.cameraPosition.getY() + gamePanel.screenHeigth / 2 - drawSize.getY() / 2);
    }

    public void update() {
        System.out.println(worldPosition);
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

            collided = gamePanel.collisionManager.checkTile(moveVectorInDirection(new Vector2D(worldPosition), direction), collisionSize);

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
        updateScreenPosition();
        g2.drawImage(animation.getImage(direction), screenPosition.getX(), screenPosition.getY(), drawSize.getX(), drawSize.getY(), null);

        // g2.setColor(Color.WHITE);
        // g2.fillRect(positionX, positionY, gamePanel.tileSize, gamePanel.tileSize);
    }
}
