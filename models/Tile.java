package models;
import interfaces.TileInterface;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Tile implements TileInterface{
    private int id;
    private Image image;
    
    private int x;
    private int y;

    public Tile(int id, int x, int y, Image image){
        this.id = id;
        this.image = image;
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }

    public int getId(){
        return this.id;
    }

    public void setImage(Image image){
        this.image = image;
    }

    public Image getImage(){
        return this.image;
    }

    public boolean isWalkable(){
        return true;
    }
    
    public boolean isEnd(){
        return false;
    }

    public int getWorldId(){
        return 0;
    }
    
    public void draw(Graphics graphics){
        graphics.drawImage(this.image, this.x, this.y, null);
    }
}