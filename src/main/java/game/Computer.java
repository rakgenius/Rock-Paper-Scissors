package game;

import java.util.Random;

public class Computer implements Play {
    private int computerChoice;

    public int getComputerChoice() {
        return computerChoice;
    }

    public void setComputerChoice(int computerChoice) {
        this.computerChoice = computerChoice;
    }

    public Computer(int computerChoice) {
        this.computerChoice = computerChoice;
    }

    public Computer() {
        this.computerChoice = Integer.MAX_VALUE;
    }

    public Type getPlay() {
        Random generator = new Random();
        int random = this.getComputerChoice();
        if (random > NUMBER_OF_PLAYS) {
            // Get random option for computer
            random = generator.nextInt(NUMBER_OF_PLAYS);
        }
        return Type.getType(random);
    }
}
