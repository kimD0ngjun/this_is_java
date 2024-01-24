package section_12_base_module.ex12;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrintAnnotationExample {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Method[] declaredMethods = Service.class.getDeclaredMethods();
        for (Method method: declaredMethods) {
            PrintAnnotation printAnnotation = method.getAnnotation(
                    PrintAnnotation.class
            );
            // getAnnotation(AnnotationName.class) : 지정한 어노테이션 적용되어있으면 어노테이션 리턴, 안 그러면 null 리턴

            printLine(printAnnotation);
            method.invoke(new Service()); // 메소드 호출
            printLine(printAnnotation);
        }
    }

    private static void printLine(PrintAnnotation printAnnotation) {
        if (printAnnotation != null) {
            int number = printAnnotation.number(); // number() 속성값 얻기
            for (int i=0; i<number; i++) {
                String value = printAnnotation.value();
                System.out.print(value);
            }
            System.out.println();
        }
    }
}
