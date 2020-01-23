import java.awt.Graphics;
import constants.States;

/**
 * class FsmManager - for controlling game state
 * @author (Gemar Koning)
 * @version (2.0)
 */
public class FsmManager{
    
    private State[] states;
    
    private State currentState;
    
    /**
     * construct new fsm Object, construct new states and set the first current state
     */
    public FsmManager(){        
        this.states = new State[]{new MenuState(this), new GameState(this), new FinishedState(this)};
        
        this.currentState = this.states[States.MENU.getvalue()];
    }
    
    /**
     * sets the current state that is to be used
     * @param state  state enum that defines the new current state (like: States.MENU, States.GAME, etc)
     */
    public void setState(States state){
        this.currentState = this.states[state.getvalue()];
        this.currentState.onStateChange();
    }
    
    /**
     *  get the current set state
     */
    public State getState(){
        return this.currentState;
    }
    
    /**
     * draw the current state to the screen
     * @param graphics  graphics object that can be used to draw on the screen
     */
    public void draw(Graphics graphics){
        this.currentState.draw(graphics);
    }
    
    /**
     * catch user keyboard input and run the current state keyPressed method
     */
    public void keyPressed(KeyboardInput input){
        this.currentState.keyPressed(input);
    }
    
    /**
     * run the current state
     */
    public void run(){
        this.currentState.run();
    }
}