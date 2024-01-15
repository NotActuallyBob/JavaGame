package org.notacutallybob.draw.animation;

import org.notacutallybob.draw.sprite.BoxSprite;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class BoxAnimation extends AbstractAnimation {
    BoxSprite boxSprite;
    Color[] colorArray;

    public BoxAnimation(BoxSprite boxSprite, Color[] colors, int framesUntilNext) {
        super(framesUntilNext);
        this.boxSprite = boxSprite;
        this.colorArray = colors;
        this.animationLength = colorArray.length;
    }

    @Override
    void next() {
        boxSprite.setColor(colorArray[index]);
    }
}
