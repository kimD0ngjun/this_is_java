package section_13_generic.ex1;

public class GenericExample {
    public static void main(String[] args) {
        Product<Tv, String> product1 = new Product<>();

        product1.setKind(new Tv());
        product1.setModel("스마트 티비");

        Tv tv = product1.getKind();
        String tvModel = product1.getModel();

        Product<Car, String> product2 = new Product<>();

        product2.setKind(new Car());
        product2.setModel("람보르기니");

        Car car = product2.getKind();
        String carModel = product2.getModel();

        System.out.println("티비 종류 : " + tv.toString());
        System.out.println("티비 모델 : " + tvModel);

        System.out.println("자동차 종류 : " + car.toString());
        System.out.println("자동차 모델 : " + carModel);
    }
}
