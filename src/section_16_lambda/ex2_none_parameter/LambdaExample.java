package section_16_lambda.ex2_none_parameter;

public class LambdaExample {
    public static void main(String[] args) {
        Person person = new Person();

        person.action(() -> {
            System.out.println("출근함");
            System.out.println("프로그래밍 함");
        });

        person.action(() -> System.out.println("퇴근함"));
        // 실행문이 한 개면, 중괄호 생략 가능
    }
}

// person : 인스턴스 객체
// person.action(Workable workable) : 인스턴스 객체의 메소드, 인자는 Workable 인터페이스
// person.action(() -> System.out.println("퇴근함"));
// 실제로는 workable에 있는 work()를 구체적으로 구현할 걸, 람다식으로 구현
