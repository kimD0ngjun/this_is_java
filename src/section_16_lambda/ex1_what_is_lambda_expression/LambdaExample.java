package section_16_lambda.ex1_what_is_lambda_expression;

public class LambdaExample {
    public static void main(String[] args) {
        action((x, y) -> {
            int result = x + y;
            System.out.println("result : " + result);
        }); // action()은 데이터 처리부, 내부는 람다식

        action((x, y) -> {
            int result = x - y;
            System.out.println("result : " + result);
        }); // 얘도 마찬가지
    }

    public static void action(Calculable calculable) {
        int x = 10;
        int y = 4;
        calculable.calculate(x, y);
    }
}
