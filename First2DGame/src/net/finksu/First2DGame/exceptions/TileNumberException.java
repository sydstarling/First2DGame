package net.finksu.First2DGame.exceptions;

public class TileNumberException extends RuntimeException {

    public TileNumberException(){
        
        super();
        
    }

    public TileNumberException(String message){
        
        super(message);
        
    }
}