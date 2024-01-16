package org.notacutallybob.draw.animation;

import org.notacutallybob.draw.sprite.ImageSprite;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class ImageAnimation extends AbstractAnimation {
    private ImageSprite imageSprite;
    private BufferedImage[] imageArray;

    public ImageAnimation (ImageSprite imageSprite, String[] imagePaths, int framesUntilNext) {
        super(framesUntilNext);
        this.imageSprite = imageSprite;
        this.animationLength = imagePaths.length;
        loadImages(imagePaths);
    }

    private void loadImages(String[] imagePaths) {
        imageArray = new BufferedImage[imagePaths.length];
        for (int i = 0; i < imagePaths.length; i++) {
            try {
                imageArray[i] = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(imagePaths[i])));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void next() {
        imageSprite.setImage(imageArray[index]);
    }
}
