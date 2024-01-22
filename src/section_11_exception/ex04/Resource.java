package section_11_exception.ex04;

public class Resource implements AutoCloseable {
    private String name;

    public Resource(String name) {
        this.name = name;
        System.out.println("[MyResource(" + name + ") 열기]");
    }

    // try-with-resources 블록을 사용하려면 해당 리소스는 AutoCloseable의 인터페이스를 구현해서
    // AutoCloseable 인터페이스의 close() 메소드를 재정의해야 한다.
    @Override
    public void close() throws Exception {
        System.out.println("[MyResource(" + this.name + ") 닫기]");
    }

    public String read1() {
        System.out.println("[MyResource(" + this.name + ") 읽기]");
        return "100";
    }

    public String read2() {
        System.out.println("[MyResource(" + this.name + ") 읽기]");
        return "abc";
    }
}
