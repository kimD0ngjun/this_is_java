package section_15_collection.synchronized_Collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// 이미 HashTable은 멀티 스레드 환경에 특화됐으니 그러지 못한 HashMap을 위한 케이스
public class SynchronizedMapExample {
    public static void main(String[] args) {
        Map<Integer, String> map = Collections.synchronizedMap(new HashMap<>());

        Thread threadA = new Thread() {
            @Override
            public void run() {
                for(int i = 1; i <= 1000; i++) {
                    map.put(i, "내용-i");
                }
            }
        };

        Thread threadB = new Thread() {
            @Override
            public void run() {
                for(int i = 1001; i <= 2000; i++) {
                    map.put(i, "내용-i");
                }
            }
        };

        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
        } catch(Exception e) {
        }

        int size = map.size();
        System.out.println("총 객체 수 : " + size);
    }
}
