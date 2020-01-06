package models;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PortalTile extends Tile{
    
    private int world;
    
    public PortalTile(int id, int x, int y, BufferedImage image, int worldId){
        super(id, x, y, image);
        this.world = worldId;
    }
    
    @Override
    public int getWorldId(){
        return this.world;
    }
}