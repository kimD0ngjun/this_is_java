package section_17_stream.ex06_mapping;

import java.util.Arrays;
import java.util.stream.IntStream;

public class AnotherMapMethod {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5};

        IntStream intStream = Arrays.stream(ints);
        intStream.asDoubleStream(). // int -> double 로 정수 스트림을 실수 스트림으로 변환
                forEach(System.out::println);
        // 여기서 기존의 intStream은 사용되었고, asDoubleStream() 메서드를 통해 새로운 DoubleStream이 생성

        System.out.println();

        // 한 번 사용된 스트림은 '소비(consumed)'되었다고 간주
        // 그래서 새로운 IntStream을 생성하여 intStream에 할당

        intStream = Arrays.stream(ints); // 기본 스트림(요게 새로운 IntStream을 생성)
        // 기존의 intStream 변수에 새로운 IntStream을 할당
        intStream.boxed(). // int -> Integer 로 래퍼 스트림 변환
                forEach(e -> System.out.println(e.intValue())); // 그것의 int 값을 갖고와서 출력
    }
}
