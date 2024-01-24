import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    @Test
    public void testWinFirstPlayer() {
        Player yra = new Player(1, "Юра", 9);
        Player sacha = new Player(2, "Саша", 7);
        Game game = new Game();

        game.register(yra);
        game.register(sacha);
        int actual = game.round("Юра", "Саша");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWinSecondPlayer() {
        Player yra = new Player(1, "Юра", 7);
        Player sacha = new Player(2, "Саша", 9);
        Game game = new Game();

        game.register(yra);
        game.register(sacha);
        int actual = game.round("Юра", "Саша");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWinBothPlayers() {
        Player yra = new Player(1, "Юра", 9);
        Player sacha = new Player(2, "Саша", 9);
        Game game = new Game();

        game.register(yra);
        game.register(sacha);
        int actual = game.round("Юра", "Саша");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testNotRegisteredFirstPlayer() {
        Player yra = new Player(1, "Юра", 9);
        Player sacha = new Player(2, "Саша", 7);
        Game game = new Game();

        game.register(yra);
        game.register(sacha);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Сергей", "Саша")
        );
    }

    @Test
    public void testNotRegisteredSecondPlayer() {
        Player yra = new Player(1, "Юра", 9);
        Player sacha = new Player(2, "Саша", 7);
        Game game = new Game();

        game.register(yra);
        game.register(sacha);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Юра", "Сергей")
        );
    }

}
