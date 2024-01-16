package org.notacutallybob.draw.animation;

import org.notacutallybob.draw.sprite.BoxSprite;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class BoxAnimation extends AbstractAnimation {
    private BoxSprite boxSprite;
    private Color[] colorArray;

    public BoxAnimation(BoxSprite boxSprite, Color[] colors, int framesUntilNext) {
        super(framesUntilNext);
        this.boxSprite = boxSprite;
        this.colorArray = colors;
        this.animationLength = colorArray.length;
    }

    @Override
    protected void next() {
        boxSprite.setColor(colorArray[index]);
    }
}
