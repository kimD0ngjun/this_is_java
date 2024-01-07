package section_18_data_IO.ex06_character_convert_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class CharacterConvertStreamExample {
    public static void main(String[] args) throws Exception {
        write("문자 변환 스트림 사용");
        String data = read();
        System.out.println(data);
    }

    public static void write(String string) throws Exception {
        OutputStream os = new FileOutputStream(
                "/Users/kimdongjun/Desktop/temp/test.txt"
        );

        Writer writer = new OutputStreamWriter(os, "UTF-8");
        // 보조 스트림 연결
        writer.write(string); // 보조 스트림으로 문자 출력
        writer.flush();
        writer.close();
    }

    public static String read() throws Exception {
        InputStream is = new FileInputStream(
                "/Users/kimdongjun/Desktop/temp/test.txt"
        );

        Reader reader = new InputStreamReader(is, "UTF-8");
        // 보조 스트림 연결
        char[] data = new char[100];
        int num = reader.read(data); // 보조 스트림으로 문자 입력
        reader.close();
        String str = new String(data, 0, num);
        return str;
    }
}
