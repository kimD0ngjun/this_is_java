package section_16_lambda.ex6_constructor_reference;

public class ConstructorReferenceExample {
    public static void main(String[] args) {
        Person person = new Person();

        Member member1 = person.getMember1(Member::new);
        System.out.println(member1); // 오버라이딩한 toString() 메소드가 자동으로 호출

        System.out.println();

        Member member2 = person.getMember2(Member::new);
        System.out.println(member2);
    }
}
