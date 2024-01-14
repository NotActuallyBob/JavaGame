package org.notacutallybob.draw.sprite.animated;

import org.notacutallybob.Vector2D;
import org.notacutallybob.draw.Drawable;
import org.notacutallybob.draw.Layer;
import org.notacutallybob.draw.sprite.BoxSprite;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class BoxAnimation implements AnimationColor {
    BoxSprite boxSprite;
    String[] types;
    Map<String, Color[]> typeToColorArray;
    Map<String, Integer> typeToFramesUntilNext;
    String currentType;
    int framesPassedAfterSwitch;
    int index;

    public BoxAnimation(BoxSprite boxSprite) {
        this.boxSprite = boxSprite;
        this.typeToFramesUntilNext = new HashMap<>();
        this.typeToColorArray = new HashMap<>();
    }

    @Override
    public void tick() {
        framesPassedAfterSwitch++;
        if(framesPassedAfterSwitch == typeToFramesUntilNext.get(currentType)) {
            framesPassedAfterSwitch = 0;
            index++;
        }
        if(index == typeToColorArray.get(currentType).length) {
            index = 0;
        }
        boxSprite.setColor(typeToColorArray.get(currentType)[index]);
    }

    @Override
    public void setType(String type) {
        if(typeToColorArray.containsKey(type)) {
            currentType = type;
        }
    }

    @Override
    public void addType(String type, Color[] colorArray, int framesUntilNext) {
        typeToColorArray.put(type, colorArray);
        typeToFramesUntilNext.put(type, framesUntilNext);
    }
}
