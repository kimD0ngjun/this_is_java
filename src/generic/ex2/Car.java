package generic.ex2;

public class Car {
    private String car;

    public Car(String car) {
        this.car = car;
    }

    public void run() {
        int code = hashCode();
        System.out.println("사실 이 차의 이름은 " + car + "입니다.");
        System.out.println(code + " 차가 달립니다.");
    }

    @Override
    public int hashCode() {
        return car.hashCode();
    }
}
