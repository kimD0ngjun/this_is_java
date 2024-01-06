package section_17_stream.ex10_reduction_aggregate;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalExample {
    public static void main(String[] args) {
        // Optional 클래스의 존재 의의
        // : 컬렉션의 동적 요소 추가로 인해 요소 부존재로 인한 NoSuchElementException 예외 막기

        List<Integer> list = new ArrayList<>();

//        double average = list.stream()
//                .mapToInt(Integer::intValue)
//                .average()
//                .getAsDouble();
//        System.out.println("평균(근데 아마 에러 발생할 걸?) : " + average);
//        // 이렇게 아무 것도 없는데 평균 구하려고 하면 에러 뙇 하고 발생

        // TODO : 방법 1. isPresent()로 값이 존재할 때만 나타내고 분기 가르기
        OptionalDouble optionalDouble = list.stream()
                .mapToInt(Integer::intValue)
                .average();

        if(optionalDouble.isPresent()) {
            System.out.println("isPresent()가 참, 즉 평균값이 존재하면 : " + optionalDouble);
        } else {
            System.out.println("평균값이 존재하지 않으면 : " + 0.0);
        } // 약간 야매식 디폴트값...


        // TODO : 방법 2. orELse()로 값이 존재하지 않을 경우의 디폴트 값을 정해두기
        double average = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println("값이 없으면 디폴트 값으로 : " + average);


        // TODO : 방법 3. ifPresent()로 집계값 조건부 Consumer 람다식 작성
        list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .ifPresent(e -> System.out.println("아마 나오진 않겠지만 : " + e));
    }
}
