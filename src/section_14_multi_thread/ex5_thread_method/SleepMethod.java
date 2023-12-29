package section_14_multi_thread.ex5_thread_method;

import java.awt.Toolkit;

public class SleepMethod {
    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for(int i=0; i<10; i++) {
            toolkit.beep();
            try { Thread.sleep(3000);
            } catch(InterruptedException e) {
                // 일시 정지 상태에서는 InterruptedException이 발생할 수 있음
                // 그래서 sleep() 메소드는 예외 처리가 필요
                // interrupt() 메소드가 호출되면 실행
            };
        }
    }
}
