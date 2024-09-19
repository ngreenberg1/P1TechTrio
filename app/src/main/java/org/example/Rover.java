package org.example;

public class Rover {
    /** x-coordinate for map */
    private Location l;

    /** cardinal directions in the form of N, E, S, or W */    
    private Direction d; 

    //plateau that the rover will be moving on
    private Plateau plateau;

    /** Basic constructor */
    public Rover(Location l, String d, Plateau plateau) {
        this.l = l;
        setD(d);
        this.plateau = plateau;
    }

    /* Accessors & Mutators */
    public Location getL() {
        return this.l;
    }

    public Direction getD() {
        return this.d;
    }

    // maybe
    public void setD(String d) {
        this.d = Direction.valueOf(d); //convert string to Direction enum
    }


    /*
     For parsing movement string "LMRMLMMM" 
     Note: unsure if we should move to a different class
     */
    //we could move this to control class and then use main for prompting and enforcing valid input
    //Rather than throw an exception we could re-prompt like in the isWithinBounds method
    public void move(char command) {
        switch (command) {
            case 'L':
                d = d.turnLeft();
                break;
            case 'R':
                d = d.turnRight();
                break;
            case 'M':
                moveM();
                break;
            default:
                throw new IllegalArgumentException("Invalid command: " + command + ". Use 'L', 'R', or 'M'");
        }
    }

    /* 
    If facing this direction, move this way: 
        N (x, y+1) 
        E (x + 1, y)
        S (x, y -1)
        W (x-1, y)
    */
    /* Move the rover one step forward based on its direction */
    public void moveM() {
        int newX = l.getX();
        int newY = l.getY();

        switch (d) {
            case N:
                newY += 1;
                break;
            case E:
                newX += 1;
                break;
            case S:
                newY -= 1;
                break;
            case W:
                newX -= 1;
                break;
        }

        // Check if the new position is within the plateau's bounds
        if (plateau.isWithinBounds(newX, newY)) {
            l.setX(newX);
            l.setY(newY);
        } else {
            System.out.println("Move out of bounds! Please try again.");
        }

    }



    @Override
    public String toString() {
        return  this.l + " " + this.d;
    }



} // class org.example.Rover