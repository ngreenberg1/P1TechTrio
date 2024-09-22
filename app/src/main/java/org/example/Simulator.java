package org.example;

import java.util.ArrayList;
import java.util.List;

public class Simulator {

    private Plateau plateau;
    private List<Rover> rovers = new ArrayList<>();
    private List<String> commandsList = new ArrayList<>();

    public Simulator(int dimX, int dimY) {
        this.plateau = new Plateau(dimX, dimY);
    }

    /* Decided against placing commands into Rover object because they act independent from the class
    They're not an attribute. Ex: plateau also has input */
    public void addRover(Rover rover, String commands) {
        this.rovers.add(rover);
        this.commandsList.add(commands);
    }

    public void moveAndDisplyRovers() {
        Display display = new Display();
        for (int i = 0; i < rovers.size(); i++) {
            Rover rover = rovers.get(i);
            String commands = commandsList.get(i);
            System.out.println("Rover " + i);
            // show intial pos then loop through the commands
            display.showGrid(plateau, rover);

            for (char command : commands.toCharArray()) {
                rover.move(command);
                display.showGrid(plateau, rover);
            }

            System.out.println();
        }
    }

    // Standard string representation of rover's position 
    public void moveAndPrintRovers() {
        for (int i = 0; i < rovers.size(); i++) {
            Rover rover = rovers.get(i);
            String commands = commandsList.get(i);

            for (char command : commands.toCharArray()) {
                rover.move(command);
            }

            System.out.println(rovers.get(i).toString());
        
        }
    }
}