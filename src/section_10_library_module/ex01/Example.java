package section_10_library_module.ex01;

import pack1.A;
import pack2.B;

public class Example {
    public static void main(String[] args) {
        A externalA = new A();
        externalA.method();

        System.out.println();

        B externalB = new B();
        externalB.method();
    }
}
