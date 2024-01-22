package section_11_exception.ex05;

public class ThrowExample2 {
    public static void main(String[] args) throws Exception {
        findClass();
    }
    // main 메소드가 떠넘긴 예외는 최종적으로 JVM에서 처리된다.
    // JVM은 예외의 내용을 콘솔에 출력하는 것으로 예외 처리를 한다.

    public static void findClass() throws ClassNotFoundException {
        Class.forName("java.lang.String2");
    }
}
