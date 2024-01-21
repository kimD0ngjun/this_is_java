package section_10_nested_class.ex06;

public class A {
    String field = "A_filed"; // 외부 클래스 인스턴스 필드

    // 외부 클래스 메소드
    void method() {
        System.out.println("A_method");
    }

    class B {
        String field = "B_field"; // 중첩 클래스 인스턴스 필드

        // 중첩 클래스 메소드
        void method() {
            System.out.println("B_method");
        }
    }
}
