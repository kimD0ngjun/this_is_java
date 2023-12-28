package generic.ex2;

public class GenericExample {
    public static void main(String[] args) {
        HomeAgency homeAgency = new HomeAgency();
        Home home = homeAgency.rent("반포 자이");
        home.turnOnLight();

        CarAgency carAgency = new CarAgency();
        Car car = carAgency.rent("람보르기니");
        car.run();
    }
}
