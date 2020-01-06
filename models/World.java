package models;

import handlers.AudioHandler;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

public class World{
    
    private Player player;
    
    private Tile[][] tiles;
    
    private AudioHandler backgroundMusic;
    
    public World(Tile[][] tiles, Player player, AudioHandler audio){
        this.player = player;
        this.tiles = tiles;
        
        this.backgroundMusic = audio;
    }
    
    public Player getPlayer(){
        return this.player;
    }
 
    public Tile getTile(int x, int y){
        //formula to calculate the position of the tile with x and y
        int hor = (int) Math.round((float) x / 64.00);
        int ver = (int) Math.round((float) y / 64.00);
        
        System.out.println("hor:" + hor + " ver: " + ver);
        return this.tiles[ver][hor];
    }
    
    public void draw(Graphics graphics){
        if(!this.backgroundMusic.isPlaying()){
            this.backgroundMusic.play();
            this.backgroundMusic.loop();
        }
        
        for(Tile[] tile : tiles){
            for(Tile til : tile){
                til.draw(graphics);
            }
        }
        
        player.draw(graphics);
    }
 
}