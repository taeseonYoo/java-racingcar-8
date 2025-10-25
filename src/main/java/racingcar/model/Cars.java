package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int RANDOM_MIN_NUMBER = 0;
    private static final int RANDOM_MAX_NUMBER = 9;
    private static final int SAME_POSITION = 0;
    private List<Car> cars;

    public Cars(String inputCarNames) {
        this.cars = createCars(inputCarNames);
    }

    private List<Car> createCars(String inputCarNames) {
        String[] carNames = Separator.splitCarNames(inputCarNames);

        return Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public String play() {
        StringBuilder roundResult = new StringBuilder();
        for (Car car : cars) {
            int random = Randoms.pickNumberInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER);
            car.work(random);
            roundResult.append(car.getRoundResult()).append("\n");
        }
        return roundResult.toString();
    }

    public List<String> aggregateWinners() {
        Car maxResultCar = findMaxPositionCar();
        return cars.stream()
                .filter(car -> car.compareTo(maxResultCar) == SAME_POSITION)
                .map(Car::getName)
                .toList();
    }

    private Car findMaxPositionCar() {
        Collections.sort(cars);
        return cars.getFirst();
    }

}
