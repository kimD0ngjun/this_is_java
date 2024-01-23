package section_12_base_module.ex03_02;

public class MainExample {
    public static void main(String[] args) {
        // 생성자
        RecordExample record = new RecordExample("winter", 30, "snow");
        RecordExample anotherRecord =
                new RecordExample("summer", 30, "ocean");

        // getter
        System.out.println(record.name());
        System.out.println(record.age());
        System.out.println(record.id());

        // 오버라이딩 메소드
        System.out.println(record.equals(anotherRecord));
        System.out.println(record.hashCode());
        System.out.println(record.toString()); // 사실 이미 println 메소드 내에서 toString() 메소드를 사용 후 리턴
    }
}
