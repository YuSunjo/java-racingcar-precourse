package racingcar.domain;

public class RacingCar {

    private final String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void movePosition(int go) {
        this.position += go;
    }

}
