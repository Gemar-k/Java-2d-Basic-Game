import models.*;
import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*;
import handlers.*;

public class Game{

    private Display display;
    
    private JPanel displayPanel;
    
    private KeyboardInput input;
    
    private GamePanel gamePanel;
    
    private FsmManager fsm;

    private boolean running;

    public Game(){
        this.init();
    }

    public void init(){
        this.running = true;

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

    public void run(){
        while(running){
                this.gamePanel.run();
            try{
                Thread.sleep(40);
            }catch(Exception e){
                System.out.println("Error while running the game " + e);
            }
        }
    }
}