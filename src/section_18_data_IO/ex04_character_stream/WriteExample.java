package section_18_data_IO.ex04_character_stream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteExample {
    public static void main(String[] args) {
        try {
            Writer writer = new FileWriter(
                    "/Users/kimdongjun/Desktop/temp/test1.txt"
            ); // 문자 기반 출력 스트림 생성

            // 1문자씩 출력하기
            char a = 'A';
            char b = 'B';
            writer.write(a);
            writer.write(b);

            // char 배열 출력
            char[] array = { 'C', 'D', 'E' };
            writer.write(array);

            // 문자열 출력하기
            writer.write("FGH");

            // 버퍼 잔류하는 문자열 출력 후, 버퍼 비움
            writer.flush();

            // 출력 스트림 폐쇄, 메모리 해제
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
