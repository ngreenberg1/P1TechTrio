package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RoverTest {

    @Test 
    public void testRoverInitialization() {
        Plateau plateau = new Plateau(5, 5);
        Location location = new Location(1, 2);
        Rover rover = new Rover(location, "N", plateau);

        assertEquals(1, 2, rover.getL());
        assertEquals("N", rover.getD());
    }


    
    //add more org.example.Rover-specific tests here like RoverMovesForward, RoverRotatesLeft, RoverRotatesRight,
   
    @Test 
    public void testSetDirectionValid() {
        Location location = new Location(0, 0);
        Rover rover = new Rover(location, "N");
        rover.setD("E");
        assertEquals(Direction.E, rover.getD());

        rover.setD("S");
        assertEquals(Direction.S, rover.getD());

        rover.setD("W");
        assertEquals(Direction.W, rover.getD());
    }

    @Test 
    public void testSetDirectionInvalid() {
        Location location = new Location(0, 0);
        Rover rover = new Rover(location, "N");
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            rover.setD("Z");
        });

        assertEquals("Invalid direction: Z. Use 'N', 'E', 'S', or 'W'.", exception.getMessage());
        
    }

    @Test
    public void testToString() {
        Location location = new Location(1, 2);
        Rover rover = new Rover(location, "N");
        assertEquals("(1 2 N)", rover.toString());
    }

}

