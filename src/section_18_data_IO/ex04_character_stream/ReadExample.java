package section_18_data_IO.ex04_character_stream;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadExample {
    public static void main(String[] args) {
        try {Reader reader = null;

            // 1 문자씩 읽기
            reader = new FileReader(
                    "/Users/kimdongjun/Desktop/temp/test1.txt"
            );

            while(true) {
                int data= reader.read();
                if (data == -1) {
                    break;
                }
//                System.out.println(data); // 그냥 출력하면 십진수 유니코드
                System.out.println((char) data);
            }

            reader.close();
            System.out.println();


            // 문자 배열로 읽기
            reader = new FileReader(
                    "/Users/kimdongjun/Desktop/temp/test1.txt"
            );
            char[] data = new char[100];
            while(true) {
                int num = reader.read(data);
                if (num == -1) {
                    break;
                }
                for(int i=0; i<num; i++) {
                    System.out.println(data[i]);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
