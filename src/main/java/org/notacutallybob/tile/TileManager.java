package org.notacutallybob.tile;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.notacutallybob.GamePanel;
import org.notacutallybob.Vector2D;
import org.notacutallybob.draw.Layer;
import org.notacutallybob.draw.sprite.BoxSprite;

public class TileManager {
    GamePanel gamePanel;
    public Tile[][] tiles;
    public Vector2D tileDrawSize;

    public TileManager (GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        tileDrawSize = new Vector2D(gamePanel.tileSize, gamePanel.tileSize);

        tiles = new Tile[gamePanel.maxWorldColumns][gamePanel.maxWorldRows];
        loadMap("/maps/map01.txt");
    }

    public void loadMap(String path) {
        try {
            InputStream is = getClass().getResourceAsStream(path);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

            for (int row = 0; row < gamePanel.maxWorldRows; row++) {
                String line = bufferedReader.readLine();

                String[] split = line.split(" ");
                for (int column = 0; column < gamePanel.maxWorldColumns; column++) {
                    Vector2D tileWorldPosition = new Vector2D(gamePanel.tileSize * column, gamePanel.tileSize * row);
                    Vector2D tileSize = new Vector2D(gamePanel.tileSize, gamePanel.tileSize);
                    BoxSprite sprite = new BoxSprite(tileWorldPosition, tileSize, Vector2D.zeroVector(), Layer.Tile, Color.GREEN);
                    tiles[column][row] = new Tile(tileWorldPosition, sprite);
                    //mapTileNum[column][row] = Integer.parseInt(split[column]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
