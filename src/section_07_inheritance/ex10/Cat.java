package section_07_inheritance.ex10;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println("애용");
    }
}
