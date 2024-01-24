package section_12_base_module.ex11;

// 자바는 클래스와 인터페이스의 메타 정보를 Class 객체로 관리한다.
// 메타 정보 : 패키지 정보, 타입 정보, 멤버(생성자, 필드, 메소드) 정보 등을 일컫고
// 이런 메타 정보를 프로그램에서 읽고 수정하는 행위를 리플렉션(reflection)이라고 한다.

// 이거 외에도 class 파일 저장 위치를 통해 getResource(파일명).getPath() 메소드를 활용해서 파일 절대경로를 얻을 수 있다

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class GetClass {
    public static void main(String[] args) {
        Class classInfo = Car.class;

        getClassInfo(classInfo);
        System.out.println();
        getMemberInfo(classInfo);
    }

    public static void getClassInfo(Class classInfo) {
        System.out.println("패키지 : " + classInfo.getPackageName());
        System.out.println("클래스 간단 이름 : " + classInfo.getSimpleName());
        System.out.println("클래스 전체 이름 : " + classInfo.getName());
    }

    public static void getMemberInfo(Class classInfo) {
        System.out.println("[생성자 정보]");

        Constructor[] constructors = classInfo.getDeclaredConstructors();
        for (Constructor constructor: constructors) {
            System.out.print(constructor.getName() + "(");
            Class[] parameters = constructor.getParameterTypes();
            printParameters(parameters);
            System.out.println(")");
        }

        System.out.println("\n\n[필드 정보]");

        Field[] fields = classInfo.getDeclaredFields();
        for(Field field: fields) {
            System.out.print(field.getType().getName() + " " + field.getName() + ", ");
        }

        System.out.println("\n\n[메소드 정보]");

        Method[] methods = classInfo.getDeclaredMethods();
        for(Method method: methods) {
            System.out.print(method.getName() + "(");
            Class[] parameters = method.getParameterTypes();
            printParameters(parameters);
            System.out.println(")");
        }
    }

    private static void printParameters(Class[] parameters) {
        for(int i=0; i<parameters.length; i++) {
            System.out.print(parameters[i]. getName());
            if (i< parameters.length - 1) {
                System.out.print(", ");
            }
        }
    }
}
