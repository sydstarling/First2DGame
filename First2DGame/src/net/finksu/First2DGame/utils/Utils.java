package net.finksu.First2DGame.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import net.finksu.First2DGame.exceptions.WorldNotFoundException;

public class Utils {
    
    public static String loadFileAsString(String path) {
        
        StringBuilder builder = new StringBuilder();
        
        try{
            
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while((line = br.readLine()) != null)
                builder.append(line + "\n");
            br.close();
            
        }catch(IOException e) {
            
            throw new WorldNotFoundException("World not found with path " + path);
            
        }
        
        return builder.toString();
        
    }
    
    public static int parseInt(String number) {
        
        try{
            
            return Integer.parseInt(number);
            
        }catch(NumberFormatException e) {
            
            e.printStackTrace();
            return 0;
            
        }
        
    }
    
}
