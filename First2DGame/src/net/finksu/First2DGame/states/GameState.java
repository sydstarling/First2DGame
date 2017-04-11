package net.finksu.First2DGame.states;

import java.awt.Color;
import java.awt.Graphics;
import net.finksu.First2DGame.Game;
import net.finksu.First2DGame.Handler;
import net.finksu.First2DGame.entities.creatures.Player;
import net.finksu.First2DGame.worlds.World;

public class GameState extends State {
    
    public static int lastTicks = Game.fps;
    private World world;
    
    private int tiles1, tiles2;
    
    private Player player;
    
    public GameState(Handler handler, String path, int tiles1, int tiles2) {
        
        super(handler);
        this.tiles1 = tiles1;
        this.tiles2 = tiles2;
        world = new World(handler, path, this.tiles1, this.tiles2);
        handler.setWorld(world);
        player = new Player(handler, 50, 50);
        
    }
    
    @Override
    public void tick() {
        
        world.tick();
        player.tick();
        
    }

    @Override
    public void render(Graphics g) {
        
        world.render(g);
        player.render(g);
        //Show FPS
        g.setColor(Color.RED);
        g.drawString("FPS: " + ticks(), 10, 15);
        if(Player.NoClip)
            g.drawString("NoClip", 10, 30);
        g.setColor(Color.WHITE);
        
    }
    
    public int ticks() {
        
        if(Game.timer >= 1000000000)
            lastTicks = Game.ticks + 1;
        return lastTicks;
        
    }
    
    
    
}
