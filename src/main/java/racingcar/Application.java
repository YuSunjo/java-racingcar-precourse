package racingcar;

import racingcar.config.AppConfig;
import racingcar.controller.RacingCarController;
import racingcar.messenger.CarMessengerService;
import racingcar.service.RacingCarFacade;
import racingcar.service.RacingCarService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();

        RacingCarController racingCarController = appConfig.racingCarController();
        racingCarController.racingStart();
    }
}
