package org.notacutallybob;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

import org.notacutallybob.draw.DrawManager;
import org.notacutallybob.tile.TileManager;

public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 16;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;

    public final int maxScreenColumns = 16;
    public final int maxScreenRows = 12;
    public final int screenWidth = maxScreenColumns * tileSize;
    public final int screenHeigth = maxScreenRows * tileSize;
    public Vector2D windowMargin = new Vector2D(100, 50);

    public final int maxWorldColumns = 50;
    public final int maxWorldRows = 50;
    public final int worldWidth = maxWorldColumns * tileSize;
    public final int worldHeigth = maxWorldRows * tileSize;

    final int FPS = 60;

    TileManager tileManager = new TileManager(this);
    KeyHandler keyHandler = new KeyHandler();
    public Camera camera = new Camera(this, new Vector2D(0 * tileSize, 0 * tileSize), new Vector2D(screenWidth, screenHeigth));
    Thread gameThread;

    public Player player = new Player(this, keyHandler);

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth + windowMargin.getX() * 2, screenHeigth + windowMargin.getY() * 2));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);

        init();
    }

    public void init() {
        DrawManager.getInstance().changeCamera(camera);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override

    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount--;
            }
        }
    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        DrawManager.getInstance().draw(g2);

        g2.drawRect(windowMargin.getX(), windowMargin.getY(), screenWidth, screenHeigth);
        g2.dispose();
    }
}
