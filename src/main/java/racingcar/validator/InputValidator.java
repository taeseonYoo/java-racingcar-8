package racingcar.validator;

import java.util.regex.Pattern;

public class InputValidator {
    private final static String VALID_REGEX = "^[a-zA-Z,]*$";

    public static void validateCarNames(String inputCarNames) {
        if (!Pattern.matches(VALID_REGEX, inputCarNames)) {
            throw new IllegalArgumentException("알파벳과 (,)만 입력해주세요");
        }
    }

    public static void validateAttempts(int attempts) {
        if (attempts < 1) {
            throw new IllegalArgumentException("시도 횟수는 최소 1보다 큰 숫자여야합니다.");
        }
    }
}
