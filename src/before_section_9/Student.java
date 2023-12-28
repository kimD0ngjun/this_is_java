package before_section_9;

public class Student extends Parent {
    public String name;

    public Student() {
        this("홍길동");
        System.out.println("before_section_9.Student() call");
    }

    public Student(String name) {
        this.name = name;
        System.out.println("before_section_9.Student(String name) call");
    }
}
