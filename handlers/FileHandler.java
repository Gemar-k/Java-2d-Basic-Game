package handlers;

import java.awt.image.BufferedImage;
import java.awt.image.*;
import java.io.*;
import java.net.URL;
import javax.imageio.*;

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