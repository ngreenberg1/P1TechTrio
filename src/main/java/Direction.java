public enum Direction {
    N, E, S, W; 

    public Direction turnLeft() {
        switch(this) {
            case N: return W;
            case W: return S;
            case S: return E;
            case E: return N;
        }
        throw new IllegalStateException("Invalid Direction");
    }

    public Direction turnRight() {
        switch(this) {
            case N: return E;
            case W: return N;
            case S: return W;
            case E: return S;
        }
        throw new IllegalStateException("Invalid Direction");
    }
}