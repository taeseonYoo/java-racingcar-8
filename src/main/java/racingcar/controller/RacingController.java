package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Separator;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingController {
    public static void run() {
        Input input = new Input();
        Output output = new Output();

        String inputCarNames = input.inputCarNames();
        String[] carNames = Separator.splitCarNames(inputCarNames);
        List<Car> cars = Arrays.stream(carNames)
                .map(Car::new).toList();

        String attempts = input.inputAttempts();

        //게임을 시작한다.
        output.printRaceResult();

        output.printRoundResult(cars);
//        output.printResult();
    }
}
