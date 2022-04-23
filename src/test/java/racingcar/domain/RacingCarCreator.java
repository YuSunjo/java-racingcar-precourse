package racingcar.domain;

public class RacingCarCreator {

    public static RacingCar create(String name, int position) {
        return RacingCar.testInstance(name, position);
    }

}
