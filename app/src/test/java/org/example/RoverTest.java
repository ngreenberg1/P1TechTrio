package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class RoverTest {

    @Test 
    public void testRoverInitialization() {
        Plateau plateau = new Plateau(5, 5);
        Location location = new Location(1, 2);
        Rover rover = new Rover(location, "N", plateau);

        assertEquals(1, rover.getL().getX(), "X coordinate should be 1");
        assertEquals(2, rover.getL().getY(), "Y coordinate should be 2");
        assertEquals(Direction.N, rover.getD(), "Direction should be North");
    }


    
    //add more org.example.Rover-specific tests here like RoverMovesForward, RoverRotatesLeft, RoverRotatesRight,
    @Test
    public void testRoverMoveForward() {
        Plateau plateau = new Plateau(5, 5);
        Location location = new Location(1, 1);
        Rover rover = new Rover(location, "N", plateau);

        rover.move('M');
        assertEquals(1, rover.getL().getX(), "X coordinate should be 1");
        assertEquals(2, rover.getL().getY(), "Y coordinate should be 2");
    }

    @Test
    public void testRoverTurnLeft() {
        Plateau plateau = new Plateau(5, 5);
        Location location = new Location(1, 1);
        Rover rover = new Rover(location, "N", plateau);

        rover.move('L'); //Turn left from North
        assertEquals(Direction.W, rover.getD(), "Direction should be W");

        rover.move('L'); //Turn left from west
        assertEquals(Direction.S, rover.getD(), "Direction should be S");

        rover.move('L'); //turn left from south
        assertEquals(Direction.E, rover.getD(), "Direction should be E");

        rover.move('L'); //Turn left from east
        assertEquals(Direction.N, rover.getD(), "Direction should be N");
    }

    @Test
    public void testRoverTurnRight() {
        Plateau plateau = new Plateau(5, 5);
        Location location = new Location(1, 1);
        Rover rover = new Rover(location, "N", plateau);

        rover.move('R'); //Turn right from North
        assertEquals(Direction.E, rover.getD(), "Direction should be E");

        rover.move('R'); //Turn right from East
        assertEquals(Direction.S, rover.getD(), "Direction should be S");

        rover.move('R'); //Turn right from South
        assertEquals(Direction.W, rover.getD(), "Direction should be W");

        rover.move('R'); //Turn right from West
        assertEquals(Direction.N, rover.getD(), "Direction should be N");
    }
    @Test 
    public void testSetDirectionValid() {
        Location location = new Location(0, 0);
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover(location, "N", plateau);

        rover.setD("E");
        assertEquals(Direction.E, rover.getD());

        rover.setD("S");
        assertEquals(Direction.S, rover.getD());

        rover.setD("W");
        assertEquals(Direction.W, rover.getD());
    }

    @Test
    public void testRoverMoveOutOfBounds() {
        Plateau plateau = new Plateau(5, 5);
        Location location = new Location(5, 5);
        Rover rover = new Rover(location, "E", plateau);

        rover.move('M'); //should not be allowed
        assertEquals(5, rover.getL().getX(), "X coordinate should be 5");
        assertEquals(5, rover.getL().getY(), "Y coordinate should be 5");
    }

    //TODO
    //can someone check the logic here? I'm having a hard time deciding what
    //the final coordinates of the rover should be.  need to make sure that 2,2 is correct
    @Test
    public void testRoverCommands() {
        Plateau plateau = new Plateau(5, 5);
        Location location = new Location(1, 1);
        Rover rover = new Rover(location, "N", plateau);

        rover.move('M'); //move north
        rover.move('R'); //turn right to east
        rover.move('M'); //move east

        assertEquals(2, rover.getL().getX(), "X coordinate should be 2");
        assertEquals(2, rover.getL().getY(), "Y coordinate should be 2");
        assertEquals(Direction.E, rover.getD(), "Direction should be East");
    }


    //TODO
    //failing test
    //not the biggest problem if this is failing but shouldn't be too hard to fix
    @Test
    public void testToString() {
        Location location = new Location(1, 2);
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover(location, "N", plateau);

        assertEquals("(1 2) N", rover.toString());
    }

}

