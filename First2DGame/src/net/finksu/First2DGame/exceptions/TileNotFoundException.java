package net.finksu.First2DGame.exceptions;

public class TileNotFoundException extends RuntimeException {

    public TileNotFoundException(){
        
        super();
        
    }

    public TileNotFoundException(String message){
        
        super(message);
        
    }
}