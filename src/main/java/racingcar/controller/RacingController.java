package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Separator;
import racingcar.validator.InputValidator;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingController {
    public static void run() {
        Input input = new Input();
        Output output = new Output();

        List<Car> cars = settingCars(input.inputCarNames());
        int attempts = settingAttempts(input.inputAttempts());

        output.printRaceResult();
        for (int i = 0; i < attempts; i++) {
            for (int j = 0; j < cars.size(); j++) {
                int randomNum = Randoms.pickNumberInRange(0, 9);
                cars.get(j).work(randomNum);
            }
            output.printRoundResult(cars);
        }
        //게임 끝 승자를 집계한다.
        List<Car> winners = new ArrayList<>();
        cars.sort(Car::compareTo);
//        output.printResult();
    }

    private static List<Car> settingCars(String inputCarNames) {
        InputValidator.validateCarNames(inputCarNames);
        String[] carNames = Separator.splitCarNames(inputCarNames);
        return Arrays.stream(carNames)
                .map(Car::new).toList();
    }

    private static int settingAttempts(String inputAttempts) {
        try {
            int attempts = Integer.parseInt(inputAttempts);
            InputValidator.validateAttempts(attempts);
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 int 범위 안의 양의 정수를 입력해야 합니다.");
        }
    }

}
