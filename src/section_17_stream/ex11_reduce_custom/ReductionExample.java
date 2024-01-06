package section_17_stream.ex11_reduce_custom;

import java.util.Arrays;
import java.util.List;

public class ReductionExample {
    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(
                new Student("홍길동", 92),
                new Student("신마니", 95),
                new Student("감자칩", 88)
        );

        // 흔한 기본 집계
        int sum1 = studentList.stream()
                .mapToInt(Student::getScore)
                .sum();

        // 커스텀 reudce()
        int sum2 = studentList.stream()
                .mapToInt(Student::getScore)
                .reduce(0, Integer::sum); // 훨씬 더 간단하게
//                .reduce(0 /* 디폴트 값 : 0 */, (a,b) -> a+b);

        System.out.println("sum1 : " + sum1);
        System.out.println("sum2 : " + sum2);
    }
}
