package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        // NOT currently protected from invalid io
        int dimX = sc.nextInt();
        int dimY = sc.nextInt();
        sc.nextLine();  
        Plateau plateau = new Plateau(dimX, dimY);            

        // might not need? (depends on design)
        List<Rover> rovers = new ArrayList<>();

        // Read input for each rover
        while (true) {
            // OPTIONAL PROMPT: System.out.print("Enter rover's position or \"close\": ");
            String firstLine = sc.nextLine();

            if (firstLine.equalsIgnoreCase("close")) {
                break; // not really best practice might want to try alternatives 
            }

            try {
                // Rover initialization
                String[] position = firstLine.split(" ");
                
                int rX = Integer.parseInt(position[0]);
                int rY = Integer.parseInt(position[1]);
                String direction = position[2];

                Location l = new Location(rX, rY);
                Rover rover = new Rover(l, direction, plateau);
                // MIGHT NOT NEED? Depends on TUI implementation also descisions
                rovers.add(rover);

                // OPTIONAL PROMPT: System.out.print("Enter movement commands: "); 
                String commands = sc.nextLine();
                for (char command : commands.toCharArray()) {
                    display(plateau, rover);
                    rover.move(command);
                }

                // Display final position -NOTE: unsure where to place this or if design can be improved
                display(plateau, rover);

            } catch (NumberFormatException e) {
                System.out.println("Rover initialization invalid. Ex format: 1 2 N");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        sc.close();

        // Optionally show final output for all rovers
        for (Rover r : rovers) {
            System.out.println(r.toString());
        }
    } // main

     /* 
     Method to display the plateau with the rover's current position
     Note: might change to use movement line to show entire sequence of moves at once
     */
     public static void display(Plateau plateau, Rover rover) {
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

        // MIGHT CHANGE IMPLEMENTATION
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
        System.out.println(rover.toString()); // not needed but thought it would be helpbul
        System.out.println();

    } // display  

}