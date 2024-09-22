package org.example;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        try {

        // Initialize plateau first, if this fails the overarching try/catch is prompted
        System.out.print("Enter plateau dimensions: ");
        int dimX = sc.nextInt();
        int dimY = sc.nextInt();
        sc.nextLine();  

        Plateau plateau = new Plateau(dimX, dimY); 
        Simulator simulator = new Simulator(dimX, dimY);

        // Read input for each rover
        while (true) {
            
            System.out.print("Enter rover's position or \"close\" to stop adding new rovers: ");
            String firstLine = sc.nextLine();

            if (firstLine.equalsIgnoreCase("close")) {
                break; 
            }

            try {
                // Rover initialization (1st rover input line)
                String[] position = firstLine.split(" ");
                int rX = Integer.parseInt(position[0]);
                int rY = Integer.parseInt(position[1]);
                String direction = position[2];

                if (!isValidDirection(direction)) {
                    throw new IllegalArgumentException("\tInvalid direction: " + direction);
                }

                Rover rover = new Rover(new Location(rX, rY), direction, plateau);

                // Rover movements (2nd rover input line)
                System.out.print("Enter movement commands: "); 
                String commands = sc.nextLine();
                if (!isValidCommand(commands)) {
                    throw new IllegalArgumentException("\tInvalid command string: " + commands);
                }

                // Add input (if accepted) to the simulator
                simulator.addRover(rover, commands);

            } catch (NumberFormatException e) {
                System.out.println("\tRover initialization invalid. Ex format: 1 2 N");
            } catch (Exception e) {
                System.out.println("\tAn error occurred: " + e.getMessage());
            }
        }

        sc.close();

        // Alternative display option (print)
        // System.out.println("\nFinal Rover positions:");
        // simulator.moveAndPrintRovers();

        System.out.println("\nCommand line grid representations: ");
        simulator.moveAndDisplyRovers();
        
    } catch (Exception e) {
        System.out.println("\tError: Invalid plateau dimensions. Example format: 5 5");
    }

    } // main method

    // Restricting direction input
    private static boolean isValidDirection(String direction) {
        return Direction.valueOf(direction) != null;
    }

    // Restricting rover command input (chars excepted are only instances of LRM)
    private static boolean isValidCommand(String command) {
        return command.matches("[LRM]+"); 
    }

} // program class