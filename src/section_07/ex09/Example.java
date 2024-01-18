package section_07.ex09;

public class Example {
    public static void main(String[] args) {

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
