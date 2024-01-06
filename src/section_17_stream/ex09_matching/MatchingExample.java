package section_17_stream.ex09_matching;

import java.util.Arrays;

public class MatchingExample {
    public static void main(String[] args) {
        // 매칭하냐 안하냐(boolean)

        int[] ints = {1, 2, 3, 4, 5};

        boolean result = Arrays.stream(ints)
                .allMatch(e -> e%2==0); // 스트림 소비, 변수는 재할당으로 재사용
        System.out.println("전부 짝수인가요 ? : " + result + "\n");

        result = Arrays.stream(ints)
                .anyMatch(e -> e%3==0); // 새로운 스트림 뿅. 아까 위에서 사용된 변수 재할당
        System.out.println("저들 중 하나라도 3의 배수인가요 ? : " + result + "\n");

        result = Arrays.stream(ints)
                .noneMatch(e -> e%3==0);
        System.out.println("쟤네들은 전부 3의 배수가 아니죠 ? : " + result);
    }
}
