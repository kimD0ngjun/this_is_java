package section_17_stream.ex02_internal_iterator;

// 외부 반복자 : for, while, iterator 처럼 개발자가 코드로 직접 반복시킴
// 내부 반복자 : 컬렉션 내부에서 요소들을 반복, 개발자는 요소당 처리할 코드만 제공

// 내부 반복자는 요소 분배를 통해 병렬 작업 가능

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        Stream<String> parallelStream = list.parallelStream(); // 병렬 스트림 얻기

        long startTime = System.nanoTime();

        // 멀티 스레드 형성
        parallelStream.forEach(name -> {
            System.out.println(name + " : " + Thread.currentThread().getName());
        });

//        for(String item: list) {
//            System.out.println(item);
//        }

        long endTime = System.nanoTime();
        System.out.println("걸린 시간 : " + (endTime - startTime));
    }
}

// 왜 그냥 반복문이 시간이 덜 걸리냐면...
// 작은 데이터 세트에서는 병렬 처리의 오버헤드 때문에 오히려 성능이 나빠질 수 있
// 고로 의미업따