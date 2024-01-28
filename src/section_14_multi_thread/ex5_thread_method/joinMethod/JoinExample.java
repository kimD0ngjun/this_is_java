package section_14_multi_thread.ex5_thread_method.joinMethod;

public class JoinExample {
    public static void main(String[] args) {
        SumThread sumThread = new SumThread();
        sumThread.start();
        // start() 메소드는 새로운 스레드를 생성하고, 해당 스레드에서 run() 메소드를 실행하기 위한 메소드
        try {
            sumThread.join();
            // sumThread 스레드가 호출돼서 종료될 때까지 메인 메소드 실행 일시 정지
        } catch (InterruptedException e) {
        }
        // join()을 호출한 sumThread 스레드가 종료 상태가 되면 메인 메소드가 다시 대기 상태로 돌아감
        System.out.println("1~100 합 : " + sumThread.getSum());
    }
}
