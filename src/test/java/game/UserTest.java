package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getPlayInvalidOption() {
        User user = new User(500);
        Type type = user.getPlay();
        assertNull(type);
    }

    @Test
    void getPlayValidOption() {
        User user = new User(1);
        Type type = user.getPlay();
        assertEquals(Type.PAPER, type);
    }
}