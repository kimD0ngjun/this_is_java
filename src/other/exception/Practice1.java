package other.exception;

public class Practice1 {
    public static void main(String[] args) {
        printLength("아 배고파");
        printLength("");
        printLength(null);
    }

    public static void printLength(String data) {
        try {
            int length = data.length();
            System.out.println("문자 수: " + length);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println(e); // 어떤 종류의 에러인지까지
            e.printStackTrace(); // 시뻘건 메시지들이 얘였네
        } finally {
            System.out.println("마무리");
        }
    }
}