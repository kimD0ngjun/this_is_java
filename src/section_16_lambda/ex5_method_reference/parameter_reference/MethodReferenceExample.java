package section_16_lambda.ex5_method_reference.parameter_reference;

public class MethodReferenceExample {
    public static void main(String[] args) {
        Person person = new Person();

        person.ordering((x, y) -> x.compareToIgnoreCase(y));

        person.ordering(String::compareToIgnoreCase);
    }
}

// 좀 더 풀어서 작성하면
//
// person.ordering((a, b) -> a.compareToIgnoreCase(b))를 작성한 것과 같잖아.
// 근데 람다식을 안 썼더라면 person.ordering(Comparable 인터페이스를 implements해서 구현한 클래스의
// compare 메소드를 사용했겠지? 그 구체적인 구현을 직접 클래스로 작성하는 것이 아닌 간략화한 것이 람다식의 존재 의의고
// 근데 보니까 Person 클래스에서 구현한 ordering 메소드의 내부 내용을 보니까 result라는 Integer 타입을 이용해서
// 케이스에 따라 출력을 달리하는 기능인데, 그 result를 구하는 것은 Comparable 인터페이스의 compare 메소드를 쓰고 있는데,
// 메소드 참조에 의해서 compare 메소드가 compareToIgnoreCase를 사용하는 내용이 실질적으로 구현이 된 셈
//
// public int compare(String a, String b) {
//      return a.compareToIgnoreCase(b);
// }
//
// 이렇게 구현이 된 셈

// ordering(String::compareToIgnoreCase)에서
// String은 a의 클래스가 String이고, 참조하려는 메소드는 String 클래스에서 제공하는 compareToIgnoreCase