package section_14_multi_thread.ex4_thread_name;

// getName() 메소드 : Thread의 인스턴스 메소드, 스레드 명칭을 리턴
public class ThreadNameExample {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        mainThread.setName("main-thread");
        System.out.println(mainThread.getName() + " 실행");

        for (int i = 0; i < 3; i++) {
            Thread threadA = new Thread() {
                @Override
                public void run() {
                    System.out.println(getName() + " 실행");
                    // 애시당초 getName() 메소드가 Thread 클래스에 정의되어 있으므로
                    // 상속받는 익명 자식 역시 getName() 메소드를 호출할 수 있다.
                    // 즉 별도의 객체 참조변수를 할당할 필요가 없다.
                }
            };
            threadA.start();
        }

        Thread chatThread = new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + " 실행");
            }
        };
        chatThread.setName("chat-thread");
        chatThread.start();
    }
} // 코드는 위애서부터 아래로 읽는 것
