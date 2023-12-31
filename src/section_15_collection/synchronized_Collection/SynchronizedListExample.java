package section_15_collection.synchronized_Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Vector는 멀티 스레드 환경에서 특화됐으니 그러지 못한 ArrayList 케이스
public class SynchronizedListExample {
    public static void main(String[] args) {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

        Thread threadA = new Thread() {
            @Override
            public void run() {
                for(int i = 1; i <= 1000; i++) {
                    list.add(i);
                }
            }
        };

        Thread threadB = new Thread() {
            @Override
            public void run() {
                for(int i = 1001; i <= 2000; i++) {
                    list.add(i);
                }
            }
        };

        threadA.start();
        threadB.start();

        try{
            threadA.join();
            threadB.join();
        } catch(Exception e) {
        }

        System.out.println("총 객체 수 : " + list.size());
    }
}
