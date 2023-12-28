package section_14_multi_thread.ex1_thread_class;

import java.awt.Toolkit;

public class BeepPrintExample {
    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 5; i++) {
            toolkit.beep();
            try { Thread.sleep(500); } catch(Exception e) {}

        } // 뾱 뾱 뾱 뾱 뾱 들린 다음에...

        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            try { Thread.sleep(500); } catch(Exception e) {}
        } // 띵 띵 띵 띵 띵 비동기마냥 짠하고 뜸
    }
}
