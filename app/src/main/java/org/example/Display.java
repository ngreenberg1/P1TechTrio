package org.example;

public class Display {
    
    // Method to display the plateau with the rover's current position
    public static void showGrid(Plateau plateau, Rover rover) {
        
        // Creating a grid to represent the plateau
        int dimX = plateau.getDimX();
        int dimY = plateau.getDimY();
        
        String[][] grid = new String[dimY + 1][dimX + 1];
        
        for (int y = 0; y <= dimY; y++) {
            for (int x = 0; x <= dimX; x++) {
                grid[y][x] = "_";
            }
        }

        // Get Rover's info
        Location loc = rover.getL();
        Direction direction = rover.getD();  

        String roverSymbol;
        roverSymbol = switch (direction) {
            case Direction.N -> "⋀";
            case Direction.E -> ">";
            case Direction.S -> "v";
            case Direction.W -> "<";
            default -> "R";
        }; 

        // For rover's current location, display on grid with a symbol representing direction
        grid[dimY - loc.getY()][loc.getX()] = roverSymbol; 

        // Print 
        for (int y = 0; y <= dimY; y++) {
            for (int x = 0; x <= dimX; x++) {
                System.out.print(grid[y][x] + " ");
            }
            System.out.println();
        }
        System.out.println(rover.toString()); // not needed but thought it would be helpful
        System.out.println();

    } // method showGrid

} // Class Display