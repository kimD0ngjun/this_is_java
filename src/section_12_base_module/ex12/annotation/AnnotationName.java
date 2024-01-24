package section_12_base_module.ex12.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationName {
    String prop1();
    int prop2() default 1;
}
