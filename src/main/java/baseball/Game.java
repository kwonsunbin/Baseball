package baseball;

public class Game {

    public void guess(String number) {
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
