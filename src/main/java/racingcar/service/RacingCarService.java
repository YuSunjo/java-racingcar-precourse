package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarList;
import racingcar.messenger.ValidationUtils;

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
        for (RacingCar car : racingCar.getRacingCarList()) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            car.movePosition(ValidationUtils.validateGo(randomNum));
        }
    }

    public int getMaxPosition(RacingCarList racingCar) {
        int maxPosition = 0;
        for (RacingCar car : racingCar.getRacingCarList()) {
            if (maxPosition < car.getPosition()) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    public List<String> getWinner(RacingCarList racingCar, int maxPosition) {
        List<String> winnerList = new ArrayList<>();
        for (RacingCar car : racingCar.getRacingCarList()) {
            if (maxPosition == car.getPosition()) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

}
