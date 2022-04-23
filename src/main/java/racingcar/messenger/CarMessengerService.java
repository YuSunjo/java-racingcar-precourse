package racingcar.messenger;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarList;

import java.util.Arrays;
import java.util.List;

public class CarMessengerService {

    public List<String> inputCarList() {
        while (true) {
            try {
                String carString = this.input();
                String removeBlankCarString = carString.replace(" ", "");
                List<String> carList = Arrays.asList(removeBlankCarString.split(","));
                ValidationUtils.validateNameLength(carList);
                return carList;
            } catch (IllegalArgumentException e) {
                this.printMessage(ErrorMessage.ERROR.getMessage());
            }
        }
    }

    public int inputMoveNum() {
        while (true) {
            try {
                String moveNum = this.input();
                ValidationUtils.validateMoveNum(moveNum);
                return Integer.parseInt(moveNum);
            } catch (IllegalArgumentException e) {
                this.printMessage(ErrorMessage.ERROR.getMessage());
            }
        }
    }

    private String input() {
        return Console.readLine();
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    private void printMessage(String name, int position) {
        StringBuilder repeat = new StringBuilder();
        for (int i = 0; i < position; i++) {
            repeat.append("-");
        }
        System.out.printf(PrintMessage.CAR_STATUS.getMessage() + "%n", name, repeat);
    }

    public void printRacingCarStatus(RacingCarList racingCar) {
        for (RacingCar car : racingCar.getRacingCarList()) {
            this.printMessage(car.getName(), car.getPosition());
        }
        this.printMessage("--------------------------");
    }

    public void printWinner(List<String> winnerList) {
        StringBuilder printWinner = new StringBuilder();
        for (String winner : winnerList) {
            printWinner.append(winner).append(",");
        }
        this.printMessage(String.format(PrintMessage.WINNER.getMessage(), printWinner));
    }

}
