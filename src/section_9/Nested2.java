package section_9;

public class Nested2 {
    String field = "Out-Field";

    void method() {
        System.out.println("Out-Method");
    }

    class Inner {
        String field = "In-Field";

        void method() {
            System.out.println("In-Method");
        }

        void print() {
            System.out.println(this.field);
            this.method();

            System.out.println(Nested2.this.field);
            Nested2.this.method();
        }
    }

    void useInnerClass() {
        Inner inner = new Inner();
        inner.print();
    }
}
