package game;

import org.junit.jupiter.api.Test;
import game.Type;

import static org.junit.jupiter.api.Assertions.*;

class RockPaperScissorsTest {

    @Test
    void compare() {
        RockPaperScissors rps = new RockPaperScissors();
        Type type1 = Type.PAPER;
        Type type2 = Type.ROCK;

        // type1 should win
        int returnValue = rps.compare(type1, type2);
        assertEquals(1, returnValue);

        type1 = Type.ROCK;
        type2 = Type.PAPER;

        // type2 should win
        returnValue = rps.compare(type1, type2);
        assertEquals(-1, returnValue);

        type1 = Type.PAPER;
        type2 = Type.PAPER;

        // tie
        returnValue = rps.compare(type1, type2);
        assertEquals(0, returnValue);

        // rock wins over scissors
        type1 = Type.ROCK;
        type2 = Type.SCISSORS;

        returnValue = rps.compare(type1,type2);
        assertEquals(1, returnValue);

        // scissor wins over paper
        type1 = Type.SCISSORS;
        type2 = Type.PAPER;
        returnValue = rps.compare(type1, type2);
        assertEquals(1, returnValue);
    }

    @Test
    void decideWinner() {
        RockPaperScissors rps = new RockPaperScissors();
        rps.decideWinner(0);
        assertEquals(1, rps.getTies());

        rps.decideWinner(1);
        assertEquals(1, rps.getUserWon());

        rps.decideWinner(-1);
        assertEquals(1, rps.getComputerWon());
    }

    @Test
    void play() {
        RockPaperScissors rps = new RockPaperScissors();
        rps.play(Type.getTypeValue(Type.ROCK), Type.getTypeValue(Type.SCISSORS));

        // Rock wins over scissors. So user wins
        assertEquals(1, rps.getUserWon());

        // Rock loses for paper, SO computerwins
        rps.play(Type.getTypeValue(Type.ROCK), Type.getTypeValue(Type.PAPER));
        assertEquals(1, rps.getComputerWon());

        // Tie betwen any two same types
        rps.play(Type.getTypeValue(Type.ROCK), Type.getTypeValue(Type.ROCK));
        assertEquals(1, rps.getTies());
    }
}