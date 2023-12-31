package section_16_lambda.ex4_return;

public class Person {
    public void action(Calculable calculable) {
        double result = calculable.calculate(10, 4);
        System.out.println("결과 : " + result);
    }
}
