package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.messenger.CarMessengerService;
import racingcar.service.RacingCarFacade;
import racingcar.service.RacingCarService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarMessengerService carMessengerService = new CarMessengerService();
        RacingCarService racingCarService = new RacingCarService();
        RacingCarFacade racingCarFacade = new RacingCarFacade(carMessengerService, racingCarService);
        RacingCarController racingCarController = new RacingCarController(racingCarFacade);

        racingCarController.racingStart();
    }
}
