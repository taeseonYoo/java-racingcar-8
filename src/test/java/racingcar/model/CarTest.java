package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("4이상의 값이 입력되면 자동차는 직진해야한다.")
    void 자동차_출발() {
        //given
        Car car = new Car("tae");
        //when
        car.work(MOVING_FORWARD);
        //then
        Assertions.assertThat(car.getRoundResult()
                        .chars().filter(ch -> ch == '-').count())
                .isEqualTo(1);
    }

    @Test
    @DisplayName("4미만의 값이 입력되면 자동차는 정지해야한다.")
    void 자동차_정지() {
        //given
        Car car = new Car("tae");
        //when
        car.work(STOP);
        //then
        Assertions.assertThat(car.getRoundResult()
                        .chars().filter(ch -> ch == '-').count())
                .isEqualTo(0);
    }

    @Test
    @DisplayName("라운드 결과에는 이름이 포함되어야 한다.")
    void 라운드_결과() {
        //given
        Car car = new Car("tae");
        //when
        String roundResult = car.getRoundResult();
        //then
        Assertions.assertThat(roundResult.contains("tae")).isTrue();
    }

    @Test
    @DisplayName("자동차는 position 으로 내림차순 정렬되어야 한다.")
    void 자동차_정렬_순서() {
        //given
        List<Car> cars = new ArrayList<>();
        Car winner = new Car("win");
        winner.work(MOVING_FORWARD);
        Car loser = new Car("lose");
        loser.work(STOP);
        cars.add(loser);
        cars.add(winner);
        //when
        Collections.sort(cars);
        //then
        Assertions.assertThat(cars.get(0).getName())
                .isEqualTo("win");
    }

}