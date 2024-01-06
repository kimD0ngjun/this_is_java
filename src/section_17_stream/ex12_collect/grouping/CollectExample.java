package section_17_stream.ex12_collect.grouping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import section_17_stream.ex12_collect.filter_map_collect.Student;

public class CollectExample {
    public static void main(String[] args) {
        List<Student> totalList = new ArrayList<>();
        totalList.add(new Student("홍길동", "M", 92));
        totalList.add(new Student("김수영", "F", 87));
        totalList.add(new Student("감자칩", "M", 95));
        totalList.add(new Student("오해영", "F", 93));

        Map<String, List<Student>> map = totalList.stream()
                .collect(
                        Collectors.groupingBy(Student::getSex)
                );

        List<Student> maleList = map.get("M");
        maleList.forEach(e -> System.out.println(e.getName()));
//        maleList.stream().forEach(e -> System.out.println(e.getName()));
        // 스트림으로 처리하냐 컬렉션으로 처리하냐의 차이(결과는 썜쌤)

        List<Student> femaleList = map.get("여");
        femaleList.forEach(e -> System.out.println(e.getName()));
    }
}

// 키는 성별이 되고, 각 성별에 해당하는 학생들의 리스트가 값으로 매핑
