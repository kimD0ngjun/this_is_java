package section_18_data_IO.ex08_basic_type_stream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputStreamExample {
    public static void main(String[] args) throws IOException {
        // DataOutputStream 생성
        FileOutputStream fos = new FileOutputStream("/Users/kimdongjun/Desktop/temp/primitive.db");
        DataOutputStream dos = new DataOutputStream(fos); // 기본 타입 보조 스트림 연결

        // 기본 타입 출력
        dos.writeUTF("홍길동");
        dos.writeDouble(95.5);
        dos.writeInt(1);

        dos.writeUTF("감자칩");
        dos.writeDouble(90.3);
        dos.writeInt(2);

        dos.flush();
        dos.close();
        fos.close();

        // DataInputStream 생성
        FileInputStream fis = new FileInputStream("/Users/kimdongjun/Desktop/temp/primitive.db");
        DataInputStream dis = new DataInputStream(fis);

        // 기본 타입 입력
        for (int i=0; i<2; i++) {
            String name = dis.readUTF();
            double score = dis.readDouble();
            int order = dis.readInt();
            // 위에서처럼 읽을 때도 스트링, 더블, 인트 순서 똑같이
            System.out.println(name + " : " + score + " : " + order);
        }

        dis.close();
        fis.close();
    }
}
