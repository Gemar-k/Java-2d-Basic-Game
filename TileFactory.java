import models.*;
import constants.DisplayValues;
import handlers.FileHandler;

public class TileFactory{
    public static Tile createTile(String id, int x, int y){
        Tile tile;

        if(id.indexOf(":".charAt(0)) != -1){
            String[] portalId = id.split(":");
            
            switch(Integer.parseInt(portalId[0])){
                case 1: tile = new PortalTile(12, x, y, FileHandler.getImage("res/tiles/building/house/royal_house.png"), Integer.parseInt(portalId[1]));
                break;
                
                default: tile = new PortalTile(12, x, y, FileHandler.getAnimatedImage("res/tiles/portal.gif"), Integer.parseInt(portalId[1]));
            }
        }else{
            switch(Integer.parseInt(id)){
                case 1: tile = new Tile(1, x, y, FileHandler.getImage("res/tiles/grass.png"));
                break;
                
                case 2: tile = new LongGrassTile(2, x, y, FileHandler.getImage("res/tiles/high_grass.png"));
                break;
                
                case 3: tile = new WaterTile(3, x, y, FileHandler.getImage("res/tiles/water.png"));
                break;
                
                case 4: tile = new Tile(4, x, y, FileHandler.getImage("res/tiles/dirt_road.png"));
                break;
                
                case 5: tile = new EndTile(5, x, y, FileHandler.getAnimatedImage("res/tiles/bonfire_road.png"));
                break;
                
                default: tile = new Tile(404, x, y, FileHandler.getImage("res/tiles/test.png"));
            }
        }

        return tile;
    }
    
    public static Tile[][] createTiles(String[] tiles){
        int rowCount = DisplayValues.ROWCOUNT.getValue();
        int tileWidth = DisplayValues.TILEWIDTH.getValue();
        
        Tile[][] ties = new Tile[rowCount][rowCount];
        int x = 0;
        int y = 0;
        int testcounter = 0;
        for(int i = 0; i < rowCount; i++){
            for(int t =0; t < rowCount; t++){
                ties[i][t] = TileFactory.createTile(tiles[(i * rowCount) + t], x, y);
                x += tileWidth;
                testcounter++;
            }
            testcounter++;
            y += tileWidth;
            x = 0;
        }
        
        return ties;
    }
}