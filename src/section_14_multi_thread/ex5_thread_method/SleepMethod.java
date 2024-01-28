package section_14_multi_thread.ex5_thread_method;

import java.awt.Toolkit;

public class SleepMethod {
    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for(int i=0; i<10; i++) {
            toolkit.beep(); // 밑의 반복문을 지우면 삡이 한번만 들리는데 사실 10번 다 한번에 들린 것 같은
            try { Thread.sleep(3000);
            } catch(InterruptedException e) {
                // 일시 정지 상태에서는 InterruptedException이 발생할 수 있음
                // 그래서 sleep() 메소드는 예외 처리가 필밑
                // interrupt() 메소드가 호출되면 실행
            }
        }
        // 메인 메소드의 비프음 10번 들리게 하는 것을 3초 단위로 일시 정지 상태로 보냈다가
        // 실행 대기 상태로 돌아오면서 곧바로 실행 상태로 이뤄지며 비프음이 또 들리고...
        // 이 과정을 반복하는 셈
    }
}
