package game;

public class User implements Play {
    private int userOption;

    User(int option) {
        this.userOption = option;
    }

    public Type getPlay() {
        if (userOption > NUMBER_OF_PLAYS) {
            return null;
        }
        return Type.getType(userOption);
    }
}
