package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.model.Round;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingController {
    public static void run() {
        Cars cars = new Cars(Input.inputCarNames());
        Round round = new Round(Input.inputRound());

        Cars finishedCars = play(cars, round);

        List<String> winnerNames = finishedCars.aggregateWinners();
        Output.printResult(winnerNames);
    }

    private static Cars play(Cars cars, Round round) {
        Output.printRaceResult();
        for (int i = 0; i < round.getRound(); i++) {
            String roundResult = cars.play();
            Output.printRoundResult(roundResult);
        }
        return cars;
    }

}
