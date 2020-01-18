package models;

import java.awt.Image;

public class EndTile extends Tile{
    public EndTile(int id, int x, int y, Image image){
        super(id, x, y, image);
    }
    
    @Override
    public boolean isEnd(){
        return true;
    }
}