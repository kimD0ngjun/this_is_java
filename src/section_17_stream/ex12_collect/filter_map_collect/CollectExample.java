package section_17_stream.ex12_collect.filter_map_collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectExample {
    public static void main(String[] args) {
        List<Student> totalList = new ArrayList<>();
        totalList.add(new Student("홍길동", "M", 92));
        totalList.add(new Student("김수영", "F", 87));
        totalList.add(new Student("감자칩", "M", 95));
        totalList.add(new Student("오해영", "F", 93));

        List<Student> maleList = totalList.stream()
                .filter(e -> e.getSex().equals("M"))
                .toList();

        maleList.forEach(e -> System.out.println(e.getName()));

        System.out.println();

        Map<String, Integer> map = totalList.stream()
                .collect(
                        Collectors.toMap(
//                                e -> e.getName(),
//                                e -> e.getScore()
                                Student::getName,
                                Student::getScore
                        )
                );

        System.out.println(map);
    }
}
