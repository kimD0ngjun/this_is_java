package section_14_multi_thread.ex9_threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableExecuteExample {
    public static void main(String[] args) {
        String[][] mails = new String[1000][3];
        for(int i = 0; i < mails.length; i++) {
            mails[i][0] = "admin@my.com";
            mails[i][1] = "member"+i+"@my.com";
            mails[i][2] = "신상품 입고";
        }

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        // 작업 개수가 많아지면 최대 5개까지 스레드를 생성시켜 작업을 처리하는 스레드풀

        for(int i = 0; i < mails.length; i++) {
            final int index = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Thread thread = Thread.currentThread();
                    String from = mails[index][0];
                    String to = mails[index][1];
                    String content = mails[index][2];

                    System.out.println(
                            "[" + thread.getName() +"] " + from + " ==> " + to + " : " + content
                    );
                }
            });
        }

        executorService.shutdown();
    }
}
