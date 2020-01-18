import java.awt.Graphics;
import constants.States;

public class FsmManager{
    
    private State[] states;
    
    private State currentState;
    
    public FsmManager(){        
        this.states = new State[]{new MenuState(this), new GameState(this), new FinishedState(this)};
        
        this.currentState = this.states[States.MENU.getvalue()];
    }
    
    public void setState(States state){
        this.currentState = this.states[state.getvalue()];
        this.currentState.onStateChange();
    }
    
    public State getState(){
        return this.currentState;
    }
    
    public void draw(Graphics graphics){
        this.currentState.draw(graphics);
    }
    
    public void keyPressed(KeyboardInput input){
        this.currentState.keyPressed(input);
    }
    
    public void run(){
        this.currentState.run();
    }
}