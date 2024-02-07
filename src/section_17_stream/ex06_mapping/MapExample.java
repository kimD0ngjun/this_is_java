package section_17_stream.ex06_mapping;

import java.util.ArrayList;
import java.util.List;

public class MapExample {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("홍길동", 85));
        studentList.add(new Student("홍길동", 92));
        studentList.add(new Student("홍길동", 87));

        studentList.stream().mapToInt(Student::getScore)
                .forEach(System.out::println); // Student 스트림을 score 스트림으로 변환
    }
}
