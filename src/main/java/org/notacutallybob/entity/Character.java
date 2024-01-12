package org.notacutallybob.entity;

import java.awt.image.BufferedImage;

public abstract class Character extends Entity {
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNumber = 1;
}
