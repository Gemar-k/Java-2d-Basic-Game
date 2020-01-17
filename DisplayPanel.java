import models.*;
import java.util.ArrayList;
import handlers.FileHandler;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import javax.swing.*;

public abstract class DisplayPanel extends JPanel{
    
    public DisplayPanel(){
        //initiate stuff here
    }
    
    //draw the world to the screen
    @Override
    protected void paintComponent(Graphics graphics){
        //paint displaypanel
    }
    
    //update the displaypanel
    public void update(){
        this.repaint();
    }
}