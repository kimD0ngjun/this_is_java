package section_18_data_IO.ex03_byte_inputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample2 {
    public static void main(String[] args) {
        try {
            InputStream is = new FileInputStream(
                    "/Users/kimdongjun/Desktop/temp/test2.db");

            byte[]data = new byte[100];

            while(true) {
                int num = is.read(data); // num은 read()가 읽은 바이트의 수
                if(num == -1) {
                    break;
                }

                for(int i = 0; i < num; i++) {
                    System.out.println(data[i]);
                }
            }

            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
