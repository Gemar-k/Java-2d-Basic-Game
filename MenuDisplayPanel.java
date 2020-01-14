import java.awt.Graphics;

public class MenuDisplayPanel extends DisplayPanel{
    
    
    public MenuDisplayPanel(){
        
    }
    
    @Override
    public void paintComponent(Graphics graphics){
        graphics.drawString("Test", 100, 100);
    }
}