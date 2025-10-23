package racingcar.model;

public class Separator {
    private final static String SEPARATOR = ",";

    public static String[] splitCarNames(String carNames) {
        return carNames.split(SEPARATOR);
    }
}
