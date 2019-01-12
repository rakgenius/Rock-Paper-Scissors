package game;

import java.util.Comparator;
import java.util.Scanner;

public class RockPaperScissors implements Comparator<Type> {
    private int userWon = 0;
    private int computerWon = 0;
    private int ties = 0;

    public int getUserWon() {
        return userWon;
    }

    public void setUserWon(int userWon) {
        this.userWon = userWon;
    }

    public int getComputerWon() {
        return computerWon;
    }

    public void setComputerWon(int computerWon) {
        this.computerWon = computerWon;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    /**
     * Compare the types. values are assigned in ascending order from 0 till 2
     *
     * @param o1
     * @param o2
     * @return Winner
     */
    public int compare(Type o1, Type o2) {
        // If both are same then its a TIE
        if (o1 == o2)
            return 0;

        switch (o1) {
            // Rock wins over scissor but not over paper
            case ROCK:
                return (o2 == Type.SCISSORS ? 1 : -1);

            // Paper wins over rock but not over scissors
            case PAPER:
                return (o2 == Type.ROCK ? 1 : -1);

            // Scissors wins over paper but not over rock
            case SCISSORS:
                return (o2 == Type.PAPER ? 1 : -1);
        }

        // Control shouldnt come here
        return 0;
    }

    /**
     * Function to decide the winner based on the comparison value
     *
     * 0 : Its tie
     * 1 : User won
     * 2: Computer Won
     *
     * @param winner
     */
    public void decideWinner(int winner) {
        switch (winner) {
            case 0:
                System.out.println("Its a TIE");
                this.ties++;
                break;

            case 1:
                System.out.println("User WON");
                this.userWon++;
                break;

            case -1:
                System.out.println("Computer WON");
                this.computerWon++;
                break;
        }

    }

    public void displayGameStats() {
        System.out.println("=========Game results=======");
        System.out.println("Number of times USER WON: " + this.userWon);
        System.out.println("Number of times Computer WON: " + this.computerWon);
        System.out.println("Number of times the game was TIE: " + this.ties);
    }

    /**
     * Function to play the game. This takes two parameters.
     * The option selected by the user and the random option
     * selected by computer. Depending on the algorithm of the
     * ROCK PAPER and SCISSORS algorithm, the winner is chosen
     * and the stats are updated so when the game exits, the stats
     * are displayed.
     *
     * @param userOption
     * @param computerOption
     */
    public void play(int userOption, int computerOption) {
        Computer computer = new Computer(computerOption);
        User user = new User(userOption);

        Type userChoice = user.getPlay();
        if (userChoice == null) {
            System.out.println("Invalid option");
            return;
        }

        Type computerChoice = computer.getPlay();

        // Compare the vlaues
        int returnValue = compare(userChoice, computerChoice);

        // Decide the winner based on the value
        decideWinner(returnValue);
        System.out.println("User selected " + userChoice.toString() +
                " and Computer selected " + computerChoice.toString());
    }

    public static void main(String[] args) {
        RockPaperScissors rps = new RockPaperScissors();
        int number;
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Please select your option: 0 (ROCK), 1 (PAPER), 2 (SCISSORS) Enter 999 to exit the game: \n");
            number = scanner.nextInt();
            while (number != 999) {
                // Play the game
                rps.play(number, Integer.MAX_VALUE);

                System.out.print("Please select your option: 0 (ROCK), 1 (PAPER), 2 (SCISSORS) Enter 999 to exit the game: \n");
                number = scanner.nextInt();
            }
        } catch (Exception e) {
            System.out.println("Please enter only numbers.");
        }

        rps.displayGameStats();
    }
}
