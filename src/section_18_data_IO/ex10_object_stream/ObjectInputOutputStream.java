package section_18_data_IO.ex10_object_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class ObjectInputOutputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // FileOutputStream에 ObjectOutputStream 보조 스트림 연결
        FileOutputStream fos = new FileOutputStream(
                "/Users/kimdongjun/Desktop/temp/object.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // 객체 생성
        Member member1 = new Member("fail", "단풍이");
        Product product1 = new Product("노트북", 1_500_000);
        int[] array1 = {1, 2, 3};

        // 객체 직렬화로 파일에 저장
        oos.writeObject(member1);
        oos.writeObject(product1);
        oos.writeObject(array1);

        oos.flush();
        oos.close();
        fos.close();

        // FileInputStream에 ObjectInputStream 보조 스트림 연결
        FileInputStream fis = new FileInputStream(
                "/Users/kimdongjun/Desktop/temp/object.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);

        // 파일 읽고 역직렬화로 객체 복원
        Member member2 = (Member) ois.readObject(); // 좌변이 범위가 더 좁으니 강제 캐스팅
        Product product2 = (Product) ois.readObject();
        int[] array2 = (int[]) ois.readObject();

        ois.close();
        // flush() 메서드는 주로 출력 스트림에서 사용되며, 데이터를 쓴 후에 스트림을 강제로 비워서 모든 데이터를 전송하는 역할
        // 데이터를 읽어오는 역할을 하는데, 읽기 도중에 스트림을 강제로 비우는 flush() 메서드가 필요하지 않음
        fis.close();

        // 복원 객체 내용 확인
        System.out.println(member2);
        System.out.println(product2);
        System.out.println(Arrays.toString(array2));
    }
}
