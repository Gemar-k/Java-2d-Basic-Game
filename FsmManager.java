import java.awt.Graphics;

public class FsmManager{
    
    private State[] states;
    
    private State currentState;
    
    public FsmManager(){        
        this.states = new State[]{new MenuState(this), new GameState(this), new FinishedState(this)};
        
        this.currentState = this.states[0];
    }
    
    public void setState(int state){
        this.currentState = this.states[state];
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