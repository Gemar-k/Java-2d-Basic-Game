import java.awt.Graphics;
/**
 * class State - defines the basic structure of a state in the game (Cannot be initialised only extended)
 * @author (Gemar Koning)
 * @version (2.2)
 */
public abstract class State{
    
    protected FsmManager fsm;
    
    /**
     * constructs State 
     * @param fsm  the FsmManager object
     */
    public State(FsmManager fsm){
        this.fsm = fsm;
        this.init();
    }
    
    /**
     * is called in constructor and runs only once, when FsmManager object is created
     */
    public void init(){
        //stuff that needs to be initated bofore running the state
    }
    
    /**
     * runs only once, when state is the new current state
     */
    public void onStateChange(){
        //runs when state is the new current state
    }
    
    /**
     * runs continuously in GamePanel is used to draw graphics to the screen
     * @param graphics  graphics object that can be used to draw to the screen
     */
    public void draw(Graphics graphics){
        //draw graphics to the current screen
    }
    
    /**
     *  runs continuously in GamePanel is used to catch user keyboard input
     *  @param input  KeyboardInput object that can be used to catch user keyboard input
     */
    public void keyPressed(KeyboardInput input){
        //for getting input attributes
    }
    
    /**
     * runs continuously in GamePanel is used to run code in background (like: enemies, actors, etc)
     */
    public void run(){
        //run stuff here when State is selected
    }
}