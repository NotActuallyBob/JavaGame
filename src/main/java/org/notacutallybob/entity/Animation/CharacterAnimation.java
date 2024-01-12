package org.notacutallybob.entity.Animation;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public abstract class CharacterAnimation implements Animation {
    protected Map<String, BufferedImage[]> directionToImageArray;
    protected int spriteIndex;
    protected int spriteCount;

    private int updateIndex;
    private int updatesToChangeSprite;

    public CharacterAnimation() {
        spriteIndex = 0;
        updateIndex = 0;
        updatesToChangeSprite = 12;
        directionToImageArray = new HashMap<String, BufferedImage[]>();
        getImagesFromFile();
    }

    @Override
    public void tick() {
        updateIndex++;
        if(updateIndex >= updatesToChangeSprite) {
            spriteIndex++;
            updateIndex = 0;
        }
        if(spriteIndex >= spriteCount) {
            spriteIndex = 0;
        }
    }

    @Override
    public BufferedImage getImage(String direction) {
        return directionToImageArray.get(direction)[spriteIndex];
    }

    protected abstract void getImagesFromFile();
}
