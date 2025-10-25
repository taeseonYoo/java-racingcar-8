package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputValidator;

public class Input {
    private final static String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String ROUND_MESSAGE = "시도할 횟수는 몇 회인가요?";

    private Input() {
    }

    public static String inputCarNames() {
        System.out.println(CAR_NAMES_MESSAGE);
        String inputCarNames = Console.readLine();
        InputValidator.validateCarNames(inputCarNames);
        return inputCarNames;
    }

    public static String inputRound() {
        System.out.println(ROUND_MESSAGE);
        String round = Console.readLine();
        InputValidator.validateRound(round);
        return round;
    }
}
