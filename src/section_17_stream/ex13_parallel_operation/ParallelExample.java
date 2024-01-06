package section_17_stream.ex13_parallel_operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class ParallelExample {
    public static void main(String[] args) {
        Random random = new Random();

        List<Integer> scores = new ArrayList<>();
        for(int i=0; i<100_000_000; i++) {
            scores.add(random.nextInt(101));
        }

        double average = 0.0;
        long startTime = 0;
        long endTime = 0;
        long time = 0;
        long parallelTime = 0;

        Stream<Integer> stream = scores.stream();
        startTime = System.nanoTime();
        average = stream
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
        endTime = System.nanoTime();
        time = endTime - startTime;
        System.out.println("평균 : " + average + "\n" + "일반 스트림 처리 걸린 시간 : " + time);

        System.out.println();

        Stream<Integer> parallelStream = scores.parallelStream();
        startTime = System.nanoTime();
        average = parallelStream
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
        endTime = System.nanoTime();
        parallelTime = endTime - startTime;
        System.out.println("평균 : " + average + "\n" + "병렬 스트림 처리 걸린 시간 : " + parallelTime);

        System.out.println();

        if (time == parallelTime) {
            System.out.println("동일하게 걸림");
        } else {
            System.out.println(
                    parallelTime < time ? "병렬 스트림 처리가 더 빠름" : "일반 스트림 처리가 더 빠름"
            );
        }


    }
}
