package racingcar.domain;

public class RacingCar {

    private final String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
    }

    public RacingCar(String name, int position) {
        this.name = name;
        this.position = position;
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

    public static RacingCar of(String name) {
        return new RacingCar(name);
    }

    public static RacingCar testInstance(String name, int position) {
        return new RacingCar(name, position);
    }

}
