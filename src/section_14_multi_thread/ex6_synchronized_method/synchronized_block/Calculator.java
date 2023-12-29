package section_14_multi_thread.ex6_synchronized_method.synchronized_block;

// 공유 객체 역할인 Calculator
public class Calculator {
    private int memory;

    public int getMemory() {
        return memory;
    }

    // 동기화 메소드 setMemory1
    public synchronized void setMemory1(int memory) {
        this.memory = memory;
        try {
            Thread.sleep(2000);
        } catch(InterruptedException e) {}
        System.out.println(Thread.currentThread().getName() + " : " + this.memory);
    }

    public void setMemory2(int memory) {
        // 동기화 블록
        synchronized (this) { // 여기서 this는 공유객체
            this.memory = memory;
            try {
                Thread.sleep(2000);
            } catch(InterruptedException e) {}
            System.out.println(Thread.currentThread().getName() + " : " + this.memory);
        }
    }
}
