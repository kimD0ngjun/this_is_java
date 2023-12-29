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
}
