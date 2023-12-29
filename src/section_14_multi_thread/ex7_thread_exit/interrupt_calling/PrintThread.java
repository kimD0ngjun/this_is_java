package section_14_multi_thread.ex7_thread_exit.interrupt_calling;

public class PrintThread extends Thread{
    @Override
    public void run() {
        while(true) {
            System.out.println("실행 중...");
            if(Thread.interrupted()) { // interrupt() 메소드 호출 여부를 확인하는 interrupted() 메소드
                break;
            } // 굳이 억지로 일시정지 틈(Thread.sleep(1))을 주지 않고 반복문을 브레이크 하기 위해서...
        }

        System.out.println("리소스 정리");
        System.out.println("실행 종료");
    }
}
