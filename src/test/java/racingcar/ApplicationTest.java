package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "taeseo,",
            ",tae"
    })
    @DisplayName("자동차 이름의 길이가 1보다 작고 5보다 크면 예외가 발생한다.")
    void 이름_길이_예외(String inputCarNames) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(inputCarNames, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "-1", "^", "가", "a",
    })
    @DisplayName("시도 횟수에 숫자가 아닌 값이 입력되면 예외가 발생한다.")
    void 예외_시도_횟수에_숫자가_아닌_값(String inputAttempts) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,jub", inputAttempts))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "-1", "0"
            , "2147483648",
            "3.141592"
    })
    @DisplayName("시도 횟수가 int 범위 내의 양의 정수가 아니면 예외가 발생한다.")
    void 예외_시도_횟수가_범위를_벗어남(String inputAttempts) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,jub", inputAttempts))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "tae,#",
            "tae,곰",
            "Tae, "
    })
    @DisplayName("경주할 자동차 이름 문자열에 알파벳 대소문자 또는 쉼표가 아닌 문자가 입력되면 예외가 발생한다.")
    void 예외_이름_문자열에_알파벳_또는_쉼표_이외의_문자(String inputCarNames) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(inputCarNames, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("모든 자동차가 출발하지 못해도, 우승자는 출력되어야 한다.")
    void 모든_자동차_STOP() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : ", "woni : ", "최종 우승자 : pobi, woni");
                },
                STOP, STOP
        );
    }

    @Test
    @DisplayName("1대의 자동차만 경주를 해도 우승자는 출력되어야 한다.")
    void 자동차_단독_경주() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "1");
                    assertThat(output()).contains("pobi : ", "최종 우승자 : pobi");
                },
                STOP
        );
    }

    @Test
    @DisplayName("같은 position 만큼 움직이면, 공동 우승자를 출력한다.")
    void 공동_우승자_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : --", "woni : --", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("시도 횟수만큼 라운드가 진행되는 지 확인한다.")
    void 라운드_횟수_확인() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "3");
                    assertThat(output().split("pobi : ").length)
                            .isEqualTo(3 + 1);
                },
                MOVING_FORWARD,
                MOVING_FORWARD,
                MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("중복 이름을 가진 자동차 이름이 주어질 수 있다.")
    void 중복_이름_자동차_공동_우승() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,pobi", "1");
                    assertThat(output()).contains("최종 우승자 : pobi, pobi");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("중복 이름을 가진 자동차 이름이 주어질 수 있다.")
    void 중복_이름_자동차_단독_우승() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,pobi", "1");
                    assertThat(output()).contains("최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
