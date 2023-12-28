package section_13_generic.ex5;

public class Course {
    // 어떤 타입이든 가능
    public static void registerCourse1(Applicant<?> applicant) {
        System.out.println(applicant.kind.getClass().getSimpleName() +
                "이(가) Course1을 등록함");
    }

    // Student와 자식 클래스인 HighStudent, MiddleStudent만 가능
    public static void registerCourse2(Applicant<? extends Student> applicant) {
        System.out.println(applicant.kind.getClass().getSimpleName() +
                "이(가) Course2를 등록함");
    }
    // Worker와 부모 클래스인 Person만 가능
    public static void registerCourse3(Applicant<? super Worker> applicant) {
        System.out.println(applicant.kind.getClass().getSimpleName() +
                "이(가) Course3를 등록함");
    }
}
