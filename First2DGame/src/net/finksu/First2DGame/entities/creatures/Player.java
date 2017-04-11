package net.finksu.First2DGame.entities.creatures;

import java.awt.Graphics;
import net.finksu.First2DGame.Handler;
import net.finksu.First2DGame.gfx.Assets;
import net.finksu.First2DGame.tiles.Tile;

public class Player extends Creature {
    
    public static boolean NoClip = false;
    
    private int gravity = -1;
    private int velocity = 0;
    
    public Player(Handler handler, float x, float y) {
        
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        
        bounds.x = 16;
        bounds.y = 25;
        bounds.width = 31;
        bounds.height = 38;
        
    }
    
    public boolean isPlayerTouching() {
        
        try{
        if(isPlayerTouching(1))
            return true;
        if(isPlayerTouching(2))
            return true;
        if(isPlayerTouching(3))
            return true;
        return isPlayerTouching(4);
        }catch(Exception e) {
            
            e.printStackTrace();
            
        }
        return false;
        
    }
    
    public boolean isPlayerTouching(int i) {
        
        try{
        if(i == 2) {
            
            int tx = (int) (x + 1 + bounds.x + bounds.width) / Tile.TILEWIDTH;
            if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) && !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT))
                return false;
            
        }
        
        if(i == 4) {
            
            int tx = (int) (x + -1 + bounds.x) / Tile.TILEWIDTH;
            if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) && !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT))
                return false;
            
        }
        
        if(i == 1) {
            
            int ty = (int) (y + -1 + bounds.y) / Tile.TILEHEIGHT;
            if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) && !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))
                return false;
            
        }
        
        if(i == 3) {
            
            int ty = (int) (y + 1 + bounds.y + bounds.height) / Tile.TILEHEIGHT;
            if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) && !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))
                return false;
            
        }
        }catch(Exception e) {
            
            e.printStackTrace();
            
        }
        
        return true;
        
    }

    @Override
    public void tick() {
        
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
        
    }
    
    private void getInput() {
        
        try{
        xMove = 0;
        yMove = 0;
        
        if(handler.getKeyManager().up1)
            yMove = -speed;
        if(handler.getKeyManager().left1)
            xMove = -speed;
        if(handler.getKeyManager().down1)
            yMove = speed;
        if(handler.getKeyManager().right1)
            xMove = speed;
        if(handler.getKeyManager().up)
            yMove = -speed;
        if(handler.getKeyManager().left)
            xMove = -speed;
        if(handler.getKeyManager().down)
            yMove = speed;
        if(handler.getKeyManager().right)
            xMove = speed;
        NoClip = handler.getKeyManager().O;
        }catch(Exception e) {
            
            e.printStackTrace();
            
        }
        
    }

    @Override
    public void render(Graphics g) {
        
        g.drawImage(Assets.player, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        
    }
    
    
    
}
