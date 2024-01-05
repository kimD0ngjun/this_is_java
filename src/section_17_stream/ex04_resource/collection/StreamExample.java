package section_17_stream.ex04_resource.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        // list 컬렉션 생성
        List<Product> list = new ArrayList<>();
        for(int i=1; i<=5; i++) {
            Product product = new Product(i, "상품"+i, "무슨 회사 ", (int) (10000*Math.random()));

            list.add(product);
        }

        // 객체 스트림
        Stream<Product> stream = list.stream();
//        stream.forEach(p -> System.out.println(p));
        stream.forEach(System.out::println); // 메소드 참조 람다식
    }
}
