package org.notacutallybob;

import org.notacutallybob.draw.Layer;
import org.notacutallybob.draw.animation.ImageAnimation;
import org.notacutallybob.draw.animation.Animation;
import org.notacutallybob.draw.sprite.ImageSprite;

public class Player {
    GamePanel gamePanel;
    KeyHandler keyHandler;

    ImageSprite sprite;
    Animation currentAnimation;
    Animation animationNone, animationUp, animationDown, animationLeft, animationRight;

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

        sprite = new ImageSprite(worldPosition, new Vector2D(gamePanel.tileSize, gamePanel.tileSize), new Vector2D(-gamePanel.tileSize / 2, -gamePanel.tileSize / 2), Layer.Player, "/player/boy_up_1.png");

        String[] imagePathsUp = new String[]{"/player/boy_up_1.png", "/player/boy_up_2.png"};
        String[] imagePathsDown = new String[]{"/player/boy_down_1.png", "/player/boy_down_2.png"};
        String[] imagePathsLeft = new String[]{"/player/boy_left_1.png", "/player/boy_left_2.png"};
        String[] imagePathsRight = new String[]{"/player/boy_right_1.png", "/player/boy_right_2.png"};

        animationUp = new ImageAnimation(sprite, imagePathsUp, 12);
        animationDown = new ImageAnimation(sprite, imagePathsDown, 12);
        animationLeft = new ImageAnimation(sprite, imagePathsLeft, 12);
        animationRight = new ImageAnimation(sprite, imagePathsRight, 12);

        currentAnimation = null;

        gamePanel.camera.worldPosition = worldPosition;
        speed = 5;
        direction = "down";
    }

    public void update() {
        if(currentAnimation != null){
            currentAnimation.tick();
        }

        if( keyHandler.upPressed ||
            keyHandler.downPressed ||
            keyHandler.leftPressed ||
            keyHandler.rightPressed) {


            if(keyHandler.upPressed) {
                direction = "up";
                currentAnimation = animationUp;
            } else if(keyHandler.downPressed) {
                direction = "down";
                currentAnimation = animationDown;
            }

            if(keyHandler.leftPressed) {
                direction = "left";
                currentAnimation = animationLeft;
            } else if(keyHandler.rightPressed) {
                direction = "right";
                currentAnimation = animationRight;
            }

            worldPosition.move(direction, speed);
        } else {
            currentAnimation = null;
        }
    }
}
