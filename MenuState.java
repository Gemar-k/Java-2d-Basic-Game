import java.awt.*;
import handlers.*;
import constants.*;

public class MenuState extends State{
    
    private String[] options;
    private int currentOption;
    private Font font;
    
    public MenuState(FsmManager fsm){
        super(fsm);
    }
    
    @Override
    public void init(){
        this.options = new String[]{"Resume", "About", "Quit"};
        this.currentOption = 0;
        
        this.font = new Font(Font.MONOSPACED, Font.BOLD, 50);
    }
    
    @Override
    public void run(){
        System.out.println("Menu is running");        
    }
    
    @Override
    public void keyPressed(KeyboardInput input){
        if(input.getKey(Keys.ESC)){
            this.fsm.setState(States.GAME);
            
            Game.delay(400);
        }
        
        if(input.getKey(Keys.ENTER)){
            switch(this.currentOption){
                case 0: this.fsm.setState(States.GAME);
                break;
                
                case 1: //dialog box open
                break;
                
                case 2: System.exit(0);
                break;
            }
        }
        
        if(input.getKey(Keys.DOWN) && this.currentOption < this.options.length){
            this.currentOption++;
            Game.delay(400);
        }
        
        if(input.getKey(Keys.UP) && this.currentOption > 0){
            this.currentOption--;
            Game.delay(400);
        }
    }
    
    @Override
    public void draw(Graphics graphics){
        int width = DisplayValues.DISPLAYWIDTH.getValue();
        int height = DisplayValues.DISPLAYHEIGHT.getValue();
        
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, width, height);
        
        graphics.setFont(this.font);
        
        int rowHeight = 0;
        for(int i = 0; i < this.options.length; i++){
            graphics.setColor(Color.WHITE);
            if(i == this.currentOption){
                graphics.setColor(Color.BLUE);
            }
            graphics.drawString(this.options[i], DisplayValues.DISPLAYWIDTH.getValue() / 2 - 60, rowHeight += 120);
        }
    }
    
}