package net.finksu.First2DGame.Display;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Display {
    
    private JFrame frame;
    private String title;
    private int width, height;
    private Canvas canvas;
    
    public Display(String title, int width, int height) {
        
        this.title = title;
        this.width = width;
        this.height = height;
        createDisplay();
        
    }
    
    private void createDisplay() {
        
        try{
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);
        
        frame.add(canvas);
        frame.pack();
        }catch(Exception e) {
            
            e.printStackTrace();
            
        }
        
    }
    
    public Canvas getCanvas() {
        
        return canvas;
        
    }
    
    public JFrame getFrame() {
        
        return frame;
        
    }
    
}
