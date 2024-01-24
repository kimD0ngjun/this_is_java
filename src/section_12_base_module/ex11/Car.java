package section_12_base_module.ex11;

import java.util.Objects;

public class Car {
    private String carName;
    private int price;
    private String driver;
    private int velocity;

    // 필드를 초기화하는 생성자
    public Car(String carName, int price, String driver, int velocity) {
        this.carName = carName;
        this.price = price;
        this.driver = driver;
        this.velocity = velocity;
    }

    // 매개변수 없는 생성자
    public Car() {
        // 기본적으로 아무 동작도 하지 않음
    }

    // Getter 메소드들
    public String getCarName() {
        return carName;
    }

    public int getPrice() {
        return price;
    }

    public String getDriver() {
        return driver;
    }

    public int getVelocity() {
        return velocity;
    }

    // Setter 메소드들
    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return price == car.price && velocity == car.velocity && Objects.equals(carName, car.carName) && Objects.equals(driver, car.driver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, price, driver, velocity);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", price=" + price +
                ", driver='" + driver + '\'' +
                ", velocity=" + velocity +
                '}';
    }
}
