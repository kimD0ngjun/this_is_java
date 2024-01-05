package section_17_stream.ex04_resource.number_range_stream;

import java.util.stream.IntStream;

public class StreamExample {
    public static int sum;

    public static void main(String[] args) {
        IntStream stream = IntStream.rangeClosed(0, 100);
        // 양 끝 수를 포함하면 rangeClosed()
        // 양 끝 수를 포함하지 않으면 range()
        stream.forEach(e -> sum += e);
        System.out.println(sum);
    }
}
