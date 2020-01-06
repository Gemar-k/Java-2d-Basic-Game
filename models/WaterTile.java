package models;
import java.awt.image.BufferedImage;

public class WaterTile extends Tile{
    public WaterTile(int id, int x, int y, BufferedImage image){
        super(id, x, y, image);
    }
    
    @Override
    public boolean isWalkable(){
        return false;
    }
}