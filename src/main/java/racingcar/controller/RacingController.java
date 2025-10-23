package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingController {
    public void run() {
        Input input = new Input();
        Output output = new Output();

        String carNames = input.inputCarNames();
        String attempts = input.inputAttempts();
        //자동차 이름을 분리하고 검증한다.

        //게임을 시작한다.
        output.printRaceResult();

        output.printRoundResult();
        output.printResult();
    }
}
