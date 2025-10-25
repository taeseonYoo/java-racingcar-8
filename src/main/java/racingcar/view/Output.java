package racingcar.view;

import java.util.List;

public class Output {
    private final static String WINNER_RESULT_MESSAGE = "최종 우승자 : ";
    private final static String RACE_RESULT_MESSAGE = "실행 결과";
    private final static String PRINT_WINNERS_DELIMITER = ", ";

    private Output() {
    }

    public static void printResult(List<String> winners) {
        System.out.print(WINNER_RESULT_MESSAGE);
        printWinners(winners);
    }

    private static void printWinners(List<String> winners) {
        String result = String.join(PRINT_WINNERS_DELIMITER, winners);
        System.out.print(result);
    }

    public static void printRaceResult() {
        System.out.println();
        System.out.println(RACE_RESULT_MESSAGE);
    }

    public static void printRoundResult(String roundResult) {
        System.out.println(roundResult);
    }
}
