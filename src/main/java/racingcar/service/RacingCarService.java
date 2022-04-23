package racingcar.service;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarList;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {

    public RacingCarList createRacingCar(List<String> carList) {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (String name : carList) {
            racingCarList.add(new RacingCar(name));
        }
        return RacingCarList.of(racingCarList);
    }

    public void racingCarMove(RacingCarList racingCar) {
        racingCar.racingCarMove();
    }

    public int racingCarMaxPosition(RacingCarList racingCar) {
        return racingCar.racingCarMaxPosition();
    }

    public List<String> racingCarWinner(RacingCarList racingCar, int maxPosition) {
        return racingCar.racingCarWinner(maxPosition);
    }

}
