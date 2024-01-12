package org.notacutallybob.entity;

import java.awt.Rectangle;

import org.notacutallybob.Vector2D;

public abstract class Entity {
    public Vector2D worldPosition;
    public int speed;
    
    public Rectangle collisionBox;
    public boolean collisionOn = false;
}
