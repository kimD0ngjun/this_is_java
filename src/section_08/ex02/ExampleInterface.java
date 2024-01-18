package section_08.ex02;

public interface ExampleInterface {
    int constantFiled = 0; // 상수 필드(public)
    void abstractMethod(); // 추상 메소드(public)
    default void defaultMethod() {
        System.out.println("디폴트 메소드 실행");
    } // 디폴트 메소드
    static void staticPublicMethod() {} // 정적 메소드(public)

    private void privateMethod() {} // private 메소드
    private static void staticPrivateMethod() {} // private 정적 메소드
}
