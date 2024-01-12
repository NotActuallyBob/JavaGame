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
    public Tile[] tileTypes;
    public int mapTileNum[][];

    public TileManager (GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        
        tileTypes = new Tile[10];
        mapTileNum = new int[gamePanel.maxWorldColumns][gamePanel.maxWorldRows];
        loadMap("/maps/map01.txt");

        getTileImage();
    }

    public void loadMap(String path) {
        try {
            InputStream is = getClass().getResourceAsStream(path);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

            for (int row = 0; row < gamePanel.maxWorldRows; row++) {
                String line = bufferedReader.readLine();

                String[] split = line.split(" ");
                for (int column = 0; column < gamePanel.maxWorldColumns; column++) {
                    mapTileNum[column][row] = Integer.parseInt(split[column]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getTileImage() {
        try {
            tileTypes[0] = new Tile();
            tileTypes[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));

            tileTypes[1] = new Tile();
            tileTypes[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
            tileTypes[1].collision = true;

            tileTypes[2] = new Tile();
            tileTypes[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
            tileTypes[2].collision = true;

            tileTypes[3] = new Tile();
            tileTypes[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));

            tileTypes[4] = new Tile();
            tileTypes[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
            tileTypes[4].collision = true;

            tileTypes[5] = new Tile();
            tileTypes[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        for (int worldColumn = 0; worldColumn < gamePanel.maxWorldColumns; worldColumn++) {
            for (int worldRow = 0; worldRow < gamePanel.maxWorldRows; worldRow++) {
                int worldX = gamePanel.tileSize * worldColumn;
                int worldY = gamePanel.tileSize * worldRow;

                int screenX = worldX - gamePanel.player.worldPosition.getX() + gamePanel.player.screenPosition.getX();
                int screenY = worldY - gamePanel.player.worldPosition.getY() + gamePanel.player.screenPosition.getY();

                if(worldX > gamePanel.player.worldPosition.getX() + gamePanel.player.screenPosition.getX() + gamePanel.tileSize || 
                    worldX < gamePanel.player.worldPosition.getX() - gamePanel.player.screenPosition.getX() - gamePanel.tileSize  ||
                    worldY > gamePanel.player.worldPosition.getY() + gamePanel.player.screenPosition.getY() + gamePanel.tileSize  ||
                    worldY < gamePanel.player.worldPosition.getY() - gamePanel.player.screenPosition.getY() - gamePanel.tileSize ) {
                    continue;
                }

                int tileType = mapTileNum[worldColumn][worldRow];
                g2.drawImage(tileTypes[tileType].image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
            }
        }
    }
}
