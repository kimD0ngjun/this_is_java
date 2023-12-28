package other.exception.parctice5;

public class Practice5 implements AutoCloseable {
    private String name;

    public Practice5(String name) {
        this.name = name;
        System.out.println("[MyResource(" + name + ") 열기]");
    }

    public String read1() {
        System.out.println("[MyResource(" + this.name + ") 읽기]");
        return "100";
    }

    public String read2() {
        System.out.println("[MyResource(" + this.name + ") 읽기]");
        return "abc";
    }

    @Override
    public void close() throws Exception {
        System.out.println("[MyResource(" + this.name + ") 닫기]");
    }
}
