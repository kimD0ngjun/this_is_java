package section_16_lambda.ex5_method_reference.static_instance_method;

import section_16_lambda.ex4_return.Calculable;

public class Person {
    public void action(Calculable calculable) {
        double result = calculable.calculate(10,4);
        System.out.println("결과 : " + result);
    }
}
