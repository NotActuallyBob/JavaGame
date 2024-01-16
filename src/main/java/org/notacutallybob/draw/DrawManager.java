package org.notacutallybob.draw;

import org.notacutallybob.Camera;

import java.awt.*;

public class DrawManager {
    private static DrawManager instance;
    Drawable[] drawables;
    Camera camera;

    private DrawManager () {
        drawables = new Drawable[0];
    }

    public static DrawManager getInstance() {
        if(instance == null) {
            instance = new DrawManager();
        }
        return instance;
    }

    public void draw(Graphics2D g2) {
        for (Drawable drawable : drawables) {
            if(camera.isVisible(drawable)) {
                drawable.draw(g2, camera);
            }
        }
    }

    public void changeCamera(Camera camera) {
        this.camera = camera;
    }

    public void addDrawable(Drawable drawable) {
        int layer = drawable.getLayer().getValue();
        Drawable[] newDrawables = new Drawable[drawables.length + 1];
        int i = 0;
        while (i < drawables.length && drawables[i].getLayer().getValue() < layer) {
            newDrawables[i] = drawables[i];
            i++;
        }
        newDrawables[i] = drawable;
        while (i < drawables.length) {
            newDrawables[i + 1] = drawables[i];
            i++;
        }

        drawables = newDrawables;
    }
}
