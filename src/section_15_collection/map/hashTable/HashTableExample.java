package section_15_collection.map.hashTable;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashTableExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new Hashtable<>();
//        Map<String, Integer> map = new HashMap<>();

        Thread threadA = new Thread(){
            @Override
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                    map.put(String.valueOf(i), i);
                    System.out.println("키 : " + i + ", 값 : " + map.get(String.valueOf(i)));
                }
            }
        };

        Thread threadB = new Thread(){
            @Override
            public void run() {
                for (int i = 1001; i <= 2000; i++) {
                    map.put(String.valueOf(i), i);
                    System.out.println("키 : " + i + ", 값 : " + map.get(String.valueOf(i)));
                }
            }
        };

        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        int size = map.size();
        System.out.println("총 엔트리 수 : " + size);
    }
}
