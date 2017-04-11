package net.finksu.First2DGame.gfx;

import net.finksu.First2DGame.Handler;
import net.finksu.First2DGame.entities.Entity;
import net.finksu.First2DGame.tiles.Tile;

public class GameCamera {
    
    private float xOffset;
    private float yOffset;
    private Handler handler;
    
    public GameCamera(Handler handler, float xOffset, float yOffset) {
        
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.handler = handler;
        
    }
    
    public void checkBlankSpace() {
        
        try{
        if(xOffset < 0)
            xOffset = 0;
        else if(xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth())
            xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
        
        if(yOffset < 0)
            yOffset = 0;
        else if(yOffset > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight())
            yOffset = handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight();
        }catch(Exception ex) {
            
            ex.printStackTrace();
            
        }
        
    }
    
    public void move(float xAmt, float yAmt) {
        
        xOffset += xAmt;
        yOffset += yAmt;
        checkBlankSpace();
        
    }
    
    public void centerOnEntity(Entity e) {
        
        try{
        xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth();
        yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight();
        checkBlankSpace();
        }catch(Exception d) {
            
            d.printStackTrace();
            
        }
        
    }

    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
    
}
