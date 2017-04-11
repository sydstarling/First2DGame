package net.finksu.First2DGame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
    
    private boolean[] keys;
    public boolean up, left, right, down, O, up1, down1, right1, left1, esc;
    
    public KeyManager() {
        
        keys = new boolean[256];
        
    }
    
    public void tick() {
        
        esc = keys[KeyEvent.VK_ESCAPE];
        up1 = keys[KeyEvent.VK_UP];
        right1 = keys[KeyEvent.VK_RIGHT];
        left1 = keys[KeyEvent.VK_LEFT];
        down1 = keys[KeyEvent.VK_DOWN];
        up = keys[KeyEvent.VK_W];
        right = keys[KeyEvent.VK_D];
        left = keys[KeyEvent.VK_A];
        down = keys[KeyEvent.VK_S];
        O = keys[KeyEvent.VK_O];
        
        
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
        
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        keys[e.getKeyCode()] = true;
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        keys[e.getKeyCode()] = false;
        
    }
    
}
