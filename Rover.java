
import java.time.chrono.ThaiBuddhistChronology;

public class Rover {
    /** x-coordinate for map */
    private int x;

    /** y-coordinate for map */
    private int y;

    /** cardinal directions in the form of N, E, S, or W */    
    private Direction d; 

    /** Basic constructor */
    public Rover(int x, int y, String d) {
        this.x = x;
        this.y = y;
        setD(d); 
    }

    /* Accessors & Mutators */
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Direction getD() {
        return this.d;
    }

    public void setD(String d) {
        try {
            this.d = Direction.valueOf(d); //convert string to Direction enum 
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid direction: " + d + ". Use 'N', 'E', 'S',or 'W'");
        }      
    }

    
    public String toString() {
        return "(" + this.x + " " + this.y + this.d + ")";
    }

} // class Rover