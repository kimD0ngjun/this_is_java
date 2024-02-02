package section_15_collection.map.hashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("신용권", 85);
        map.put("홍길동", 90); // 중복!
        map.put("동장군", 80);
        map.put("홍길동", 95); // 최종적으로 얘가 저장

        System.out.println("총 entry 수 : " + map.size());
        System.out.println();

        String key = "홍길동";
        int value = map.get(key);
        System.out.println(key + " : " + value);
        System.out.println();

        Set<String> keySet = map.keySet(); // 모든 키를 Set에 담아서 반환
        Iterator<String> keyIterator = keySet.iterator(); // 반복자 생성
        while (keyIterator.hasNext()) { // 키 객체의 반복자가 계속 존재할 때까지 반복
            String k = keyIterator.next(); // 순회되는 키 객체 뽑아내기
            Integer v = map.get(k);
            System.out.println(k + " : " + v);
        }
        System.out.println();

        Set<Entry<String, Integer>> entrySet = map.entrySet(); // 모든 엔트리를 Set에 담아서 반환
        Iterator<Entry<String, Integer>> entryIterator = entrySet.iterator(); // 반복자 생성
        while (entryIterator.hasNext()) { // 엔트리의 반복자가 계속 존재할 때까지 반복
            Entry<String, Integer> entry = entryIterator.next(); // 순회되는 엔트리 뽑아내기
            String k = entry.getKey(); // 해당 엔트리 키
            Integer v = entry.getValue(); // 해당 엔트리 값
            System.out.println(k + " : " + v);
        }
        System.out.println();

        map.remove("홍길동");
        System.out.println("총 Entry 수 : " + map.size());
    }
}
