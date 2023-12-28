package section_13_generic.ex2;

public class CarAgency implements Rentable<Car> {
    @Override
    public Car rent(String carName) {
        return new Car(carName);
    }
}
