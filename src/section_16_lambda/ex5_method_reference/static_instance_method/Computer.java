package section_16_lambda.ex5_method_reference.static_instance_method;

public class Computer {
    // 정적 메소드
    public static double staticCalculate(double x, double y) {
        return x + y;
    }

    // 인스턴스 메소드
    public double instanceCalculate(double x, double y) {
        return x + y;
    }
}
