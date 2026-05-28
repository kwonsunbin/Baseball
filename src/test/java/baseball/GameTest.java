package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void 자릿수가_초과된_입력이면_예외가_발생한다() {
        assertIllegalArgument(() -> game.guess("1234"));
    }

    @Test
    void 숫자가_아닌_문자가_포함된_입력이면_예외가_발생한다() {
        assertIllegalArgument(() -> game.guess("12s"));
    }

    @Test
    void 중복된_숫자가_포함된_입력이면_예외가_발생한다() {
        assertIllegalArgument(() -> game.guess("122"));
    }

    @Test
    void 정답과_완전히_일치하면_3스트라이크를_반환한다() {
        Game game = new Game("123");
        Result result = game.guess("123");
        assertThat(result.strikes()).isEqualTo(3);
        assertThat(result.balls()).isEqualTo(0);
    }

    @Test
    void 숫자는_맞지만_위치가_모두_다르면_3볼을_반환한다() {
        Game game = new Game("123");
        Result result = game.guess("231");
        assertThat(result.strikes()).isEqualTo(0);
        assertThat(result.balls()).isEqualTo(3);
    }

    @Test
    void 하나만_위치가_같으면_1스트라이크를_반환한다() {
        Game game = new Game("123");
        Result result = game.guess("145");
        assertThat(result.strikes()).isEqualTo(1);
        assertThat(result.balls()).isEqualTo(0);
    }

    @Test
    void 하나는_위치가_같고_하나는_숫자만_맞으면_1스트라이크_1볼을_반환한다() {
        Game game = new Game("123");
        Result result = game.guess("132");
        assertThat(result.strikes()).isEqualTo(1);
        assertThat(result.balls()).isEqualTo(2);
    }

    @Test
    void 아무것도_맞지_않으면_0스트라이크_0볼을_반환한다() {
        Game game = new Game("123");
        Result result = game.guess("456");
        assertThat(result.strikes()).isEqualTo(0);
        assertThat(result.balls()).isEqualTo(0);
    }

    private void assertIllegalArgument(Executable executable) {
        assertThrows(IllegalArgumentException.class, executable);
    }
}
