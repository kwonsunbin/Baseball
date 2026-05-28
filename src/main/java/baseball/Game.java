package baseball;

public class Game {

    private final String answer;

    public Game() {
        this.answer = null;
    }

    public Game(String answer) {
        this.answer = answer;
    }

    public Result guess(String number) {
        if (number == null) {
            throw new IllegalArgumentException();
        }
        if (!isThreeDigits(number)) {
            throw new IllegalArgumentException();
        }
        if (!isAllDigits(number)) {
            throw new IllegalArgumentException();
        }
        if (isDuplicatedNumber(number)) {
            throw new IllegalArgumentException();
        }
        return calculateResult(number);
    }

    private Result calculateResult(String number) {
        int strikes = 0;
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (answer.charAt(i) == number.charAt(i)) {
                strikes++;
            } else if (answer.contains(String.valueOf(number.charAt(i)))) {
                balls++;
            }
        }
        return new Result(strikes, balls);
    }

    private boolean isThreeDigits(String number) {
        return number.length() == 3;
    }

    private boolean isAllDigits(String number) {
        return number.matches("[0-9]{3}");
    }

    private boolean isDuplicatedNumber(String number) {
        return number.chars().distinct().count() != number.length();
    }
}
