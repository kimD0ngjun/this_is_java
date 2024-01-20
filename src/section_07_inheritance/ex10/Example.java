package section_07_inheritance.ex10;

public class Example {
    public static void main(String[] args) {
//        Animal animal = new Animal("동물"); // 불가능
        Animal animal = new Dog("진돌이");
        System.out.println("이름 : " + animal.name);
        animal.breathe();
        animal.sound();

        animal = new Cat("애용이");
        System.out.println("이름 : " + animal.name);
        animal.breathe();
        animal.sound();
    }
}
