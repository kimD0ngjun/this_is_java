package section_12_base_module;

public class RecordExample {
    public static void main(String[] args) {
        Member m = new Member("winter", "눈송이", 25);
        System.out.println(m.id());
        System.out.println(m.name());
        System.out.println(m.age());
        System.out.println(m.toString());
        // 사실 println 메서드가 전달된 객체에 대해 자동으로 toString() 메서드를 호출하기 때문에 호출할 필요 x
        System.out.println();

        Member m1 = new Member("winter", "눈송이", 25);
        Member m2 = new Member("winter", "눈송이", 25);

        System.out.println("m1.hashCode : " + m1.hashCode());
        System.out.println("m2.hashCode : " + m2.hashCode());
        System.out.println("m1.equals(m2) : " + m1.equals(m2));;
    }
}
