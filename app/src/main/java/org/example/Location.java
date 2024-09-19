package org.example;

public class Location {
    /** x-coordinate for map */
    private int x;

    /** y-coordinate for map */
    private int y;

    /** Basic constructor */
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /* Accessors & Mutators */
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        // TO DO: integrate limits of plateau (either wrap around using mod or throw an exception)
        this.x = x;
    }

    public void setY(int y) {
        // TO DO: integrate limits of plateau (either wrap around using mod or throw an exception)
        this.y = y;
    }

    public String toString() {
        return "(" + this.x + " " + this.y + ")";
    }

} // class org.example.Location