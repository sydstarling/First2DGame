package net.finksu.First2DGame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import net.finksu.First2DGame.Display.Display;
import net.finksu.First2DGame.gfx.Assets;
import net.finksu.First2DGame.gfx.GameCamera;
import net.finksu.First2DGame.input.KeyManager;
import net.finksu.First2DGame.states.GameState;
import net.finksu.First2DGame.states.State;
import net.finksu.First2DGame.worlds.World;

public class Game implements Runnable {
    
    private Display display;
    
    private boolean running = false;
    
    private BufferStrategy bs;
    private Graphics g;
    
    private Thread thread;
    
    private int width = 800, height = 480;
    public String title;
    private int tiles1, tiles2;
    
    private String path;
    
    public static int ticks = 0;
    public static int fps = 60;
    public static long timer = 0;
    
    private State gameState;
    
    private KeyManager keyManager;
    
    private GameCamera gameCamera;
    
    private Handler handler;
    
    public Game(String title, int width, int height, String path, int tiles1, int tiles2) {
        
        try{
        if(tiles1 == 0 || tiles2 == 0)
            path = "worlds/world1.level";
        
        this.title = title;
        this.width = width;
        this.height = height;
        this.path = path;
        this.tiles1 = tiles1;
        this.tiles2 = tiles2;
        keyManager = new KeyManager();
        }catch(Exception e) {
            
            e.printStackTrace();
            
        }
        
    }
    
    private void init() {
        
        try{
        display = new Display(title, width, height);
        Assets.init();
        handler = new Handler(this);
        gameCamera = new GameCamera(handler, 0, 0);
        gameState = new GameState(handler, path, this.tiles1, this.tiles2);
        State.setState(gameState);
        display.getFrame().addKeyListener(keyManager);
        }catch(Exception e) {
            
            e.printStackTrace();
            
        }
        
    }
    
    @Override
    public void run() {
        
        try{
        init();
        
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        ticks = 0;
        int lastTicks = 0;
        
        while(running) {
            
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;
	    
            if(delta >= 1) {
                
                tick();
                render();
                ticks++;
                delta--;
                
            }
            
            if(timer >= 1000000000) {
                
                lastTicks = ticks;
                ticks = 0;
                timer = 0;
                
            }
            
        }
        
        stop();
        }catch(Exception e) {
            
            e.printStackTrace();
            
        }
        
    }
    
    private void tick() {
        
        try{
        keyManager.tick();
        if(State.getState() != null)
            State.getState().tick();
        width = display.getFrame().getWidth();
        height = display.getFrame().getHeight() - 22;
        }catch(Exception e) {
            
            e.printStackTrace();
            
        }
        
    }
    
    private void render() {
        
        try{
        bs = display.getCanvas().getBufferStrategy();
        
        if(bs == null) {
            
            display.getCanvas().createBufferStrategy(3);
            return;
            
        }
        g = bs.getDrawGraphics();
        //Clear the screen
        g.clearRect(0, 0, width, height);
        //Drawing
        if(State.getState() != null)
            State.getState().render(g);
        //Drawing ends
        
        bs.show();
        g.dispose();
        }catch(Exception e) {
            
            e.printStackTrace();
            
        }
        
    }
    
    public KeyManager getKeyManager() {
        
        return keyManager;
        
    }
    
    public GameCamera getGameCamera() {
        
        return gameCamera;
        
    }
    
    public World getWorld() {
        
        World world = new World(handler, path, tiles1, tiles2);
        return world;
        
    }
    
    public synchronized void start() {
        
        try{
        if(running)
            return;
        
        running = true;
        thread = new Thread(this);
        thread.start();
        }catch(Exception e) {
            
            e.printStackTrace();
            
        }
        
    }
    
    public synchronized void stop() {
        
        try{
        if(!running)
            return;
        
        running = false;
        
        try {
            
            thread.join();
            
        } catch (InterruptedException e) {
            
            e.printStackTrace();
            
        }
        }catch(Exception e) {
            
            e.printStackTrace();
            
        }
        
    }
    
    public static int getTicks() {
        
        return ticks;
        
    }
    
    public int getWidth() {
        
        return this.width;
        
    }
    
    public int getHeight() {
        
        return this.height;
        
    }
    
}
