package section_18_data_IO.ex02_byte_outputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample3 {
    public static void main(String[] args) {
        try {
            OutputStream os = new FileOutputStream("/Users/kimdongjun/Desktop/temp/test3.db");

            byte[] array = {10, 20, 30, 40, 50};

            os.write(array, 1, 3); // 인덱스 1 요소부터 3개

            os.flush();
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
