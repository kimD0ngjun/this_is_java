package section_14_multi_thread.ex5_thread_method.yieldMethod;

public class WorkThread extends Thread{
    public boolean work = true;

    public WorkThread(String name) {
        setName(name);
    }

    // 삼항 연산자는 문장(statement)이 아닌, 표현식(expression)
    @Override
    public void run() {
        while(true) {
            if (work) {
                System.out.println(getName() + ": 작업처리");
            } else {
                Thread.yield();
            } // elsd 구문이 빠지면 대기 상태로 돌아가는 게 아니라 걍 완전 종료시켜버리는 구나...
        }
    }
}
