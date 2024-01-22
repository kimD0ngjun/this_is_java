package section_11_exception.ex04;

public class AutoCloseableExample {
    public static void main(String[] args) {
        // 아까 FileInputStream도 AutoCloseable 인터페이스를 구현하고 있음(close() 메소드 재정의)
        // 여기서 쓰는 Resource 클래스도 AutoCloseable 인터페이스를 구현해서 close() 메소드 재정의
        // try-with-resource 블록을 사용하면 예외 발생 여부와 상관없이 리소스 자동 폐쇄

        try (Resource res = new Resource("A")) {
            String data = res.read1();
            int value = Integer.parseInt(data);
        } catch(Exception e) {
            System.out.println("예외 처리: " + e.getMessage());
        }

        System.out.println();

        try (Resource res = new Resource("A")) {
            String data = res.read2();
            int value = Integer.parseInt(data); // NFE 발생
        } catch(Exception e) {
            System.out.println("예외 처리: " + e.getMessage());
        }

        System.out.println();

        Resource res1 = new Resource("A");
        Resource res2 = new Resource("B");

        try (res1; res2) {
            String data1 = res1.read1();
            String data2 = res2.read1();
        } catch(Exception e) {
            System.out.println("예외 처리: " + e.getMessage());
        }

//        [MyResource(A) 열기]
//        [MyResource(B) 열기]
//        [MyResource(A) 읽기]
//        [MyResource(B) 읽기]
//        [MyResource(B) 닫기]
//        [MyResource(A) 닫기]

        // 이런 순서로 나오는 이유는, 리소스는 열린 순서의 역순으로 닫히기 때문
    }
}
