package net.finksu.First2DGame;

import java.util.Scanner;

public class Launcher {
    
    public static int width = 800;
    public static int height = 480;
    public static String worldpath = "worlds/world1.level";
    private static int tiles1 = 0;
    private static int tiles2 = 0;
    
    public static void main(String[] args) {
        
        try{
        Scanner sc = new Scanner(System.in);
        
        worldpath = sc.nextLine();
        if(worldpath.equalsIgnoreCase("default"))
            worldpath = "worlds/world1.level";
        else if(worldpath.equalsIgnoreCase("random")) {
            
            tiles1 = sc.nextInt();
            tiles2 = sc.nextInt();
            
        }
        if(!worldpath.equalsIgnoreCase("random")) {
            
            tiles1 = 7;
            tiles2 = 9;
            String pathending = worldpath.substring(worldpath.length() - 6);
            if(!pathending.equalsIgnoreCase(".level") && !worldpath.equalsIgnoreCase("default")) {
                
                System.out.println("The world must be .level!");
                System.exit(0);
                
            }
            
        }
        width = sc.nextInt();
        height = sc.nextInt();
        Game game = new Game("First2DGame", width, height, worldpath, tiles1, tiles2);
        game.start();
        }catch(Exception e) {
            
            e.printStackTrace();
            
        }
        
    }
    
}
