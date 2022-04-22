package racingcar.messenger;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarList;

import java.util.Arrays;
import java.util.List;

public class CarMessengerService {

    public List<String> inputCarList() {
        do {
            try {
                String carString = this.input();
                String removeBlankCarString = carString.replace(" ", "");
                List<String> carList = Arrays.asList(removeBlankCarString.split(","));
                ValidationUtils.validateNameLength(carList);
                return carList;
            } catch (IllegalArgumentException e) {
                this.printMessage(ErrorMessage.ERROR.getMessage());
            }
        } while (true);
    }

    public int inputMoveNum() {
        do {
            try {
                String moveNum = this.input();
                ValidationUtils.validateMoveNum(moveNum);
                return Integer.parseInt(moveNum);
            } catch (IllegalArgumentException e) {
                this.printMessage(ErrorMessage.ERROR.getMessage());
            }
        } while (true);
    }

    private String input() {
        return Console.readLine();
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    private void printMessage(String name, int position) {
        String repeat = "";
        for (int i = 0; i < position; i++) {
            repeat += "-";
        }
        System.out.printf("%s : %s%n", name, repeat);
    }

    public void printRacingCarStatus(RacingCarList racingCar) {
        for (RacingCar car : racingCar.getRacingCarList()) {
            this.printMessage(car.getName(), car.getPosition());
        }
        this.printMessage("--------------------------");
    }

    public void printWinner(List<String> winnerList) {
        String printWinner = "";
        for (String winner : winnerList) {
            printWinner += winner + ",";
        }
        printMessage(String.format("최종 우승자: %s", printWinner));
    }

}
