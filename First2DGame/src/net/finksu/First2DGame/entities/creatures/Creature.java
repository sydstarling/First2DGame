package net.finksu.First2DGame.entities.creatures;

import net.finksu.First2DGame.Handler;
import net.finksu.First2DGame.entities.Entity;
import net.finksu.First2DGame.tiles.Tile;

public abstract class Creature extends Entity {
    
    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 3.0F;
    public static final int DEFAULT_CREATURE_WIDTH = 64,
                            DEFAULT_CREATURE_HEIGHT= 64;
    
    protected int health;
    protected float speed;
    protected float xMove;
    protected float yMove;
    
    public Creature(Handler handler, float x, float y, int width, int height) {
        
        super(handler, x, y, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
        
    }
    
    public void move() {
        
        moveX();
        moveY();
        
    }
    
    public void moveX() {
        
        try{
        if(!Player.NoClip) {
        if(xMove > 0) { //Right
            
            int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
            if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) && !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT))
                x += xMove;
            else
                x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
            
        }else if(xMove < 0) { //Left
            
            int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
            if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) && !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT))
                x += xMove;
            else
                x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
            
        }
    }else
            x += xMove;
     
        }catch(Exception e) {
            
            e.printStackTrace();
            
        }
    }
    
    public void moveY() {
        
        try{
        if(!Player.NoClip) {
        if(yMove < 0) {//Up
            
            int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
            if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) && !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))
                y += yMove;
            else
                y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
            
        }else if(yMove > 0) {//Down
            
            int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
            if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) && !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))
                y += yMove;
            else
                y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
            
        }
        }else
            y += yMove;
        }catch(Exception e) {
            
            e.printStackTrace();
            
        }
        
        
    }
    
    protected boolean collisionWithTile(int x, int y) {
        
        try{
            
            return handler.getWorld().getTile(x, y).isSolid();
            
        }catch(NullPointerException e) {
            
            return true;
            
        }
        
    }
    
    //Getters and Setters for private variables

    public int getHealth() {
        return health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
    
}
