package section_14_multi_thread.ex3_no_named_object;

import java.awt.Toolkit;

// 익명 자식 객체 활용
public class BeepPrintExample {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for (int i = 0; i < 5; i++) {
                    toolkit.beep();
                    try { Thread.sleep(500); } catch(Exception e) {}
                }
            }
        }; // 이런 식으로 Thread의 익명 자식 객체로 작업 스레드 정의하는 게 많이 사용됨

        thread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            try { Thread.sleep(500); } catch(Exception e) {}
        }
    }
}
