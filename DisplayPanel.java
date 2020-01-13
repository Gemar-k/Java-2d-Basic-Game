import models.*;
import java.util.ArrayList;
import handlers.FileHandler;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class DisplayPanel extends JPanel{
    //the currently visible world to the player
    private World currentWorld;
    
    //all the worlds
    private World[] worlds;
    
    //keyboard input to alter the current world
    private KeyboardInput input;
    
    //initiate displaypanel and properties
    public DisplayPanel(KeyboardInput input, World[] worlds){
        this.input = input;
        this.worlds = worlds;
        this.currentWorld = worlds[0];
    }
    
    //draw the world to the screen
    @Override
    public void paintComponent(Graphics graphics){
        this.currentWorld.draw(graphics);
    }
    
    //update the displaypanel
    public void update(){
        //get player from current world
        Player player = this.currentWorld.getPlayer();
        //if pressed update player position and image
        if(this.input.pressedKey[38]){
                if(this.currentWorld.getTile(player.getX(), player.getY() + -10).isWalkable()){
                    player.moveY(-10);
                    player.setImage(FileHandler.getImage("res/tiles/player/player_back.png"));
                }
                //System.out.println(this.world.getTile(player.getX(), player.getY()).getWorldId());
            }else if(this.input.pressedKey[39]){
                if(this.currentWorld.getTile(player.getX() + 10, player.getY()).isWalkable()){
                    player.moveX(10);
                    player.setImage(FileHandler.getImage("res/tiles/player/player_right.png"));
                }
            }else if(this.input.pressedKey[40]){
                if(this.currentWorld.getTile(player.getX(), player.getY() + 10).isWalkable()){
                    player.moveY(10);
                    player.setImage(FileHandler.getImage("res/tiles/player/player_front.png"));
                }    
            }else if(this.input.pressedKey[37]){
                if(this.currentWorld.getTile(player.getX() + -10, player.getY()).isWalkable()){
                    player.moveX(-10);
                    player.setImage(FileHandler.getImage("res/tiles/player/player_left.png"));
                }
            }
            
            if(this.input.pressedKey[70]){
                this.currentWorld.getBackgroundMusic().pause();
                int newWorld = this.currentWorld.getTile(player.getX(), player.getY()).getWorldId();
                System.out.println("World id: " + newWorld);
                
                try{
                    Thread.sleep(400);
                }catch(Exception e){
                    System.out.println("Just a test thread stop");
                }
                
                this.currentWorld = this.worlds[newWorld];
            }
            
            this.repaint();
    }
}