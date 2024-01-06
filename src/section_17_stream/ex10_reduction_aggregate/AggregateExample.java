package section_17_stream.ex10_reduction_aggregate;

import java.util.Arrays;

public class AggregateExample {
    public static void main(String[] args) {
        // 정수 배열
        int[] ints = {1, 2, 3, 4, 5};

        // 카운팅
        long count = Arrays.stream(ints)
                .filter(e -> e%2==0)
                .count();
        System.out.println("2의 배수 개수 : " + count);

        // 총합
        long sum = Arrays.stream(ints)
                .filter(e -> e%2==0)
                .sum();
        System.out.println("2의 배수 총합 : " + sum);

        // 평균
        double average = Arrays.stream(ints)
                .filter(e -> e%2==0)
                .average() // 얘는 최종 처리 아님
                .getAsDouble();
        System.out.println("2의 배수 평균 : " + average);

        // 최대값
        int max = Arrays.stream(ints)
                .filter(e -> e%2==0)
                .max() // 얘도 최종 처리 아님
                .getAsInt();
        System.out.println("2의 배수 중 최대값 : " + max);

        // 최소값
        int min = Arrays.stream(ints)
                .filter(e -> e%2==0)
                .min() // 얘도 최종 처리 아님
                .getAsInt();
        System.out.println("2의 배수 중 최소값 : " + min);

        // 첫 번째 요소
        int firstValue = Arrays.stream(ints)
                .filter(e -> e%2==0)
                .findFirst() // 얘도 최종 처리 아님
                .getAsInt();
        System.out.println("2의 배수 중 첫 번째 값 : " + firstValue);
    }
}

// 얘네들은 단순 집계.
// 근데 집계값이 존재하지 않을 경우의 디폴트 값을 설정하거나 집계값을 처리하는 Consumer를 등록할 수 있는...
// Optional 클래스가 있당
