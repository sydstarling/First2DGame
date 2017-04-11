package net.finksu.First2DGame.tiles;

import net.finksu.First2DGame.gfx.Assets;

public class StoneTile extends Tile {
    
    public StoneTile(int id) {
        
        super(Assets.stone_brick, id);
        
    }
    
    @Override
    public boolean isSolid() {
        
        return true;
        
    }
    
}
