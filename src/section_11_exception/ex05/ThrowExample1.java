package section_11_exception.ex05;

public class ThrowExample1 {
    public static void main(String[] args) {
        try {
            findClass();
        } catch(ClassNotFoundException e) {
            System.out.println("예외 처리: " + e);
        }
    }

    public static void findClass() throws ClassNotFoundException {
        Class.forName("java.lang.String2");
    } // 실제로 예외가 발생하는 위치는 findClass 메소드 내부
}

//    main 메소드에서 예외 처리하는 방식으로 findClass 가 처리하는 방식이 대체, 따라가게 됨.
//    나열할 예외 클래스가 많다면, throws Exception 이나 throws Throwable 로 처리할 수 있음
