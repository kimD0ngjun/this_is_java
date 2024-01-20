package section_07_inheritance.ex07;

public class Child extends Parent {
    public String field2;

    @Override
    public void method2() {
        System.out.println("오버라이딩 된 부모 메소드 2");
    }

    public void method3() {
        System.out.println("자식 메소드 3");
    }
}
