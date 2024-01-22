package section_11_exception.ex06;

// 사용자 정의 예외
public class UnderAmountException extends Exception {
    public UnderAmountException() {
    } //  메시지를 지정하지 않고 예외를 던질 때 기본 생성자가 호출

    public UnderAmountException(String message) {
        super(message);
    } // 예외 객체를 생성할 때 발생한 예외에 대한 설명이나 부가 정보를 포함하고자 할 때 사용
    // 현재 여기서는 예외 객체의 공통 메소드인 getMessage()의 리턴값으로 사용하려고 함
}
