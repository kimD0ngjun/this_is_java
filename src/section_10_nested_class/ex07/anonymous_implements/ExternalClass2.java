package section_10_nested_class.ex07.anonymous_implements;

public class ExternalClass2 {
    private Anonymous anonymous = new Anonymous() {
        @Override
        public void method() {
            System.out.println("External2 ON");
        }
    }; // implements 불필요

    public void externalMethod2() {
        anonymous.method();
    }
}
