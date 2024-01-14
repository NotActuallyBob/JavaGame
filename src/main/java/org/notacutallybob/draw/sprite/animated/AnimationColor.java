package org.notacutallybob.draw.sprite.animated;

import java.awt.*;

public interface AnimationColor {
    public void tick();
    public void setType(String type);
    public void addType(String type, Color[] colorArray, int framesUntilNext);
}
