package org.notacutallybob.draw.sprite;

import org.notacutallybob.Camera;
import org.notacutallybob.Vector2D;
import org.notacutallybob.draw.Layer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class ImageSprite extends Sprite {

    BufferedImage image;

    public ImageSprite(Vector2D ownerWorldPosition, Vector2D size, Vector2D offset, Layer layer, String pathToImage) {
        super(ownerWorldPosition, size, offset, layer);
        loadImage(pathToImage);
    }

    private void loadImage(String pathToImage) {
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(pathToImage)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics2D g2, Camera camera) {
        updateSpritePosition(camera);
        g2.drawImage(image, screenPosition.getX(), screenPosition.getY(), size.getX(), size.getY(), null);
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
