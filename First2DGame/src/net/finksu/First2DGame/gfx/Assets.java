package net.finksu.First2DGame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
    
    private static final int width = 32, height = 32;
    
    public static BufferedImage grass, dirt, stone_brick, player, air;
    
    public static void init() {
        
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/tiles.png"));
        
        grass = sheet.crop(0, 0, width, height);
        stone_brick = sheet.crop(width + 1, 0, width, height);
        dirt = sheet.crop(width * 2 + 2, 0, width, height);
        air = sheet.crop(width * 3 + 3, 0, width, height);
        player = ImageLoader.loadImage("/textures/Player.png");
        
    }
    
}