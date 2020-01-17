import java.awt.Graphics;

public abstract class State{
    
    protected FsmManager fsm;
    
    public State(FsmManager fsm){
        this.fsm = fsm;
        this.init();
    }
    
    public void init(){
        //stuff that needs to be initated bofore running the state
    }
    
    public void onStateChange(){
        //runs when state is the new current state
    }
    
    public void draw(Graphics graphics){
        //draw graphics to the current screen
    }
    
    public void keyPressed(KeyboardInput input){
        //for getting input attributes
    }
    
    public void run(){
        //run stuff here when State is selected
    }
}