package section_16_lambda.ex1_what_is_lambda_expression;

// 람다식은 사칙연산 기호의 느낌으로 체득하자
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

    // action 메소드 블록 공간이 데이터 처리부
    public static void action(Calculable calculable) {
        int x = 10; // 덩그러니 놓여진 데이터
        int y = 4; // 덩그러니 놓여진 데이터
        calculable.calculate(x, y); // 그리고 제공된 데이터 처리 목적 함수
    } // Wow! 함수형 프로그래밍
}
