## java-racingcar-precourse

### 자동차 경주

--- 

## 기능 요구사항

--- 

### 입력

- [ ]  경주할 자동차 이름을 입력받는다.
- [ ]  시도 횟수를 입력받는다.
- [ ]  자동차 이름은 쉼표(,)를 기준으로 구분하며 최소 2대 이상 입력된다.
- [ ]  시도 횟수는 int 범위 안의 양의 정수이다. (1~2,147,483,647 )

### 자동차

- [ ]  자동차 이름은 5자 이하이다.
- [ ]  자동차 이름은 알파벳으로만 구성된다.
- [ ]  0-9 사이의 무작위 값이 4 이상일 경우 자동차는 전진한다.
- [ ]  0-9 사이의 무작위 값이 4 미만일 경우 자동차는 정지한다.

### 레이싱

- [ ]  주어진 시도 횟수만큼 레이싱을 진행한다.
- [ ]  랜덤한 값을 생성한다.

### 출력

- [ ]  차수별 실행 결과를 출력한다.
- [ ]  단독, 공동 우승자 안내 문구를 출력한다.
- [ ]  차수별 실행 결과는 입력받은 순서대로 출력한다.

### 예외 조건

> 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨다.

- [ ] 자동차 이름의 길이가 5보다 큰 경우
- [ ] 자동차가 2대 이상 주어지지 않은 경우
- [ ] 자동차의 이름에 알파벳이 아닌 문자가 입력되는 경우
- [ ] 모든 자동차가 출발지점에서 출발하지 못하는 경우

## 프로그래밍 요구 사항 1

--- 
- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 Application의 main()이다.
- build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 System.exit()를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 Java Style Guide를 원칙으로 한다.

## 프로그래밍 요구 사항 2

---
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다. 
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
  - 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.

## 라이브러리
- camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
  - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
  - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

## Commit Convention

--- 

예시

~~~
feat(Input): 사용자의 입력 구현
~~~

- feat (feature)
- fix (bug fix)
- docs (documentation)
- style (formatting, missing semi colons, …)
- refactor
- test (when adding missing tests)
- chore (maintain)