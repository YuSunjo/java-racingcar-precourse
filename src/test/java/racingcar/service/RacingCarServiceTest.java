package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarList;
import racingcar.domain.RacingCarListCreator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingCarServiceTest {

    private final RacingCarService racingCarService = new RacingCarService();

    @DisplayName("입력받은 이름들로 레이싱카를 생성해준다.")
    @Test
    void createRacingCar() {
        // given
        List<String> nameList = Arrays.asList("pobi", "sun", "jo");

        // when
        RacingCarList racingCar = racingCarService.createRacingCar(nameList);

        // then
        List<RacingCar> racingCarList = racingCar.getRacingCarList();
        assertThat(racingCarList).hasSize(3);
        assertRacingCar(racingCarList, nameList);
    }

    @DisplayName("레이싱카를 움직인다. - initPosition 보다 크거나 같다.")
    @Test
    void racingCarMove() {
        // given
        int minPosition = 3;
        int maxPosition = 5;
        RacingCarList racingCar = RacingCarListCreator.create(minPosition, maxPosition);

        // when
        racingCarService.racingCarMove(racingCar);

        // then
        List<RacingCar> racingCarList = racingCar.getRacingCarList();
        assertRacingCar(racingCarList, minPosition);
    }

    @DisplayName("레이싱카중에서 위치가 제일 큰 값을 찾는다. - 레이싱카가 모두 다른 위치일 경우")
    @Test
    void racingCarMaxPosition_1() {
        // given
        int minPosition = 3;
        int maxPosition = 5;
        RacingCarList racingCar = RacingCarListCreator.create(minPosition, maxPosition);

        // when
        int maxPositionCar = racingCarService.racingCarMaxPosition(racingCar);

        // then
        assertThat(maxPositionCar).isEqualTo(racingCar.getRacingCarList().get(2).getPosition());
    }

    @DisplayName("위치가 제일 큰 레이싱카의 이름 리스트를 찾는다. - 위치가 제일 큰 레이싱카가 하나일 경우")
    @Test
    void racingCarWinner_1() {
        // given
        int minPosition = 3;
        int maxPosition = 5;
        RacingCarList racingCar = RacingCarListCreator.create(minPosition, maxPosition);

        // when
        List<String> nameList = racingCarService.racingCarWinner(racingCar, maxPosition);

        // then
        assertThat(nameList).hasSize(1);
        assertThat(nameList.get(0)).isEqualTo(racingCar.getRacingCarList().get(2).getName());
    }

    @DisplayName("위치가 제일 큰 레이싱카의 이름 리스트를 찾는다. - 위치가 제일 큰 레이싱카가 하나이상일 경우")
    @Test
    void racingCarWinner_2() {
        // given
        int minPosition = 3;
        int maxPosition = 7;
        RacingCar pobi = RacingCar.testInstance("pobi", minPosition);
        RacingCar sun = RacingCar.testInstance("sun", maxPosition);
        RacingCar jo = RacingCar.testInstance("jo", maxPosition);
        RacingCarList racingCar = RacingCarList.testInstance(Arrays.asList(pobi, sun, jo));

        // when
        List<String> nameList = racingCarService.racingCarWinner(racingCar, maxPosition);

        // then
        assertThat(nameList).hasSize(2);
        assertThat(nameList.get(0)).isEqualTo(sun.getName());
        assertThat(nameList.get(1)).isEqualTo(jo.getName());
    }

    private void assertRacingCar(List<RacingCar> racingCarList, List<String> nameList) {
        for (int i = 0; i < racingCarList.size(); i++) {
            assertThat(racingCarList.get(i).getName()).isEqualTo(nameList.get(i));
        }
    }

    private void assertRacingCar(List<RacingCar> racingCarList, int initPosition) {
        for (RacingCar racingCar : racingCarList) {
            assertThat(racingCar.getPosition()).isGreaterThanOrEqualTo(initPosition);
        }
    }

}
