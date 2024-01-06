package section_18_data_IO.ex03_byte_inputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample1 {
    public static void main(String[] args) {
        try {
            InputStream is = new FileInputStream(
                    "/Users/kimdongjun/Desktop/temp/test1.db");

            while(true) {
                int data = is.read();
                if (data == -1) {
                    break;
                }
                System.out.println(data);
            };

            is.close(); // 입력 스트림 닫고 사용 메모리 해제

        } catch (FileNotFoundException e) {
          e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
