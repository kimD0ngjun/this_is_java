package section_12_base_module.ex03_02;

public record RecordExample(String name, int age, String id) {
}

// 레코드의 역할
// private final로 String name, int age, String id 변수 선언
// 각 필드에 대한 생성자, getter 메소드
// hashCode(), equals(Object obj), toString() 메소드 재정의

// 레코드는 주로 DTO 생성에서 많이 쓰인다고 한다...