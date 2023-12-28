package other.exception.practice8;

// 사용자 정의 예외
public class InsufficientException extends Exception {
    public InsufficientException() {
    } //  메시지를 지정하지 않고 예외를 던질 때 기본 생성자가 호출

    public InsufficientException(String message) {
        super(message);
    } // 예외 객체를 생성할 때 발생한 예외에 대한 설명이나 부가 정보를 포함하고자 할 때 사용
}
