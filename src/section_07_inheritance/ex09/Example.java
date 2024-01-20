package section_07_inheritance.ex09;

public class Example {
    public static void main(String[] args) {
        Person person = new Person("무명");
        Person student = new Student("유명", 17);

        personInfo(person);
        System.out.println();
        personInfo(student);
    }

    public static void personInfo(Person person) {
        System.out.println("이름 : " + person.name);

        if (person instanceof Student student) {
            System.out.println("출석 번호 : " + student.studentNumber);
            student.walk();
            student.study();
        } else {
            person.walk();
        }
    }
}
