package handlers;

import java.awt.image.BufferedImage;
import java.awt.image.*;
import java.awt.Image;
import java.io.*;
import java.net.URL;
import javax.imageio.*;
import javax.swing.ImageIcon;

public class FileHandler{

    public static BufferedImage getImage(String src){
        BufferedImage image = null;

        try {
            image = ImageIO.read(new File(src));
        } catch (IOException e) {
            System.out.println("Error with getting image: " + e);
        }

        return image;
    }
    
    public static Image getAnimatedImage(String src){
        Image image = null;
        
        try{
            image = new ImageIcon(src).getImage();
        }catch(Exception e){
            System.out.println("Error with getting animated image: " + e);
        }
        
        return image;
    }

    public static String getFileContentAsString(String src){
        String test = "";

        try {
            String currentline;
            BufferedReader reader = new BufferedReader(new FileReader(src));
            while((currentline = reader.readLine()) != null){
                test += currentline;
            };
        }catch(Exception e){
            System.out.println("Error with getting world: " + e);
        }

        return test;
    }
}