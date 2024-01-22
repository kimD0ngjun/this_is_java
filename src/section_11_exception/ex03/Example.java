package section_11_exception.ex03;

public class Example {
    public static void main(String[] args) {
        String[] array = {"100", "1oo"};

        for(int i=0; i<=array.length; i++) {
            try {
                int value = Integer.parseInt(array[i]);
                System.out.println("array[" + i + "] : " + value);
            } /* catch (Exception e) { // 모든 예외를 잡는 캐치 블록
                System.out.println(e.getMessage()); // 그래서 범위가 더 넓은 예외일 수록 더 뒤의 캐치 블록에 위치해야 한다
            } */ catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("배열 인덱스 초과 : " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("숫자 변환 예외 : " + e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage()); // 이런 식으로
            }
        }
    }
}
