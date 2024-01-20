package section_09_class_object;

public class Nested {

    public Nested() {
        class Local2 {
            //TODO : 생성자 내부에도 로컬 클래스 선언 가능
        }
    }

    //TODO : 인스턴스 멤버 클래스
    class Member1 {
        // 인스턴스 멤버 클래스니까 Nested 객체 생성해야 member1 객체 생성 가능
        int field1 = 1;

        static int field2 = 2; // Java 17부터 가능

        Member1() {
            System.out.println("Member1 생성자 실행");
        }

        void method1() {
            System.out.println("내부 인스턴스 메소드 실행");
        }

        static void method2() {
            System.out.println("내부 정적 메소드 실행");
        }
    }

    //TODO : 정적 멤버 클래스
    static class Member2 {
        // 정적 멤버 클래싀까 Nested 객체 생성하지 않아도 member2 객체 생성 가능
    }

    void method() {
        //TODO: 로컬 클래스
        class Local {
            // 우선 정적 메소드 아니니까, Nested 객체부터 생성해야 됨
            // 그래야 method 메소드 사용 가능한데, 그제서야 local 객체 생성 가능
        }

        Member1 member1 = new Member1();
        System.out.println(member1.field1);
        member1.method1();

        System.out.println(Member1.field2);
        Member1.method2();

        String somethihng;
    }
}
