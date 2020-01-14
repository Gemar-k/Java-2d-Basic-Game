import models.*;
import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*;
import handlers.*;

public class Game{

    private Display display;
    private GamePanel displayPanel;
    
    private World[] worlds;

    private KeyboardInput input;

    private Player player;

    private boolean running;

    public Game(){
        this.init();
    }

    public void init(){
        this.running = true;

        this.display = new Display("ZuulTheGame");
        this.player = new Player(1, "Gemar", FileHandler.getImage("res/tiles/player/player_right.png"), 100, 450);
        this.input = new KeyboardInput();
        
        this.worlds = new World[]{
                new World(TileFactory.createTiles(FileHandler.getFileContentAsString("res/worlds/plain_fields.txt").split(",")), 
                    this.player, new AudioHandler("res/audio/background/bk1.wav")),
                new World(TileFactory.createTiles(FileHandler.getFileContentAsString("res/worlds/plain_roads.txt").split(",")),
                    this.player, new AudioHandler("res/audio/background/bk4.wav")),
                new World(TileFactory.createTiles(FileHandler.getFileContentAsString("res/worlds/royal_city.txt").split(",")),
                    this.player, new AudioHandler("res/audio/background/bk2.wav")),
                new World(TileFactory.createTiles(FileHandler.getFileContentAsString("res/worlds/beach.txt").split(",")),
                    this.player, new AudioHandler("res/audio/background/bk3.wav"))
            }; 
            
        this.displayPanel = new GamePanel(worlds[0]);

        this.displayPanel.setLayout(new GridLayout(3, 3));

        this.display.addPanel(this.displayPanel);
        this.display.getJFrame().addKeyListener(input);
        this.display.DisplayVisible(true);

        this.run();
    }

    public void run(){
        while(running){
            this.update();
            try{
                Thread.sleep(40);
            }catch(Exception e){
                System.out.println("Error while running the game " + e);
            }
        }
    }
    
    public void update(){
        World currentWorld = this.displayPanel.getWorld();
        //get player from current world
        Player player = currentWorld.getPlayer();
        //if pressed update player position and image
        if(this.input.pressedKey[38]){
                if(currentWorld.getTile(player.getX(), player.getY() + -10).isWalkable()){
                    player.moveY(-10);
                    player.setImage(FileHandler.getImage("res/tiles/player/player_back.png"));
                }
                //System.out.println(this.world.getTile(player.getX(), player.getY()).getWorldId());
            }else if(this.input.pressedKey[39]){
                if(currentWorld.getTile(player.getX() + 10, player.getY()).isWalkable()){
                    player.moveX(10);
                    player.setImage(FileHandler.getImage("res/tiles/player/player_right.png"));
                }
            }else if(this.input.pressedKey[40]){
                if(currentWorld.getTile(player.getX(), player.getY() + 10).isWalkable()){
                    player.moveY(10);
                    player.setImage(FileHandler.getImage("res/tiles/player/player_front.png"));
                }    
            }else if(this.input.pressedKey[37]){
                if(currentWorld.getTile(player.getX() + -10, player.getY()).isWalkable()){
                    player.moveX(-10);
                    player.setImage(FileHandler.getImage("res/tiles/player/player_left.png"));
                }
            }
            
            if(this.input.pressedKey[70]){
                currentWorld.getBackgroundMusic().pause();
                int newWorld = currentWorld.getTile(player.getX(), player.getY()).getWorldId();
                System.out.println("World id: " + newWorld);
                
                try{
                    Thread.sleep(400);
                }catch(Exception e){
                    System.out.println("Just a test thread stop");
                }
                
                this.displayPanel.setWorld(this.worlds[newWorld]);
            }
            
            this.displayPanel.update();
    }
}