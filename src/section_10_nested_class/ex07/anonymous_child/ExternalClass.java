package section_10_nested_class.ex07.anonymous_child;

public class ExternalClass {
    private Anonymous a = new Anonymous() {
        @Override
        public void method() {
            System.out.println("External ON");
        }
    }; // extends 불필요

    public void externalMethod() {
        a.method();
    }
}
