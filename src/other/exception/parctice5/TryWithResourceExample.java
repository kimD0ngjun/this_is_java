package other.exception.parctice5;

public class TryWithResourceExample {
    public static void main(String[] args) {
        try (Practice5 res = new Practice5("A")) {
            String data = res.read1();
            int value = Integer.parseInt(data);
        } catch(Exception e) {
            System.out.println("예외 처리: " + e.getMessage());
        }

        System.out.println();

        try (Practice5 res = new Practice5("A")) {
            String data = res.read2();
            int value = Integer.parseInt(data); // NFE 발생
        } catch(Exception e) {
            System.out.println("예외 처리: " + e.getMessage());
        }

        System.out.println();

        Practice5 res1 = new Practice5("A");
        Practice5 res2 = new Practice5("B");

        try (res1; res2) {
            String data1 = res1.read1();
            String data2 = res2.read1();
        } catch(Exception e) {
            System.out.println("예외 처리: " + e.getMessage());
        }
    }
}
