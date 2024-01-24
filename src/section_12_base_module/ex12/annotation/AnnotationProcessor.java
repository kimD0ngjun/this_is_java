package section_12_base_module.ex12.annotation;

public class AnnotationProcessor {

    // 어노테이션을 처리하는 메서드
    public static void processAnnotation() {
        // 리플렉션을 사용하여 AnnotationExample 클래스의 어노테이션 값에 접근
        AnnotationName annotation = AnnotationExample.class.getAnnotation(AnnotationName.class);

        if (annotation != null) {
            String prop1Value = annotation.prop1();
            int prop2Value = annotation.prop2();

            // 어노테이션 값에 기반한 사용자 정의 로직 수행
            System.out.println("prop1Value: " + prop1Value);
            System.out.println("prop2Value: " + prop2Value);
        }
    }

    public static void main(String[] args) {
        // 어노테이션 처리 메서드 호출
        AnnotationProcessor.processAnnotation();
    }
}
