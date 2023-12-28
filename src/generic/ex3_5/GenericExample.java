package generic.ex3_5;

public class GenericExample {
    // 메소드 레벨에서 타입 선언 : 제네릭 메소드
    public static <T> Box<T> boxing(T t) {
        Box<T> box = new Box<>();
        box.setT(t);
        return box;
    }

    public static void main(String[] args) {
//        Box<Integer> intBox = new Box<>();
//        intBox.setT(100);

//        Box<Integer> intBox = boxing(100);
//        int intBoxValue = intBox.getT();

        Box intBox = boxing(100);
        int intBoxValue = (int) intBox.getT(); 
        // 타입 추론을 하지 않으면서 Object 타입으로 지정되므로 강제 타입 캐스팅 필요

        System.out.println(intBoxValue);

        Box<String> strBox = new Box<>();
        strBox.setT("박스");
        String strBoxValue = strBox.getT();
        System.out.println(strBoxValue);
    }
}
