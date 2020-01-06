package models;
import interfaces.TileInterface;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile implements TileInterface{
    private int id;
    private BufferedImage image;
    
    private int x;
    private int y;

    public Tile(int id, int x, int y, BufferedImage image){
        this.id = id;
        this.image = image;
        this.x = x;
        this.y = y;
    }

    public int getId(){
        return this.id;
    }

    public void setImage(BufferedImage image){
        this.image = image;
    }

    public BufferedImage getImage(){
        return this.image;
    }

    public boolean isWalkable(){
        return true;
    }

    public int getWorldId(){
        return 0;
    }
    
    public void draw(Graphics graphics){
        graphics.drawImage(this.image, this.x, this.y, null);
    }
}