package section_17_stream.ex07_sort.comparable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingExample {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("홍길동", 30));
        list.add(new Student("신용권", 10));
        list.add(new Student("유미선", 20));

        list.stream()
                .sorted() // 오름차순 정렬
                .forEach(s -> System.out.println(s.getName() + " : " + s.getScore()));

        System.out.println();

        list.stream()
                .sorted(Comparator.reverseOrder()) // 내림차순 정렬
                // Comparator.reverseOrder() 메소드로 내림차순 재정렬 가능
                .forEach(s -> System.out.println(s.getName() + " : " + s.getScore()));
    }
}
