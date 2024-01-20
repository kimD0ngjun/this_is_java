package section_07_inheritance.ex10;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println("멍멍");
    }
}
