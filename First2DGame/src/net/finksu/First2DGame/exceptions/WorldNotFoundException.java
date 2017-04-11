package net.finksu.First2DGame.exceptions;

public class WorldNotFoundException extends RuntimeException {

    public WorldNotFoundException(){
        
        super();
        
    }

    public WorldNotFoundException(String message){
        
        super(message);
        
    }
}