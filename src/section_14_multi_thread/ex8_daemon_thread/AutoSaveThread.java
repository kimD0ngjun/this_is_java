package section_14_multi_thread.ex8_daemon_thread;

public class AutoSaveThread extends Thread{
    public void save() {
        System.out.println("작업 내용 저장");
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(100); // 주기 작업 및 인터럽트 처리를 위함
            } catch(InterruptedException e) {
                break;
            }
            save();
        }
    }
}

// 데몬 스레드는 일반 스레드가 모두 종료되면 자동으로 종료
