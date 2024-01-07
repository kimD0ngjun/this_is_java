package section_18_data_IO.ex11_file_files_class;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// Files 클래스는 정적 메소드로 구성되어 있어서 File 클래스처럼 객체로 만들 필요가 없음
// Files의 정적 메소드는 운영체제의 파일 시스템에게 파일 작업을 수행하도록 위임한다.
public class FilesExample {
    public static void main(String[] args) throws IOException {
        String data =
                "" + "id: womter\n"
                        + "email: winter@mycompany.com\n"
                + "tel: 010-123-1234";

        // Path 객체 생성
        Path path = Paths.get("/Users/kimdongjun/Desktop/temp/user.txt");

        // 파일 생성 및 데이터 저장
        Files.writeString(Paths.get("/Users/kimdongjun/Desktop/temp/user.txt"), data,
                Charset.forName("UTF-8"));

        // 파일 정보 얻기
        System.out.println("파일 유형: " + Files.probeContentType(path));
        System.out.println("파일 크기: " + Files.size(path) + " bytes");

        // 파일 읽기
        String content = Files.readString(path, Charset.forName("UTF-8"));
        System.out.println(content);
    }
}
