package section_17_stream.ex05_filtering;

import java.util.ArrayList;
import java.util.List;

public class FilteringExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("홍길동");
        list.add("신마니");
        list.add("신보라");
        list.add("김삿갓");
        list.add("신마니");

        list.forEach(e -> System.out.print(e + ", "));

        System.out.println();

        // distinct() : 중복 요소 제거
        list.stream().distinct().forEach(e -> System.out.print(e + ", "));

        System.out.println();

        // filter() : 해당되는 요소만 걸러내서 반환
        list.stream().filter(e -> e.startsWith("신"))
                .forEach(e -> System.out.print(e + ", "));

        System.out.println();

        list.stream().distinct().filter(e -> e.startsWith("신"))
                .forEach(e -> System.out.print(e + ", "));
    }
}
