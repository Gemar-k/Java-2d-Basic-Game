import java.awt.*;
import constants.*;

public class FinishedState extends State{
    private Font font;
    
    public FinishedState(FsmManager fsm){
        super(fsm);
    }
    
    @Override
    public void init(){
        this.font = new Font(Font.MONOSPACED, Font.BOLD, 50);
    }
    
    @Override
    public void draw(Graphics graphics){
        int width = DisplayValues.DISPLAYWIDTH.getValue();
        int height = DisplayValues.DISPLAYHEIGHT.getValue();
        
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, width, height);
        
        graphics.setColor(Color.WHITE);
        graphics.setFont(this.font);
        graphics.drawString("YOU HAVE WON THE GAME!", 50, height / 2);
    }
    
    @Override
    public void keyPressed(KeyboardInput input){
        if(input.getKey(Keys.ENTER) || input.getKey(Keys.ESC)){
            System.exit(0);
        }
    }
}