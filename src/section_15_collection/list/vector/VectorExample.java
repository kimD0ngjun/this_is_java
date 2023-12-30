package section_15_collection.list.vector;

import java.util.List;
import java.util.Vector;

// ArrayList랑 내부 구조는 같지만, 얘는 '동기화' 메소드로 구현돼서 멀티 스레드가 동시에 실행 불가
// 즉, 외부의 침입 없이 '안전하게' 객체 추가 또는 삭제 가능
public class VectorExample {
    public static void main(String[] args) {
        List<Board> list = new Vector<>(); // 동기화된 메소드(여기서는 Vector의 add())로 구성

        Thread threadA = new Thread() {
            @Override
            public void run() {
                for(int i=1; i<=1000; i++) {
                    list.add(new Board("제목" + i, "내용" + i, "글쓴이" + i));
                }
            }
        };

        Thread threadB = new Thread() {
            @Override
            public void run() {
                for(int i=1; i<=1000; i++) {
                    list.add(new Board("제목" + i, "내용" + i, "글쓴이" + i));
                }
            }
        };

        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
            // 현재 실행 중인 스레드(main 스레드)가 threadA와 threadB가 모두 종료될 때까지 기다림
        } catch(Exception e) {}

        int size = list.size();
        System.out.println("총 객체 수 : " + size);
        System.out.println();
    }
}
