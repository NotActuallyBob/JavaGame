package org.notacutallybob;

import java.awt.*;

import org.notacutallybob.draw.Layer;
import org.notacutallybob.draw.sprite.BoxSprite;
import org.notacutallybob.draw.animation.Animation;
import org.notacutallybob.draw.animation.BoxAnimation;

public class Player {
    GamePanel gamePanel;
    KeyHandler keyHandler;

    BoxSprite sprite;
    Animation animation;

    public Vector2D worldPosition;

    int speed;
    String direction;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        init();
    }

    public void init() {
        worldPosition = new Vector2D(gamePanel.tileSize * 8, gamePanel.tileSize * 6);
        sprite = new BoxSprite(worldPosition, new Vector2D(gamePanel.tileSize, gamePanel.tileSize), new Vector2D(-gamePanel.tileSize / 2, -gamePanel.tileSize / 2), Layer.Player, Color.RED);
        Color[] normalColors = new Color[]{Color.RED, Color.YELLOW, Color.GREEN};
        animation = new BoxAnimation(sprite, normalColors, 12);
        gamePanel.camera.worldPosition = worldPosition;
        speed = 5;
        direction = "down";
    }

    public void update() {
        animation.tick();

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

            worldPosition.move(direction, speed);
        }
    }
}
