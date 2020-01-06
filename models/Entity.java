package models;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Entity{
    protected int id;
    protected String name;
    protected BufferedImage image;
    
    protected int x;
    protected int y;
    
    public void moveX(int x){
        this.x += x;
    }
    
    public void moveY(int y){
        this.y += y;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public void setImage(BufferedImage image){
        this.image = image;
    }
    
    public void draw(Graphics graphics){
        graphics.drawImage(this.image, this.x, this.y, null);
    }
}