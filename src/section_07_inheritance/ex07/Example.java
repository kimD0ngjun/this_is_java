package section_07_inheritance.ex07;

public class Example {
    public static void main(String[] args) {
        Parent p = new Child();
        p.method1();
        p.method2();
//        p.method3();

        Child c = (Child) p;
        c.method3();
    }
}
