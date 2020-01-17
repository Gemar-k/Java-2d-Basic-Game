import models.*;
import handlers.*;
import java.awt.*;
import java.awt.Graphics; 

public class GameState extends State{

    private World[] worlds;
    
    private World currentWorld;

    private Player player;
    
    public GameState(FsmManager fsm){
        super(fsm);
    }

    @Override
    public void init(){
        this.player = new Player(1, "Gemar", FileHandler.getImage("res/tiles/player/player_right.png"), 100, 450);
        
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
        
        this.currentWorld = this.worlds[0];
        
    }    

    @Override
    public void run(){
        System.out.println("GameState Running!");
    }
    
    @Override
    public void draw(Graphics graphics){
        this.currentWorld.draw(graphics);
    }
    
    @Override
    public void keyPressed(KeyboardInput input){
        //get player from current world
        Player player = this.currentWorld.getPlayer();
        //if pressed update player position and image
        if(input.pressedKey[38]){
                if(this.currentWorld.getTile(player.getX(), player.getY() + -10).isWalkable()){
                    player.moveY(-10);
                    player.setImage(FileHandler.getImage("res/tiles/player/player_back.png"));
                }
                //System.out.println(this.world.getTile(player.getX(), player.getY()).getWorldId());
            }else if(input.pressedKey[39]){
                if(this.currentWorld.getTile(player.getX() + 10, player.getY()).isWalkable()){
                    player.moveX(10);
                    player.setImage(FileHandler.getImage("res/tiles/player/player_right.png"));
                }
            }else if(input.pressedKey[40]){
                if(this.currentWorld.getTile(player.getX(), player.getY() + 10).isWalkable()){
                    player.moveY(10);
                    player.setImage(FileHandler.getImage("res/tiles/player/player_front.png"));
                }    
            }else if(input.pressedKey[37]){
                if(this.currentWorld.getTile(player.getX() + -10, player.getY()).isWalkable()){
                    player.moveX(-10);
                    player.setImage(FileHandler.getImage("res/tiles/player/player_left.png"));
                }
            }
            
            if(input.pressedKey[70]){
                currentWorld.getBackgroundMusic().pause();
                int newWorld = currentWorld.getTile(player.getX(), player.getY()).getWorldId();
                System.out.println("World id: " + newWorld);
                
                try{
                    Thread.sleep(400);
                }catch(Exception e){
                    System.out.println("Just a test thread stop");
                }
                
                this.currentWorld = this.worlds[newWorld];
            }
            
            if(input.pressedKey[27]){
                this.fsm.setState(0);
                this.currentWorld.getBackgroundMusic().pause();
                
                try{
                    Thread.sleep(400);
                }catch(Exception e){
                    System.out.println("Just a test thread stop");
                }
            }
    }
}