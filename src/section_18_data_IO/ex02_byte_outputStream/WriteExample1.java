package section_18_data_IO.ex02_byte_outputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample1 {
    public static void main(String[] args) {
        try {
            OutputStream os = new FileOutputStream("/Users/kimdongjun/Desktop/temp/test1.db");
            // 데이터 도착지를 test1.db 파일로 하는 바이트 출력 스트림 생성
            // 맥북은 파일 경로 적을 때 절대 경로(내가 적은 것처럼)로 적거나 현재 플젝의 디렉토리를 기준으로 상대경로 작성
            // 축약 경로는 다매다네

            byte a = 10;
            byte b = 20;
            byte c = 30;
            // 이진 형태의 데이터라서 txt 파일에서는 안 보일 수 있음

            os.write(a); // 1 byte씩 출력
            os.write(b);
            os.write(c);

            os.flush(); // 내부 버퍼에 잔류하는 바이트를 출력하고 버퍼 비움

            os.close(); // 출력 스트림 폐쇄, 사용 메모리 사제

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
