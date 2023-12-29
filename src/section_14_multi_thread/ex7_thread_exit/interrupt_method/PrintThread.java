package section_14_multi_thread.ex7_thread_exit.interrupt_method;

public class PrintThread extends Thread{
    @Override
    public void run() {
        try {
            while(true) {
                System.out.println("실행 중...");
                Thread.sleep(1); // InterruptedException이 발생할 수 있는 최소한의 틈 제공
            }
        } catch (InterruptedException e) {}
        System.out.println("리소스 정리");
        System.out.println("실행 종료");
    }
}
