package section_16_lambda.ex4_return;

import static java.lang.Double.sum;

public class LambdaExample {
    public static void main(String[] args) {
        Person person = new Person();

        person.action((x, y) -> {
            double result = x + y;
            return result;
        });

        person.action((x, y) -> x + y);

        person.action((x, y) -> sum(x, y));
    }
}
