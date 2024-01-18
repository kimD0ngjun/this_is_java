package section_08.ex02;

public interface ExampleInterface {
    String constantFiled = "인터페이스의 상수 필드"; // 상수 필드드(public)
    void abstractMethod(); // 추상 메소드(public)
    default void defaultMethod() {
        System.out.println("인터페이스의 디폴트 메소드 실행");
        privateMethod();
        staticPrivateMethod();
    } // 디폴트 메소드
    static void staticPublicMethod() {
        System.out.println("인터페이스의 정적 메소드 실행");
        staticPrivateMethod();
    } // 정적 메소드(public)

    private void privateMethod() {
        System.out.println("인터페이스의 프라이빗 메소드 실행");
    } // private 메소드
    private static void staticPrivateMethod() {
        System.out.println("인터페이스의 프라이빗 정적 메소드 실행");
    } // private 정적 메소드
}
