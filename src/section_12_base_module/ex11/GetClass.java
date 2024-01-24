package section_12_base_module.ex11;

public class GetClass {
    public static void main(String[] args) {
        Class classInfo = Car.class;

        getClassInfo(classInfo);
    }

    public static void getClassInfo(Class classInfo) {
        System.out.println("패키지 : " + classInfo.getPackageName());
        System.out.println("클래스 간단 이름 : " + classInfo.getSimpleName());
        System.out.println("클래스 전체 이름 : " + classInfo.getName());
    }
}
