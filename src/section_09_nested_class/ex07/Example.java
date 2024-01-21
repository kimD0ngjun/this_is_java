package section_09_nested_class.ex07;

import section_09_nested_class.ex07.anonymous_child.ExternalClass;
import section_09_nested_class.ex07.anonymous_implements.ExternalClass2;

public class Example {
    public static void main(String[] args) {
        ExternalClass externalClass = new ExternalClass();
        externalClass.externalMethod();

        System.out.println();

        ExternalClass2 externalClass2 = new ExternalClass2();
        externalClass2.externalMethod2();
    }
}
