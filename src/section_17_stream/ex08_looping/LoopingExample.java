package section_17_stream.ex08_looping;

import java.util.Arrays;

public class LoopingExample {
    public static void main(String[] args) {
        // peek() : 중간 처리 과정이라서 뒤에 또 이어줘야함
        // forEach() : 최종 처리 과정이라서 얘가 끝이어도 무방

        int[] ints = {1, 2, 3, 4, 5};

        int totalValue = Arrays.stream(ints)
                .filter(e -> e%2==0)
                .peek(System.out::println) // 여기서 끝내면 오류 발생
                .sum();

        System.out.println("총합 : " + totalValue);
        System.out.println();

        Arrays.stream(ints)
                .filter(e -> e%2==0)
                .forEach(System.out::println);
    }
}
