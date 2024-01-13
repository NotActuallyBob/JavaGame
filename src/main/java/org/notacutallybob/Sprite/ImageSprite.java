package org.notacutallybob.Sprite;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.notacutallybob.Vector2D;

public class ImageSprite extends Sprite {
    BufferedImage image;

    public ImageSprite(Vector2D size, Vector2D offset, String imagePath) {
        super(size, offset);
        getImageFromFile(imagePath);
    }

    public void getImageFromFile(String imagePath) {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    @Override
    public void draw(Graphics2D g2, Vector2D ownerScreenPosition) {
        g2.drawImage(image, ownerScreenPosition.getX() + offset.getX(), ownerScreenPosition.getY() + offset.getY(), size.getX(), size.getY(), null);
    }
    
}
