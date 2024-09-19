public class Rover {
    /** x-coordinate for map */
    private Location l;

    /** cardinal directions in the form of N, E, S, or W */    
    private Direction d; 

    /** Basic constructor */
    public Rover(Location l, String d) {
        this.l = l;
        setD(d);
    }

    /* Accessors & Mutators */
    public Location getL() {
        return this.l;
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

    /*
     For parsing movement string "LMRMLMMM" 
     Note: unsure if we should move to a different class
     */
    //we could move this to control class and then use main for prompting and enforcing valid input 
    public void move(char command) {
            if (command == 'L') d.turnLeft();
            if (command == 'R') d.turnRight();
            if (command == 'M') moveM();
    }

    /* 
    If facing this direction, move this way: 
        N (x, y+1) 
        E (x + 1, y)
        S (x, y -1)
        W (x-1, y)
    */
    public void moveM() {
        if(l.getY() - 1 < 0 || l.getY() - 1 < 0 /* TO DO: Add plateau max sizes from class */) {
            if("N".equals(getD())) l.setY(l.getY() + 1);
            if("E".equals(getD())) l.setX(l.getX() + 1);
            if("S".equals(getD())) l.setY(l.getY() - 1);
            if("W".equals(getD())) l.setX(l.getX() - 1);
        }
    }

    public String toString() {
        return "(" + this.l + " " + this.d + ")";
    }

} // class Rover