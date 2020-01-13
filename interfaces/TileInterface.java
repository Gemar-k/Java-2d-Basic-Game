package interfaces;
import models.World;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public interface TileInterface
{
   //image of the tile
   public Image getImage();
   
   //setting the image
   public void setImage(Image image);
   
   //get id of the tile
   public int getId();
   
   //check if tile can be walked
   public boolean isWalkable();
   
   //get new world from tile if possible
   public int getWorldId();
   
   //draw new tile
   public void draw(Graphics graphics);
}
