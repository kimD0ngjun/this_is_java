package section_15_collection.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Java");
        set.add("JDBC");
        set.add("JSP");
        set.add("Java"); // 중복 객체
        set.add("Spring");

        int size = set.size();
        System.out.println("총 객체 수 : " + size);
    }
}
