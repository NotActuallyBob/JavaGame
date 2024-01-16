package org.notacutallybob.draw;

public enum Layer {
    Tile(0), Player(1);

    private final int value;

    Layer(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
