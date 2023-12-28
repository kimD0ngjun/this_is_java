package generic.ex3;

public class GenericExample {
    public static void main(String[] args) {
//        Box box1 = new Box();
        Box<String> box1 = new Box<>();
        box1.content = "100";

        Box box2 = new Box();
        box2.content = "100";

        Box box3 = new Box();
        box3.content = "200";

        Box box4 = new Box();
        box4.content = 100;

        boolean result1 = box1.compare(box2);
        boolean result2 = box1.compare(box3);
        boolean result3 = box1.compare(box4);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
