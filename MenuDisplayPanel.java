import models.*;
import java.util.ArrayList;
import handlers.FileHandler;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class MenuDisplayPanel extends JPanel{
    
    
    public MenuDisplayPanel(){
        
    }
    
    @Override
    public void paintComponent(Graphics graphics){
        graphics.drawString("Test", 100, 100);
    }
}