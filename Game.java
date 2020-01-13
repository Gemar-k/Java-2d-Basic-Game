import models.*;
import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*;
import handlers.*;

public class Game{

    private Display display;
    private DisplayPanel displayPanel;

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

        World[] worlds = {
                new World(TileFactory.createTiles(FileHandler.getFileContentAsString("res/worlds/plain_fields.txt").split(",")), 
                    this.player, new AudioHandler("res/audio/background/bk1.wav")),
                new World(TileFactory.createTiles(FileHandler.getFileContentAsString("res/worlds/plain_roads.txt").split(",")),
                    this.player, new AudioHandler("res/audio/background/bk4.wav")),
                new World(TileFactory.createTiles(FileHandler.getFileContentAsString("res/worlds/royal_city.txt").split(",")),
                    this.player, new AudioHandler("res/audio/background/bk2.wav")),
                new World(TileFactory.createTiles(FileHandler.getFileContentAsString("res/worlds/beach.txt").split(",")),
                    this.player, new AudioHandler("res/audio/background/bk3.wav"))
            };

        this.displayPanel = new DisplayPanel(input, worlds);

        this.displayPanel.setLayout(new GridLayout(3, 3));

        this.display.addPanel(this.displayPanel);
        this.display.getJFrame().addKeyListener(input);
        this.display.DisplayVisible(true);

        this.run();
    }

    public void run(){
        while(running){
            this.displayPanel.update();
            try{
                Thread.sleep(40);
            }catch(Exception e){
                System.out.println("Error while running the game " + e);
            }
        }
    }
}