package section_9;

import section_9.Nested.Member2;

public class Main {
    public static void main(String[] args) {
//        Nested nested = new Nested();
//        Nested.Member1 member1 = nested.new Member1();
//
//        nested.method();
//        member1.method1();
//
//        // 정적 멤버 클래스는 바깥 클래스 객체 생성 불필요
//        Nested.Member2 member2 = new Nested.Member2();

        Nested2 nested2 = new Nested2();
        nested2.useInnerClass();
    }
}
