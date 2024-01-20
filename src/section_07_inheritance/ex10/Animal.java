package section_07_inheritance.ex10;

public abstract class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
    }

    public void breathe() {
        System.out.println("숨 쉼");
    }

    public abstract void sound();
}
