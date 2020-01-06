package models;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
public class Player extends Entity{
    private ArrayList<String> inventory;
    
    public Player(int id, String name, BufferedImage image, int x, int y){
        this.id = id;
        this.name = name;
        this.image = image;
        this.x = x;
        this.y = y;
        
        this.inventory = new ArrayList<String>();
    }
    
    public void addItem(String item){
        this.inventory.add(item);
    }
}