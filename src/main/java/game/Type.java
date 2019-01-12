package game;

public enum Type {
    // Rock
    ROCK,

    // Paper
    PAPER,

    // Scissor
    SCISSORS
    ;

    private final int type = 0;

    public static Type getType(int index) {
        Type[] types = Type.values();
        return types[index];
    }

    /**
     * Return the integer value for the corresponding ENUM value
     * @param type
     * @return
     */
    public static int getTypeValue(Type type) {
        return type.ordinal();
    }
}
