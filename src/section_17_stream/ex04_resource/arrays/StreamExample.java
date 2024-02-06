package section_17_stream.ex04_resource.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        String[] strings = {"홍길동", "김자바", "치킨냠"};
        Stream<String> stringStream = Arrays.stream(strings); // 데이터 처리를 위한 스트림화
        stringStream.forEach(item -> System.out.print(item + ", "));

        System.out.println();

        int[] ints = {1, 2, 3, 4, 5};
//        Stream<Integer> integerStream = Arrays.stream(ints); // 에러가 난 이유는 그냥 Stream은 객체 요소 스트림화
        IntStream intStream = Arrays.stream(ints); // int 배열의 데이터 처리를 위한 intStream화
        intStream.forEach(item -> System.out.print(item + ", "));
    }
}
