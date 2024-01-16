package org.notacutallybob.tile;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.notacutallybob.GamePanel;
import org.notacutallybob.Vector2D;
import org.notacutallybob.draw.Layer;
import org.notacutallybob.draw.sprite.BoxSprite;
import org.notacutallybob.draw.sprite.ImageSprite;

public class TileManager {
    GamePanel gamePanel;
    Map<Integer, String> typeToPathMap;
    public Tile[][] tiles;
    public Vector2D tileDrawSize;

    public TileManager (GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        tileDrawSize = new Vector2D(gamePanel.tileSize, gamePanel.tileSize);

        tiles = new Tile[gamePanel.maxWorldColumns][gamePanel.maxWorldRows];
        typeToPathMap = new HashMap<>();
        typeToPathMap.put(0, "/tiles/grass.png");
        typeToPathMap.put(1, "/tiles/wall.png");
        typeToPathMap.put(2, "/tiles/water.png");
        typeToPathMap.put(3, "/tiles/earth.png");
        typeToPathMap.put(4, "/tiles/tree.png");
        typeToPathMap.put(5, "/tiles/sand.png");
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
                    int tileType = Integer.parseInt(split[column]);
                    ImageSprite sprite = new ImageSprite(tileWorldPosition, tileSize, Vector2D.zeroVector(), Layer.Tile, typeToPathMap.get(tileType));
                    tiles[column][row] = new Tile(tileWorldPosition, sprite);
                    //mapTileNum[column][row] = );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
