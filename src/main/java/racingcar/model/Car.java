package racingcar.model;

public class Car implements Comparable<Car> {
    private final static String POSITION_MARKER = "-";
    private final static String COLON = " : ";
    private final static int INIT_POSITION_NUMBER = 0;
    private final static int STRAIGHT_STANDARD_NUMBER = 4;
    private final static int LIMIT_NAME_LENGTH = 5;
    private final static String NAME_RANGE_EXCEPTION = "자동차 이름은 1자리 이상 5자리 이하만 가능합니다. 현재 길이 : ";
    private final String name;
    private int position;

    public Car(String name) {
        verifyCarName(name);
        this.name = name;
        this.position = INIT_POSITION_NUMBER;
    }

    public String getName() {
        return name;
    }

    private void verifyCarName(String name) {
        if (name.isEmpty() || name.length() > LIMIT_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_RANGE_EXCEPTION + name.length());
        }
    }

    public void work(int number) {
        if (verifyStraightPossible(number)) {
            position++;
        }
    }

    private boolean verifyStraightPossible(int number) {
        return number >= STRAIGHT_STANDARD_NUMBER;
    }

    public String getRoundResult() {
        return name + COLON + POSITION_MARKER.repeat(position);
    }

    @Override
    public int compareTo(Car otherCar) {
        return Integer.compare(otherCar.position, this.position);
    }
}
