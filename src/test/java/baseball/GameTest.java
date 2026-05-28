package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void 널_값을_입력하면_예외가_발생한다() {
        assertIllegalArgument(() -> game.guess(null));
    }

    @Test
    void 세_자리가_아닌_입력이면_예외가_발생한다() {
        assertIllegalArgument(() -> game.guess("12"));
    }

    private void assertIllegalArgument(Executable executable) {
        assertThrows(IllegalArgumentException.class, executable);
    }
}
