package section_10_nested_class.ex06;

public class A {
    String field = "A_field"; // 외부 클래스 인스턴스 필드

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

        void innerPrint() {
            System.out.println(this.field);
            this.method();
        }

        void outerPrint() {
            System.out.println(A.this.field);
            A.this.method();
        }
    }

    void useBInnerPrint() {
        B b = new B();
        b.innerPrint();
    }

    void userBOuterPrint() {
        B b = new B();
        b.outerPrint();
    }
}
