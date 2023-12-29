package section_14_multi_thread.ex7_thread_exit.interrupt_method;

public class InterruptExample {
    public static void main(String[] args) {
        Thread thread = new PrintThread();
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}

        thread.interrupt();
        // 스레드가 일시 정지 상태에 있을 때, InterruptedException 예외 유발(그로 인해 run() 메소드 정상 종료)
        // 스레드가 실행, 혹은 실행 대기 상태에서는 interrupt() 메소드 호출해도 IE 예외가 발생하지 않는다.
    }
}

// 메인 코드에 있는 thread.interrupt()는 PrintThread 스레드를 종료시키는 역할을 맡음

// 그리고 그 종료의 방법으로 InterruptedException을 유발시켜야 되는데,
// 대상인 PrintThread가 계속 실행 중이거나 혹은 실행 대기 상태면 interrupt() 메소드가 작동해도
// 예외가 유발되지 않으므로 일시정지 상태를 만들기 위한 Thread.sleep(1) 코드가 존재하는 거고

// 이 모든 과정이 이뤄지기 위해서는 우선 메인 스레드를 일시정지해서 PrintThread를 작동시켜야 되는데
// 그걸 위해서 Thread.sleep(1000)이 메인 코드에 작성된 거고
