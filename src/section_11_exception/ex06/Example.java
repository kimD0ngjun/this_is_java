package section_11_exception.ex06;

import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();

        try {
            count(amount);
        } catch (UnderAmountException e) {
            System.err.println(e.getMessage()); // 떠넘겨진 예외 처리 : 메시지 출력
        }
    }

    public static void count(int amount) throws UnderAmountException { // 예외 처리 떠넘기기
        if (amount < 10) {
            throw new UnderAmountException("[입력값 : " + amount + "] 10보다 작은 값을 입력");
        } // 조건부 예외 발생(두 번째 생성자 호출)
    }
}
