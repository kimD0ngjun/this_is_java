package section_17_stream.ex01_what_is_stream;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("홍길동");
        set.add("신용권");
        set.add("감자바");

        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()) {
            String item = iterator.next();
            System.out.println(item);
        }

        System.out.println();

        for (String item : set) {
            System.out.println(item);
        }

        System.out.println();

        Stream<String> stream1 = set.stream();
        stream1.forEach(item -> System.out.println(item));

        System.out.println();

        Stream<String> stream2 = set.stream();
        stream2.forEach(System.out::println);
    }
}

// stream과 iterator를 비교해보면...
// stream은 내부 반복자이므로 처리 속도가 빠르고 병렬 처리에 효율적이다.
// 람다식으로 다양한 요소 처리를 정의할 수 있다.
// 중간 처리와 최종 처리를 수행하도록 파이프 라인을 형성할 수 있다.
// 계속 . 뭐시기. 뭐시기 . 뭐시기 . 뭐시기.... 이런 식으로 붙이는 게 곧 파이프라인이며 중간의 뭐시기가 곧 중간 스트림
// https://ittrue.tistory.com/164?category=958774