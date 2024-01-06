package section_18_data_IO.ex03_byte_inputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {
    public static void main(String[] args) {
        try {
            String originalFileName = "/Users/kimdongjun/Desktop/temp/test.jpeg";
            String targetFileName = "/Users/kimdongjun/Desktop/temp/test2.jpeg";

            InputStream is = new FileInputStream(originalFileName);
            OutputStream os = new FileOutputStream(targetFileName);

//            byte[] data = new byte[1024]; // 읽은 바이트 저장할 배열 생성
//
//            while(true) {
//                int num = is.read(data);
//                if(num == -1) {
//                    break;
//                }
//                os.write(data, 0, num); // data의 읽은 데이터 수(num)만큼 출력
//            }
            is.transferTo(os); // 훨씬 간단하게 이렇게 할 수 있음

            os.flush();
            os.close();
            is.close();

            System.out.println("복사 완료");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
