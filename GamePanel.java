import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*;

public class GamePanel extends DisplayPanel{
    private FsmManager fsm;
    
    private KeyboardInput input;
    
    public GamePanel(FsmManager fsm, KeyboardInput input){
        this.fsm = fsm;
        this.input = input;
    }
    
    @Override
    protected void paintComponent(Graphics graphics){
        this.fsm.draw(graphics);
    }
    
    protected void keyPressed(KeyboardInput input){
        this.fsm.keyPressed(input);
    }
    
    protected void move(){
        this.fsm.run();
    }
    
    public void run(){
        this.keyPressed(this.input);
        this.move();
        this.repaint();
    }
    
}