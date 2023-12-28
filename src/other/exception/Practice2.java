package other.exception;

public class Practice2 {
    public static void main(String[] args) {
        String[] array = {"100", "1oo"};

        for(int i = 0; i<=array.length; i++) {
            try {
                int value = Integer.parseInt(array[i]);
                System.out.println("array[" + i + "]: " + value);
            } catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("배열 인덱스 오버: " + e.getMessage());
            } catch(NumberFormatException e) {
                System.out.println("숫자 변환 불가: " + e.getMessage());
            }
        }
    }
}
