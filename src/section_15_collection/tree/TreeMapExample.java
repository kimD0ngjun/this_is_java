package section_15_collection.tree;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        treeMap.put("apple", 10);
        treeMap.put("forever", 60);
        treeMap.put("description", 40);
        treeMap.put("ever", 50);
        treeMap.put("zoo", 80);
        treeMap.put("base", 20);
        treeMap.put("guess", 70);
        treeMap.put("cherry", 30);

        Set<Entry<String, Integer>> entrySet = treeMap.entrySet();
        Iterator<Entry<String, Integer>> iterator1 = entrySet.iterator();

        while(iterator1.hasNext()) {
            Entry<String, Integer> element = iterator1.next();
            System.out.println(element.getKey() + " - " + element.getValue());
        }
        System.out.println();

        Entry<String, Integer> entry;
        entry = treeMap.firstEntry();
        System.out.println("제일 앞 단어 : " + entry.getKey() + " - " + entry.getValue());
        entry = treeMap.lastEntry();
        System.out.println("제일 마지막 단어 : " + entry.getKey() + " - " + entry.getValue());
        entry = treeMap.lowerEntry("ever");
        System.out.println("ever 앞 단어 : " + entry.getKey() + " - " + entry.getValue() + "\n");

        // 내림차순 재배열
        NavigableMap<String, Integer> descendingMap = treeMap.descendingMap();
        Set<Entry<String, Integer>> descendingEntrySet = descendingMap.entrySet();
        // 내림차순 재배열한 descendingMap의 key와 value 쌍을 Set에 담아서 리턴

        Iterator<Entry<String, Integer>> iterator2 = descendingEntrySet.iterator();
        while(iterator2.hasNext()) {
            Entry<String, Integer> element = iterator2.next();
            System.out.println(element.getKey() + " - " + element.getValue());
        }
        System.out.println();

        System.out.println("[c~h 사이의 단어 검색]");
        NavigableMap<String, Integer> rangeMap =
                treeMap.subMap("ch", true, "h", true);
        for(Entry<String, Integer> element : rangeMap.entrySet()) {
            System.out.println(element.getKey() + " - " + element.getValue());
        }
        // subMap이나 haedMap tailMap 매개변수에서 key 매개변수는 String일 경우 맨 앞 인덱스부터 사전처럼 처리
    }
}
