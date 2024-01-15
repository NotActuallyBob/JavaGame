package org.notacutallybob.draw.animation;

import org.notacutallybob.draw.sprite.Sprite;

public abstract class AbstractAnimation implements Animation {
    int framesUntilNext;
    int framesPassedAfterSwitch;
    int index;
    int animationLength;

    public AbstractAnimation (int framesUntilNext) {
        this.framesUntilNext = framesUntilNext;
        this.framesPassedAfterSwitch = 0;
        this.index = 0;
    }

    @Override
    public void tick() {
        framesPassedAfterSwitch++;
        if(framesPassedAfterSwitch == framesUntilNext) {
            framesPassedAfterSwitch = 0;
            index++;
        }
        if(index == animationLength) {
            index = 0;
        }
        next();
    }

    abstract void next();
}
