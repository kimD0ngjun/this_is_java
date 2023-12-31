package section_15_collection.synchronized_Collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SynchronizedSetExample {
    public static void main(String[] args) {
        Set<Integer> set = Collections.synchronizedSet(new HashSet<>());

        Thread threadA = new Thread() {
            @Override
            public void run() {
                for(int i = 1; i <= 1000; i++) {
                    set.add(i);
                }
            }
        };

        Thread threadB = new Thread() {
            @Override
            public void run() {
                for(int i = 1001; i <= 2000; i++) {
                    set.add(i);
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

        System.out.println("총 객체 수 : " + set.size());
    }
}
