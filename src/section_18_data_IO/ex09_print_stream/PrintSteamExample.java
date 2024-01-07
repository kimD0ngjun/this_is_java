package section_18_data_IO.ex09_print_stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintSteamExample {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(
                "/Users/kimdongjun/Desktop/temp/printstream.txt"
        ); // 실행하면 이 경로로 printstream.txt가 생성되면서 밑의 내용이 입력됨
        PrintStream ps = new PrintStream(fos);

        ps.print("마치 ");
        ps.println("프린터가 출력하는 것처럼 ");
        ps.printf("| %6d | %-10s | %10s | \n", 1, "홍길동", "도적");
        ps.printf("| %6d | %-10s | %10s | \n", 2, "감자칩", "마법사");

        ps.flush();
        ps.close();
    }
}
