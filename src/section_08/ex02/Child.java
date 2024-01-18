package section_08.ex02;

public class Child implements ExampleInterface {
    @Override
    public void abstractMethod() {
        System.out.println("구현체에서 실행");
    }
}
