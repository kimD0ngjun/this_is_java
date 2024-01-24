package section_12_base_module.ex12;

public class Service {
    @PrintAnnotation
    public void method1() {
        System.out.println("run method_1");
    }

    @PrintAnnotation("*")
    public void method2() {
        System.out.println("run method_2");
    }

    @PrintAnnotation(value = "#", number = 20) // value에 다른 속성의 값을 동시에 주고 싶으면 value 기술
    public void method3() {
        System.out.println("run method_3");
    }
}
