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
        if(input.pressedKey[27]){
            this.fsm.setState(1);
            
            this.delay(400);
        }
        
        if(input.pressedKey[10]){
            switch(this.currentOption){
                case 0: this.fsm.setState(1);
                break;
                
                case 1: //dialog box open
                break;
                
                case 2: System.exit(0);
                break;
            }
        }
        
        if(input.pressedKey[40] && this.currentOption < this.options.length){
            this.currentOption++;
            this.delay(400);
        }
        
        if(input.pressedKey[38] && this.currentOption > 0){
            this.currentOption--;
            this.delay(400);
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
    
    
    public void delay(long time){
        try{
            Thread.sleep(time);
        }catch(Exception e){
            System.out.println("Time could not be slowed down!");
        }
    }
}