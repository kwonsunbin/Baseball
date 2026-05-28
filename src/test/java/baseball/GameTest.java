package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void 널_값을_입력하면_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class, () -> game.guess(null));
    }
}
