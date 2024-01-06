package section_18_data_IO.ex05_buffered_stream.buffer_stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferExample {
    public static void main(String[] args) {
        try {
            String originalFilePath1 =
                    BufferExample.class.getResource("test1.jpeg").getPath();
            String targetFilePath1 = "/Users/kimdongjun/Desktop/temp/targetFile1.jpeg";

            FileInputStream fis = new FileInputStream(originalFilePath1);
            FileOutputStream fos = new FileOutputStream(targetFilePath1);

            // 입출력 스트림 + 버퍼 스트림 생성
            String originalFilePath2 =
                    BufferExample.class.getResource("test2.jpeg").getPath();
            String targetFilePath2 = "/Users/kimdongjun/Desktop/temp/targetFile2.jpeg";

            FileInputStream fis2 = new FileInputStream(originalFilePath2);
            FileOutputStream fos2 = new FileOutputStream(targetFilePath2);

            BufferedInputStream bis = new BufferedInputStream(fis2);
            BufferedOutputStream bos = new BufferedOutputStream(fos2);

            // 버퍼 사용 없이 복사
            long nonBufferTime = copy(fis, fos);
            System.out.println("버퍼 미사용 : " + nonBufferTime);

            // 버퍼를 사용하고 복사
            long bufferTime = copy(bis, bos);
            System.out.println("버퍼 사용 : " + bufferTime);

            fis.close();
            fos.close();
            bis.close();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long copy(InputStream is, OutputStream os) throws Exception {
        // 시작 시간 설정
        long start = System.nanoTime();

        // 1바이트를 읽고 1바이트 출력
        while(true) {
            int data = is.read();
            if(data == -1) {
                break;
            }
            os.write(data);
        }
        os.flush();

        long end = System.nanoTime();

        return end-start;
    }
}
