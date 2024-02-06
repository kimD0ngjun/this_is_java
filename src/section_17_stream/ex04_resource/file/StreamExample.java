package section_17_stream.ex04_resource.file;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get(StreamExample.class.getResource("data.txt").toURI());
        // Path의 경로를 URI 객체로 변환 후 반환

        Stream<String> stream = Files.lines(path, Charset.defaultCharset());
        // lines() 파일에서 모든 line을 읽어서 Stream으로 리턴

        stream.forEach(System.out::println);
        stream.close(); // 자원 누수를 방지하기 위한 close() 메소드

//        try (Stream<String> stream = Files.lines(path, Charset.defaultCharset())) {
//            stream.forEach(System.out::println);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } // 리소스 닫기를 통한 try-with-resources 문법(얘도 자원 누수 방지)
    }
}
