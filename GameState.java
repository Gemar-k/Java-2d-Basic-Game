import models.*;
import handlers.*;
import constants.*;
import java.awt.*;
import java.awt.Graphics; 

/**
 * class GameState - Extends state and defines the game state of the game
 * @author (Gemar Koning)
 * @version (2.0)
 */
public class GameState extends State{

    private World[] worlds;
    
    private World currentWorld;

    private Player player;
    
    /**
     * constructs GameState object
     * @param fsm  the FsmManager object
     */
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
        if(input.getKey(Keys.UP)){
                if(this.currentWorld.getTile(player.getX(), player.getY() + -10).isWalkable()){
                    player.moveY(-10);
                    player.setImage(FileHandler.getImage("res/tiles/player/player_back.png"));
                }
                //System.out.println(this.world.getTile(player.getX(), player.getY()).getWorldId());
            }else if(input.getKey(Keys.RIGHT)){
                if(this.currentWorld.getTile(player.getX() + 10, player.getY()).isWalkable()){
                    player.moveX(10);
                    player.setImage(FileHandler.getImage("res/tiles/player/player_right.png"));
                }
            }else if(input.getKey(Keys.DOWN)){
                if(this.currentWorld.getTile(player.getX(), player.getY() + 10).isWalkable()){
                    player.moveY(10);
                    player.setImage(FileHandler.getImage("res/tiles/player/player_front.png"));
                }    
            }else if(input.getKey(Keys.LEFT)){
                if(this.currentWorld.getTile(player.getX() + -10, player.getY()).isWalkable()){
                    player.moveX(-10);
                    player.setImage(FileHandler.getImage("res/tiles/player/player_left.png"));
                }
            }
            
            if(this.currentWorld.getTile(player.getX(), player.getY()).isEnd()){
                this.currentWorld.getBackgroundMusic().stop();
                this.fsm.setState(States.FINISHED);
            }
            
            if(input.getKey(Keys.F)){
                Integer newWorld = this.currentWorld.getTile(player.getX(), player.getY()).getWorldId();
                
                
                if(newWorld != null){
                    Game.delay(400);
                    currentWorld.getBackgroundMusic().pause();
                    this.currentWorld = this.worlds[newWorld];
                }
            }
            
            if(input.getKey(Keys.ESC)){
                this.fsm.setState(States.MENU);
                this.currentWorld.getBackgroundMusic().pause();
                
                Game.delay(400);
            }
    }
}