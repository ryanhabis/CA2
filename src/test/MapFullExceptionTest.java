package test;

import Exceptions.MapFullException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MapFullExceptionTest {

    @Test
    public void testMapFullException(){
        try{
            throw new MapFullException("The map is full.");
        }catch(MapFullException e){
            assertEquals("The map is full.", e.getMessage());
        }

        assertThrows(MapFullException.class, () -> {
            throw new MapFullException("The map is full.");
        });
    }
}
