package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputValidator;

public class Input {
    private final static String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String ATTEMPTS_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public String inputCarNames() {
        System.out.println(CAR_NAMES_MESSAGE);
        String inputCarNames = Console.readLine();
        InputValidator.validateCarNames(inputCarNames);
        return inputCarNames;
    }

    public String inputAttempts() {
        System.out.println(ATTEMPTS_MESSAGE);
        String attempts = Console.readLine();
        InputValidator.validateAttempts(attempts);
        return attempts;
    }
}
