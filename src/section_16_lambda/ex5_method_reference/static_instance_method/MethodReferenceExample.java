package section_16_lambda.ex5_method_reference.static_instance_method;

public class MethodReferenceExample {
    public static void main(String[] args) {
        Person person = new Person();

        // 컴퓨터 클래스에 선언된 두 메소드를 람다식에 써먹을 거임
        // 정적 메소드일 경우의 람다식
        person.action((x, y) -> Computer.staticCalculate(x, y));

        person.action(Computer::staticCalculate);
        // 핵심은 이제까지 일일이 적던 람다식을 다른 곳에 이미 선언된 메소드 내용을 참조하는 식

        // 인스턴스 메소드일 경우의 람다식
        Computer computer = new Computer();

        person.action((x, y) -> computer.instanceCalculate(x, y));

        person.action(computer::instanceCalculate);
        // 정적 메소드는 클래스명을 땡땡이 앞에 붙이지만, 인스턴스 메소드는 참조 변수를 땡땡이 앞에 붙임
    }
}
