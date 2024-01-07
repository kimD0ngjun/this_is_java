package section_18_data_IO.question;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CopyFileProgram {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // 경로 입력 받기
        System.out.print("원본 파일 경로: ");
        String originalFilePath = scanner.nextLine();

        System.out.print("복사 파일 경로: ");
        String copiedFilePath = scanner.nextLine();

        File originalFile = new File(originalFilePath);
        if(!originalFile.exists()) {
            System.out.println("원본 파일이 존재하지 않습니다.");
            System.exit(0);
        }

        File copiedFile = new File(copiedFilePath);
        File parentFile = copiedFile.getParentFile();
        if(!parentFile.exists()) {
            parentFile.mkdirs();
        }

        // 입출력 스트림
        FileInputStream fis = new FileInputStream(originalFilePath);
        BufferedInputStream bis = new BufferedInputStream(fis);

        FileOutputStream fos = new FileOutputStream(copiedFilePath);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        byte[] data = new byte[1024];
        int num = -1;
        while(true) {
            num = bis.read(data);
            if (num == -1) break;
            bos.write(data, 0, num);
        }
        System.out.println("복사가 성공했습니다.");

        bos.flush();
        bos.close();
        fos.close();

        bis.close();
        fis.close();
    }
}
