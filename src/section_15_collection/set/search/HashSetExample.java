package section_15_collection.set.search;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Java");
        set.add("JDBC");
        set.add("JSP");
        set.add("Spring");

        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
            if(element.equals("JSP")) {
                iterator.remove();
            }
        } // Iterator랑 while(iterator.hasNext())는 세트

        System.out.println();

        set.remove("JDBC");

        for(String element: set) {
            System.out.println(element);
        }
    }
}
