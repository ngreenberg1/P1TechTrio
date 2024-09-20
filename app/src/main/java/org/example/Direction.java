package org.example;

public enum Direction {
    N, E, S, W;

    // Turn left
    // 90 degrees leftwards by iterating over the enum, % 4 wraps around
    public Direction turnLeft() {
        return values()[(this.ordinal() + 3) % 4];
    }


    // Turn right
    public Direction turnRight() {
        return values()[(this.ordinal() + 1) % 4];
    }

} // enum Direction