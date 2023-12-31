package section_15_collection.unmodifiable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImmutableExample {
    public static void main(String[] args) {
        //TODO : of 메소드 사용

        // List 불변 컬렉션
        List<String> immutableList1 = List.of("A", "B", "C");
//        boolean d1 = immutableList1.add("D");
//        System.out.println(d1);
        // Set 불변 컬렉션
        Set<String> immutableSet1 = Set.of("A", "B", "C");
//        boolean d2 = immutableSet1.add("D");
//        System.out.println(d2);
        // Map 불변 컬렉션
        Map<Integer, String> immutableMap1 = Map.of(
                1, "A",
                2, "B",
                3, "C"
        );
//        String valueD3 = immutableMap1.put(4, "D");
//        System.out.println(valueD3);

        //TODO : copyOf 메소드 사용

        // List 컬렉션 복사
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        List<String> immutableList2 = List.copyOf(list);
//        boolean d1 = immutableList2.add("D");
//        System.out.println(d1);
        // Set 컬렉션 복사
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
//        Set<String> immutableSet2 = Set.copyOf(set);
//        boolean d2 = immutableSet2.add("D");
        // Map 컬렉션 복사
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
//        Map<Integer, String> immutableMap2 = Map.copyOf(map);
//        String valueD3 = immutableMap2.put(4, "D");

        //TODO: 배열에서 List 불변 컬렉션 생성
        String[] array = {"A", "B", "C"};
        List<String> immutableList3 = Arrays.asList(array);
//        boolean d1 = immutableList3.add("D");
//        System.out.println(d1);
    }
}
