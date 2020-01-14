import models.*;
import java.util.ArrayList;
import handlers.FileHandler;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

public class GamePanel extends DisplayPanel{
    
    private World world;
    
    public GamePanel(World world){
        this.world = world;
    }
    
    @Override
    public void paintComponent(Graphics graphics){
        this.world.draw(graphics);
    }
    
    public void setWorld(World world){
        this.world = world;
    }
    
    public World getWorld(){
        return this.world;
    }
        
}