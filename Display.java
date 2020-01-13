import java.awt.event.*; 
import java.awt.*;
import constants.DisplayValues; 
import javax.swing.*; 

public class Display{
    private JFrame jframe;
    private String title;
    private int displayWidth;
    
    public Display(String title){
        this.displayWidth = DisplayValues.DISPLAYWIDTH.getValue();
        
        jframe = new JFrame(title);
        jframe.setSize(this.displayWidth, this.displayWidth);
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLayout(new GridLayout(1, 1));
    }
    
    public void addPanel(JPanel panel){
        jframe.add(panel);
    }
    
    public JFrame getJFrame(){
        return jframe;
    }
    
    public int getDisplayWidth(){
        return this.displayWidth;
    }
    
    public void DisplayVisible(boolean visibility){
        jframe.setVisible(visibility);
    }
}