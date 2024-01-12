package org.notacutallybob.entity.Animation;

import java.awt.image.BufferedImage;

public interface Animation {
    public BufferedImage getImage(String direction);
    public void tick();
}
