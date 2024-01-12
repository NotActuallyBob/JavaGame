package org.notacutallybob.Animation;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PlayerAnimation extends CharacterAnimation {

    public PlayerAnimation() {
        super();
        spriteCount = 2;
    }


    public void getImagesFromFile() {
        try {
            BufferedImage[] upImages = new BufferedImage[2];
            upImages[0] = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
            upImages[1] = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));

            BufferedImage[] downImages = new BufferedImage[2];
            downImages[0] = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
            downImages[1] = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));

            BufferedImage[] leftImages = new BufferedImage[2];
            leftImages[0] = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
            leftImages[1] = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));

            BufferedImage[] rightImages = new BufferedImage[2];
            rightImages[0] = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
            rightImages[1] = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));

            directionToImageArray.put("up", upImages);
            directionToImageArray.put("down", downImages);
            directionToImageArray.put("left", leftImages);
            directionToImageArray.put("right", rightImages);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
