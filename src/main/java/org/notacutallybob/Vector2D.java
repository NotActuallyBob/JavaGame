package org.notacutallybob;

public class Vector2D {
    private int x;
    private int y;

    public Vector2D (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D (Vector2D vector2d) {
        this.x = vector2d.x;
        this.y = vector2d.y;
    }

    public void set(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void set(Vector2D position) {
        this.x = position.x;
        this.y = position.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(Vector2D vector2d) {
        this.x += vector2d.getX();
        this.y += vector2d.getY();
    }

    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public void moveX(int x) {
        this.x += x;
    }

    public void moveY(int y) {
        this.y += y;
    }

    public void move(String direction, int length) {
        switch (direction) {
            case "up":
                this.moveY(-length);
                break;
            case "down":
                this.moveY(length);
                break;
            case "left":
                this.moveX(-length);
                break;
            case "right":
                this.moveX(length);
                break;
            default:
                break;
        }
    }

    public static Vector2D zeroVector() {
        return new Vector2D(0, 0);
    }

    @Override
    public String toString() {
        return "x: " + x + ", y: " + y;
    }
}
