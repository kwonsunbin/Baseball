package baseball;

public class Game {

    public void guess(String number) {
        if (number == null) {
            throw new IllegalArgumentException();
        }
        if (number.length() != 3) {
            throw new IllegalArgumentException();
        }
        if (!number.matches("[0-9]{3}")) {
            throw new IllegalArgumentException();
        }
    }
}
