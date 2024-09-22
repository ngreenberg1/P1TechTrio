package org.example;

public class Plateau {
    /** x-coordinate for map */
    private int dimX;

    /** y-coordinate for map */
    private int dimY;


    /** Basic constructor */
    public Plateau(int dimX, int dimY) {
        //check first that rover dimensions are positive integers
        if (dimX <= 0 || dimY <= 0) {
            throw new IllegalArgumentException("Dimensions must be positive.");
        }
        this.dimX = dimX;
        this.dimY = dimY;
    }

    public int getDimX() {
        return dimX;
    }

    public int getDimY() {
        return dimY;
    }

    public boolean isWithinBounds(int x, int y) {
        return x >= 0 && x <= dimX && y >= 0 && y <= dimY;
    }

    //to string method in case we want to output this after plateau initialization
    @Override
    public String toString() {
        return "Plateau dimensions: " + dimX + "x" + dimY;
    }


} // class org.example.Plateau