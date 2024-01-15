package org.notacutallybob.draw.sprite;

import org.notacutallybob.Camera;
import org.notacutallybob.Vector2D;
import org.notacutallybob.draw.DrawManager;
import org.notacutallybob.draw.Drawable;
import org.notacutallybob.draw.Layer;

import java.awt.*;

public abstract class Sprite implements Drawable {
    Vector2D ownerWorldPosition;
    Vector2D spriteWorldPosition;
    Vector2D screenPosition;
    Vector2D size;
    Vector2D offset;
    Layer layer;

    public Sprite(Vector2D ownerWorldPosition, Vector2D size, Vector2D offset, Layer layer) {
        this.ownerWorldPosition = ownerWorldPosition;
        this.size = size;
        this.offset = offset;
        this.spriteWorldPosition = Vector2D.zeroVector();
        this.screenPosition = Vector2D.zeroVector();
        this.layer = layer;

        DrawManager.getInstance().addDrawable(this);
    }

    @Override
    public Layer getLayer() {
        return layer;
    }

    protected void updateSpritePosition(Camera camera) {
        spriteWorldPosition.set(ownerWorldPosition.getX() + offset.getX(), ownerWorldPosition.getY() + offset.getY());
        screenPosition.set(camera.updateScreenPosition(spriteWorldPosition));
    }

    @Override
    public Vector2D getSize() {
        return size;
    }

    @Override
    public Vector2D getPosition() {
        return spriteWorldPosition;
    }
}
