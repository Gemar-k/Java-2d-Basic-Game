package models;
import java.awt.Graphics;
import java.awt.Image;

public class PortalTile extends Tile{
    
    private int world;
    
    public PortalTile(int id, int x, int y, Image image, int worldId){
        super(id, x, y, image);
        this.world = worldId;
    }
    
    @Override
    public Integer getWorldId(){
        return this.world;
    }
}