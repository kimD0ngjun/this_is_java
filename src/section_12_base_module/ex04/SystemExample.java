package section_12_base_module.ex04;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class SystemExample {
    public static void main(String[] args) {
//        System.out.println();
//
//        System.out.println(System.currentTimeMillis() + "\n");
//        System.out.println(System.nanoTime() + "\n");
//        System.out.println(System.getProperties() + "\n");
//        System.out.println(System.getenv() + "\n");
//
//        System.out.println();


//        try {
//            int value = Integer.parseInt("sbc");
//        } catch(NumberFormatException e) {
//            System.err.println("에러"); // 붉으스름하게 나타남
//            System.err.println(e.getMessage()); // 붉으스름하게 나타남
//        }

//        long time1 = System.nanoTime();
//        int sum = 0;
//        for(int i = 1; i <= 1_000_000; i++) {
//            sum += i;
//        }
//        long time2 = System.nanoTime();
//
//        System.out.println("총합 : " + sum);
//        System.out.println("소요 시간 : " + (time2 - time1));

        String data = "자바";

        // 문자열을 바이트 배열로 변환 (인코딩: UTF-8)
        byte[] array1 = data.getBytes(StandardCharsets.UTF_8);
        System.out.println("array1 : " + Arrays.toString(array1));

        // 바이트 배열을 문자열로 변환 (디코딩: UTF-8)
        String string1 = new String(array1, StandardCharsets.UTF_8);
        System.out.println("string1 : " + string1);

        try {
            // 바이트 배열을 문자열로 변환 (디코딩: EUC-KR)
            byte[] array2 = data.getBytes("EUC-KR");
            String string2 = new String(array2, "EUC-KR");
            System.out.println("array2 : " + Arrays.toString(array2));
            System.out.println("string2 : " + string2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
