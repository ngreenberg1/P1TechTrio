package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

//TODO
//need to improve the program logic so that valid and correctly formatted input is enforced,
//and user is prompted for new input in the case of invalid input, rather than the program exiting

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //TODO
        //enforce valid input so that testInvalidPlateauDimension test passes
        //Get plateau dimensions
        System.out.println("Enter plateau dimensions (format: X Y): ");
        int dimX = scanner.nextInt();
        int dimY = scanner.nextInt();
        Plateau plateau = new Plateau(dimX, dimY);

        // List to store rovers
        List<Rover> rovers = new ArrayList<>();

        while (true) {
            System.out.println("Enter rover's starting position (format: 1 2 N) or type 'done' to finish:");
            String input = scanner.next();
            if (input.equalsIgnoreCase("done")) {
                break;
            }

            // Read the starting position of the rover
            int startX = Integer.parseInt(input);
            int startY = scanner.nextInt();
            String startDirection = scanner.next();

            // Validate initial location within bounds
            if (!plateau.isWithinBounds(startX, startY)) {
                System.out.println("Rover starting position is out of bounds. Try again.");
                continue;
            }

            // Create and add the rover to the list
            Location location = new Location(startX, startY);
            Rover rover = new Rover(location, startDirection, plateau);
            rovers.add(rover);
        }

        // Step 3: Process commands for each rover
        for (int i = 0; i < rovers.size(); i++) {
            Rover rover = rovers.get(i);
            System.out.println("Enter movement commands for rover " + (i+1) + " at position " + rover + " (format: LMR): ");
            String commands = scanner.next();

            // Execute each command
            for (char command : commands.toCharArray()) {
                rover.move(command);
            }

            // Step 4: Display final position for each rover
            System.out.println("Final position of rover " + (i+1) + ": " + rover);
        }

        scanner.close();
    }

}
