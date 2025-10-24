package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Separator;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingController {
    private final static String ATTEMPTS_RANGE_EXCEPTION = "시도 횟수는 int 범위 내의 양의 정수를 입력해야 합니다.";
    public static void run() {
        List<Car> cars = settingCars(Input.inputCarNames());
        int attempts = settingAttempts(Input.inputAttempts());

        List<Car> finishedCars = play(cars, attempts);
        List<String> winnerNames = aggregateWinners(finishedCars);
        Output.printResult(winnerNames);
    }

    private static List<Car> play(List<Car> cars, int attempts) {
        Output.printRaceResult();
        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                int randomNum = Randoms.pickNumberInRange(0, 9);
                car.work(randomNum);
            }
            Output.printRoundResult(cars);
        }
        return cars;
    }

    private static List<Car> settingCars(String inputCarNames) {
        String[] carNames = Separator.splitCarNames(inputCarNames);
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private static int settingAttempts(String inputAttempts) {
        try {
            return Integer.parseInt(inputAttempts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ATTEMPTS_RANGE_EXCEPTION);
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
