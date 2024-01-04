package section_17_stream.ex03_pipeline;

import java.util.Arrays;
import java.util.List;

public class StreamPipeLineExample {
    public static void main(String[] args) {
        List<Student> list  = Arrays.asList(
                new Student("홍길동", 10),
                new Student("신용권", 20),
                new Student("유미선", 30)
        );

        // 메소드 체이닝이 파이프라인의 핵심
        double average = list.stream()
//                .mapToInt(student -> student.getScore())
                .mapToInt(Student::getScore) // 메소드 참조라서 클래스 :: 메소드
                .average()
                .getAsDouble();

        System.out.println("평균 점수 : " + average);
    }
}
