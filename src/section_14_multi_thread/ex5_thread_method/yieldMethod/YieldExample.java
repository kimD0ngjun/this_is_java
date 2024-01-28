package section_14_multi_thread.ex5_thread_method.yieldMethod;

public class YieldExample {
    public static void main(String[] args) {
        WorkThread threadA = new WorkThread("A");
        WorkThread threadB = new WorkThread("B");

        threadA.start();
        threadB.start();

        try { Thread.sleep(5000); } catch (InterruptedException e) {} // 5초 간 메인 스레드 중단
        threadA.work = false; // B만 작업처리 주르륵 될 거임(A의 yield() 메소드 실행으로 실행 대기 상태로 복귀)

        try { Thread.sleep(10000); } catch (InterruptedException e) {} // 10초 간 메인 스레드 중단
        threadA.work = true; // 다시 A와 B 번갈아가면서 작업처리 주르륵
    }

    // threadA.work 변수의 통제를 통한 전체적인 제어 흐름의 역할은 메인 스레드가 맡고 있음
    // 이 메인 스레드를 5초 동안 일시정지 상태로 보냈다가 5초 후에 다시 돌리면서 변수를 false로 지정한 다음
    // 다시 곧바로 10초 동안 일시정지 상태로 보내서 다시 돌리면서 변수를 true로 재지정
}
