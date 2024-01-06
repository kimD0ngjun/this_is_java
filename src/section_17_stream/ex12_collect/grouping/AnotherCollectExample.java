package section_17_stream.ex12_collect.grouping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import section_17_stream.ex12_collect.filter_map_collect.Student;

public class AnotherCollectExample {
    public static void main(String[] args) {
        List<Student> totalList = new ArrayList<>();
        totalList.add(new Student("홍길동", "M", 92));
        totalList.add(new Student("김수영", "F", 87));
        totalList.add(new Student("감자칩", "M", 95));
        totalList.add(new Student("오해영", "F", 93));

        Map<String, Double> map = totalList.stream()
                .collect(
                        Collectors.groupingBy(
                                Student::getSex,
                                Collectors.averagingDouble(Student::getScore)
                                // 두 번째 인자로써 평균값 계산하고 이걸 키의 값으로 삼아버림
                        )
                );

        System.out.println(map);
    }
}
