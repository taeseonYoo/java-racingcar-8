package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
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
        //게임 끝 승자를 집계한
        List<String> winnerNames = aggregateWinners(cars);

        output.printResult(winnerNames);
    }

    private static List<Car> settingCars(String inputCarNames) {
        InputValidator.validateCarNames(inputCarNames);
        String[] carNames = Separator.splitCarNames(inputCarNames);
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
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

    private static List<String> aggregateWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        Collections.sort(cars);
        Car maxResultCar = cars.getFirst();
        winners.add(maxResultCar.getName());
        for (int i = 1; i < cars.size(); i++) {
            if (maxResultCar.compareTo(cars.get(i)) == 0) {
                winners.add(cars.get(i).getName());
            } else if (maxResultCar.compareTo(cars.get(i)) != 0) {
                break;
            }
        }
        return winners;
    }

}
