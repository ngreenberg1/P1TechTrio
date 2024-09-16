import org.junit.Test;
import static org.junit.Assert.*;

public class RoverTest {

    @Test 
    public void testRoverInitialization() {
        Rover rover = new Rover(1, 2, "N");

        assertEquals(1, rover.getX());
        assertEquals(1, rover.getY());
        assertEquals("N", rover.getDirection());
    }


    #TODO 
    //add more Rover-specific tests here like RoverMovesForward, RoverRotatesLeft, RoverRotatesRight,
   
    @Test 
    public void testSetDirectonValid() {
        Rover rover = new Rover(0, 0, "N");
        rover.setD("E");
        assertEquals(Direction.E, rover.getD());

        rover.setD("S");
        assertEquals(Direction.S, rover.getD());

        rover.setD("W");
        assertEquals(Direction.W, rover.getD());
    }

    @Test 
    public void testSetDirectionInvalid() {
        Rover rover = new Rover(0, 0, "N");
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            rover.setD("Z");
        });

        assertEquals("Invalid direction: Z. Use 'N', 'E', 'S', or 'W'.", exception.getMessage());
        
    }

    @Test
    public void testToString() {
        Rover rover = new Rover(1, 2, "N");
        assertEquals("(1 2 N)", rover.toString());
    }

}

