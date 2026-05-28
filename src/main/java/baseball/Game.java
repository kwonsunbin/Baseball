package baseball;

public class Game {

    public void guess(String number) {
        if (number == null) {
            throw new IllegalArgumentException();
        }
    }
}
