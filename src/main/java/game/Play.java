package game;

public interface Play {
    static final int NUMBER_OF_PLAYS = Type.values().length - 1;
    public Type getPlay();
}
