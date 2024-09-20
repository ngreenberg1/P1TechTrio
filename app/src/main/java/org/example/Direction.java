package org.example;

public enum Direction {
    N, E, S, W; 

    //TODO
    //fix the exception handling here so that rover tests pass
    public Direction turnLeft() {
        switch(this) {
            case N: return W;
            case W: return S;
            case S: return E;
            case E: return N;
            default: throw new IllegalStateException("Invalid direction: Z. Use 'N', 'E', 'S', or 'W'.");

        }
    }

    //TODO
    //fix the exception handling here so that rover tests pass
    public Direction turnRight() {
        switch(this) {
            case N: return E;
            case W: return N;
            case S: return W;
            case E: return S;
            default: throw new IllegalStateException("Invalid direction: Z. Use 'N', 'E', 'S', or 'W'.");

        }
    }
}