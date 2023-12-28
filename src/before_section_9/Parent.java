package before_section_9;

public class Parent {
    public String nation;

    public Parent() {
        this("대한민국");
        System.out.println("before_section_9.Parent() call");
    }

    public Parent(String nation) {
        this.nation = nation;
        System.out.println("before_section_9.Parent(String nation) call");
    }
}
