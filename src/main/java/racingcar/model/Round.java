package racingcar.model;

public class Round {
    private final static String ROUND_RANGE_EXCEPTION = "시도 횟수는 int 범위 내의 양의 정수를 입력해야 합니다.";
    private final int round;

    public Round(String round) {
        this.round = setRound(round);
    }

    public int getRound() {
        return round;
    }

    private int setRound(String round) {
        try {
            return Integer.parseInt(round);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ROUND_RANGE_EXCEPTION);
        }
    }
}
