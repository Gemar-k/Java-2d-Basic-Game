import models.*;
import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*;
import handlers.*;
import java.time.*;

/**
 *  class Game - the main class that houses the gameloop and initializes all game components
 *  @author (Gemar Koning)
 *  @version (2.0)
 */
public class Game{

    private Display display;
    
    private KeyboardInput input;
    
    private GamePanel gamePanel;
    
    private FsmManager fsm;

    private boolean running;
    
    private Instant timeStart;

    /**
     * construct game class and call init() method
     */
    public Game(){
        this.init();
    }

    /**
     * initialize all parameters and game components
     */
    public void init(){
        this.running = true;
        this.timeStart = Instant.now();

        this.display = new Display("ZuulTheGame");
        
        this.input = new KeyboardInput();
        this.fsm = new FsmManager();

        this.gamePanel = new GamePanel(this.fsm, this.input);
        this.gamePanel.setLayout(new GridLayout(3, 3));
                
        this.display.addPanel(this.gamePanel);
        this.display.getJFrame().addKeyListener(this.input);
        this.display.DisplayVisible(true);
        
        this.run();
    }

    /**
     * runs the game and houses the main loop
     */
    public void run(){
        int FRAMES_PER_SECOND = 23;
        int SKIP_TICKS = 1000 / FRAMES_PER_SECOND;
        
        long next_game_tick = this.elapsedTime();

        long sleeptime = 0;
        
        while(running){
            this.gamePanel.run();
            
            next_game_tick += SKIP_TICKS;
            sleeptime = next_game_tick - this.elapsedTime();

            if(sleeptime >= 0){
                System.out.print("Time for a delay! " + sleeptime);
                this.delay(sleeptime);
            }
        }
    }
    
    /**
     * checks how much time has elapsed since game started
     */
    public long elapsedTime(){
        Instant finish = Instant.now();
        
        return Duration.between(this.timeStart, finish).toMillis();
    }
    
    /**
     * delay the complete game
     * 
     * @param time  defines how much the game needs to wait in millis
     */
    public static void delay(long time){
        try{
            Thread.sleep(time);
        }catch(Exception e){
            System.out.println("Error while running the game " + e);
        }
    }
}