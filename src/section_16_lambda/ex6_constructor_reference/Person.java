package section_16_lambda.ex6_constructor_reference;

public class Person {
    public Member getMember1(Creatable1 creatable1) {
        String id = "winter";
        return creatable1.create(id); // 어차피 create 메소드의 반환값 타입이 Member임
//        return member;
    } // 이제 실질적으로 어떻게 생성하는 지에 대해서는 람다식을 통해 구현해야 함수형 인터페이스를 실질 구현했다고 봄

    public Member getMember2(Creatable2 creatable2) {
        String id = "winter";
        String name = "한겨울";
        return creatable2.create(id, name);
    }
}
