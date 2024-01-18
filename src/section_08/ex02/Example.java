package section_08.ex02;

public class Example {
    public static void main(String[] args) {
        System.out.println(ExampleInterface.constantFiled);
        ExampleInterface.staticPublicMethod();
        System.out.println();

        ExampleInterface example = new Child();
        example.abstractMethod();
        example.defaultMethod();
    }
}
