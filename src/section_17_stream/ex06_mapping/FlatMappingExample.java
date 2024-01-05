package section_17_stream.ex06_mapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMappingExample {
    // 각각의 요소를 복수 개의 요소로 복붙복붙
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("this is java");
        list1.add("i am a best developer");
        list1.stream().
                flatMap(data -> Arrays.stream(data.split(" "))).
                // 우선 data -> Arrays.stream(data.split(" "))를 통해서
                // 하나의 요소(문장 문자열)를 여러 개의 요소(분리된 문자열 배열을 생성하고, 이를 스트림으로 변환)
                // 그리고 flatMap을 통해서 각 스트림을 전부 펼쳐서 하나의 스트림으로 만들어버림
                forEach(System.out::println);

        System.out.println();

        List<String> list2 = Arrays.asList("10, 20, 30", "40, 50");
        list2.stream().
                flatMapToInt(data -> {
                    String[] strings = data.split(",");
                    int[] ints = new int[strings.length];
                    for (int i=0; i< strings.length; i++) {
                        ints[i] = Integer.parseInt(strings[i].trim());
                    }
                    return Arrays.stream(ints);
                    // Arrays.stream() 메소드가 ints 배열을 IntStream으로 만듬
                })
                .forEach(System.out::println);
    }
}
