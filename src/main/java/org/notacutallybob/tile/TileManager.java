package org.notacutallybob.tile;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.notacutallybob.GamePanel;

public class TileManager {
    GamePanel gamePanel;
    Tile[] tiles;

    public TileManager (GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        tiles = new Tile[10];
        getTileImage();
    }

    public void getTileImage() {
        try {
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));

            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));

            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        for (int column = 0; column < gamePanel.maxScreenColumns; column++) {
            for (int row = 0; row < gamePanel.maxScreenRows; row++) {
                int x = gamePanel.tileSize * column;
                int y = gamePanel.tileSize * row;
                g2.drawImage(tiles[0].image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
            }
        }
    }
}
