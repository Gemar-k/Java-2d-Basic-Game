import models.*;
import handlers.FileHandler;

public class TileFactory{
    public static Tile createTile(String id, int x, int y){
        Tile tile;

        if(id.indexOf(":".charAt(0)) != -1){
            String[] test = id.split(":");
            
            tile = new PortalTile(12, x, y, FileHandler.getImage("res/tiles/building/house/royal_house.png"), Integer.parseInt(test[1]));
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

                default: tile = new Tile(404, x, y, FileHandler.getImage("res/tiles/test.png"));
            }
        }

        return tile;
    }
    
    public static Tile[][] createTiles(String[] tiles){
        Tile[][] ties = new Tile[12][12];
        int x = 0;
        int y = 0;
        int testcounter = 0;
        for(int i = 0; i < 12; i++){
            for(int t =0; t < 12; t++){
                ties[i][t] = TileFactory.createTile(tiles[(i * 12) + t], x, y);
                x += 64;
                testcounter++;
            }
            testcounter++;
            y += 64;
            x = 0;
        }
        
        return ties;
    }
}