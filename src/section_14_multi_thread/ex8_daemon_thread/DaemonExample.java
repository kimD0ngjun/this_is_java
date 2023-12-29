package section_14_multi_thread.ex8_daemon_thread;

public class DaemonExample {
    public static void main(String[] args) {
        AutoSaveThread autoSaveThread = new AutoSaveThread();
        autoSaveThread.setDaemon(true); // AutoSaveThread를 메인 스레드(주 스레드)의 데몬 스레드화
        autoSaveThread.start(); // 데몬 스레드 호출하면서.....

        try {
            Thread.sleep(3000); // 메인 스레드 3초간 일시정지
        } catch (InterruptedException e) {}

        System.out.println("메인 스레드 종료"); // 이 시점에서 데몬 스레드도 같이 종료
    }
}
