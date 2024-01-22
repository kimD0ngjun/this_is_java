package section_11_exception.ex04;

import java.io.FileInputStream;
import java.io.IOException;

public class CloseResourceByFinallyExample {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("file.txt");
            System.out.println(fis);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            fis.close(); // finally 문법을 사용한 리소스 닫기
        }
    }
}
