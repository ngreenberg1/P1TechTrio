
import java.time.chrono.ThaiBuddhistChronology;

public class Rover implements IRover {
    /** x-coordinate for map */
    private int x;

    /** y-coordinate for map */
    private int y;

    /** cardinal directions in the form of N, E, S, or W */    
    private char d; 

    /** Basic constructor */
    public Rover(int x, int y, String d) {
        this.x = x;
        this.y = y;
        this.d = setD(d); 
    }

    /* Accessors & Mutators */
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String getD() {
        return this.d;
    }

    public void setD(d) {
        if(// this direction is not North, South, West, East) { throws Exception }
        this.d = d;
    }

    public String toString() {
        return "(" + this.x + " " + this.y + this.d + ")";
    }

} // class Rover