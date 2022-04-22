package racingcar.domain;

import java.util.List;

public class RacingCarList {

    private final List<RacingCar> racingCarList;

    public RacingCarList(List<RacingCar> racingCarList) {
        this.racingCarList = racingCarList;
    }

    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }

    public static RacingCarList of(List<RacingCar> racingCarList) {
        return new RacingCarList(racingCarList);
    }

}
