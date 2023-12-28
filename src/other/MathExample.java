package other;

import java.util.Random;

public class MathExample {
    public static void main(String[] args) {
//        int number = (int) (Math.random() * 100);
//        System.out.println(number);

        Random randomNumber = new Random();
        System.out.println(randomNumber.nextInt(45));
        // nextInt()의 매개변수에 넣은 숫자 n은 0<= ~ <n 범위로 한정

        Random someNumber = new Random(2);
        Random otherNumber = new Random(2);

//        System.out.println(someNumber.nextInt(45));
//        System.out.println(otherNumber.nextInt(45));
        // 종자값이 같으면 같은 값 반환

        int[] someNumbers = new int[6];
        int[] otherNumbers = new int[6];

        for (int i=0; i<6; i++) {
            someNumbers[i] = someNumber.nextInt(45) + 1;
            System.out.print(someNumbers[i] + " ");
        }

        System.out.println();

        for (int i=0; i<6; i++) {
            otherNumbers[i] = otherNumber.nextInt(45) + 1;
            System.out.print(otherNumbers[i] + " ");
        }
        // 종자값이 같으면 같은 값 반환
    }
}
