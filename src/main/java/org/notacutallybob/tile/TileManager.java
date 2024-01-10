package org.notacutallybob.tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import org.notacutallybob.GamePanel;

public class TileManager {
    GamePanel gamePanel;
    Tile[] tiles;
    int mapTileNum[][];

    public TileManager (GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        
        tiles = new Tile[10];
        mapTileNum = new int[gamePanel.maxScreenColumns][gamePanel.maxScreenRows];
        loadMap("/maps/map01.txt");

        getTileImage();
    }

    public void loadMap(String path) {
        try {
            InputStream is = getClass().getResourceAsStream(path);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

            for (int row = 0; row < gamePanel.maxScreenRows; row++) {
                String line = bufferedReader.readLine();

                String[] split = line.split(" ");
                for (int column = 0; column < gamePanel.maxScreenColumns; column++) {
                    mapTileNum[column][row] = Integer.parseInt(split[column]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getTileImage() {
        try {
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));

            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));

            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));

            tiles[3] = new Tile();
            tiles[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));

            tiles[4] = new Tile();
            tiles[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));

            tiles[5] = new Tile();
            tiles[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        for (int column = 0; column < gamePanel.maxScreenColumns; column++) {
            for (int row = 0; row < gamePanel.maxScreenRows; row++) {
                int x = gamePanel.tileSize * column;
                int y = gamePanel.tileSize * row;

                int tileType = mapTileNum[column][row];
                g2.drawImage(tiles[tileType].image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
            }
        }
    }
}
