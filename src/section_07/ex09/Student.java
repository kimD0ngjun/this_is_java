package section_07.ex09;

public class Student extends Person {
    int studentNumber;

    public Student(String name, int studentNumber) {
        super(name);
        this.studentNumber = studentNumber;
    }

    @Override
    public void walk() {
        System.out.println("학생이 걷기");
    }

    public void study() {
        System.out.println("공부");
    }
}
