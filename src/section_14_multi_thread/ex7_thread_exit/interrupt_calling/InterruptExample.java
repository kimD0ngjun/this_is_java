package section_14_multi_thread.ex7_thread_exit.interrupt_calling;

import section_14_multi_thread.ex7_thread_exit.interrupt_method.PrintThread;

public class InterruptExample {
    public static void main(String[] args) {
        Thread thread = new PrintThread();
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}

        thread.interrupt();
    }
}
