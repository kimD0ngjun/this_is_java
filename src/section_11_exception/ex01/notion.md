## '에러'와 '예외'를 구분하자

>- 에러 : 컴퓨터 하드웨어의 고장으로 인한 프로그램 실행 오류
>- 예외 : 잘못된 코드 작성으로 인한 오류

### '일반 예외'와 '실행 예외'

자바에서는 '일반 예외(Exception)'와 '실행 예외(Runtime Exception)'로 구별
>- 일반 예외 : 컴파일러가 예외 처리 코드 여부를 검사하는 예외
>- 실행 예외 : 컴파일러가 예외 처리코드 여부를 검사하지 않는 예외

### 모든 에러와 예외 클래스는 Throwable을 상속받아 만듦
덤으로, 예외 클래스는 `java.lang.Exception` 클래스를 상속받는다.<br />
실행 예외는 `RuntimeException`과 그 자식 클래스를 일컫는다. 그 밖의 예외는 전부 일반 예외다.