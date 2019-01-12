package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    @Test
    void getPlay() {
        Computer computer = new Computer(0);
        Type type = computer.getPlay();
        assertEquals(Type.ROCK, type);
    }

    @Test
    void getPlayValidOption() {
        Computer computer = new Computer();
        Type type = computer.getPlay();
        assertNotNull(type);
    }
}