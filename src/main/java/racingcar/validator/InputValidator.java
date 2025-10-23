package racingcar.validator;

import java.util.regex.Pattern;

public class InputValidator {
    private final static String VALID_CAR_NAME_REGEX = "^[a-zA-Z,]*$";
    private final static String ONLY_NUMBER_REGEX = "^[1-9][0-9]*$";
    private final static String CAR_NAME_INPUT_EXCEPTION = "알파벳과 (,)만 입력해주세요.";
    private final static String ATTEMPTS_INPUT_EXCEPTION = "시도 횟수는 0 이상의 숫자만 입력 가능합니다.";

    public static void validateCarNames(String inputCarNames) {
        if (!Pattern.matches(VALID_CAR_NAME_REGEX, inputCarNames)) {
            throw new IllegalArgumentException(CAR_NAME_INPUT_EXCEPTION);
        }
    }

    public static void validateAttempts(String inputAttempts) {
        if (!Pattern.matches(ONLY_NUMBER_REGEX, inputAttempts)) {
            throw new IllegalArgumentException(ATTEMPTS_INPUT_EXCEPTION);
        }
    }
}
