package section_12_base_module.ex12;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 적용 대상 지정 : 메소드
@Retention(RetentionPolicy.RUNTIME) // 실행 정책 : 실행할 때 적용해서 계에속
public @interface PrintAnnotation {
    String value() default "-"; // "-"의 종류
    int number() default 15; // 출력 횟수
}
