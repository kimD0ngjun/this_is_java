package section_14_multi_thread.ex2_thread_extends;

import java.awt.Toolkit;

public class BeepPrintExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for (int i = 0; i < 5; i++) {
                    toolkit.beep();
                    try { Thread.sleep(500); } catch(Exception e) {}
                } // 작업 스레드가 실행하는 코드
            }
        }); // 작업 스레드 생성

        thread.start(); // 작업 스레드 실행

        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            try { Thread.sleep(500); } catch(Exception e) {}
        } // 메인 스레드가 코드를 실행하면서 "띱"과 "띵"이 동시에
    }
}

//TODO : 어떤 동작 이전에 스레드 생성부터 먼저하면 새롭게 생성된 스레드와 메인 스레드가 같은 출발선상에 서서 코드를 실행하기 때문에 동시에 실행