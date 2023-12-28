package generic.ex5;

public class GenericExample {
    public static void main(String[] args) {
        Course.registerCourse1(new Applicant<>(new Person()));
        Course.registerCourse1(new Applicant<>(new Worker()));
        Course.registerCourse1(new Applicant<>(new Student()));
        Course.registerCourse1(new Applicant<>(new HighStudent()));
        Course.registerCourse1(new Applicant<>(new MiddleStudent()));

        System.out.println();

        Course.registerCourse2(new Applicant<>(new Student()));
        Course.registerCourse2(new Applicant<>(new HighStudent()));
        Course.registerCourse2(new Applicant<>(new MiddleStudent()));

        System.out.println();

        Course.registerCourse3(new Applicant<>(new Person()));
        Course.registerCourse3(new Applicant<>(new Worker()));
    }
}
