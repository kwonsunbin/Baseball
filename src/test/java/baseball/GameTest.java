package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    @Test
    void 널_값을_입력하면_예외가_발생한다() {
        Game game = new Game();

        assertThrows(IllegalArgumentException.class, () -> game.guess(null));
    }
}
