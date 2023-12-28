package section_13_generic.ex4;

public class GenericExample {
    // T로는 Number 클래스 또는 Number의 하위 클래스만 사용
    public static <T extends Number> boolean compare(T t1, T t2) {
        System.out.println(
                "compare(" + t1.getClass().getSimpleName() + ", " +
                t2.getClass().getSimpleName() + ")");

        double v1 = t1.doubleValue();
        double v2 = t2.doubleValue();

        return (v1 == v2);
    }

    public static void main(String[] args) {
        boolean result1 = compare(10, 20);
        System.out.println(result1);

        System.out.println();

        boolean result2 = compare(4.5, 4.5);
        System.out.println(result2);
    }
}
