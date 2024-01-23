package section_12_base_module.ex03;

public class ObjectExample {
    private String id;
    private int number;
    private String info;

    public ObjectExample(String id, int number, String info) {
        this.id = id;
        this.number = number;
        this.info = info;
    }

    @Override
    // Object 클래스의 메소드 equals(Object object) 오버라이딩
    public boolean equals(Object object) {
        if(object instanceof ObjectExample objectExample) {
            if (id.equals(objectExample.id)) {
                return true;
            }
        }

        return false;
    }

    @Override
    // Object 클래스의 메소드 hashCode() 오버라이딩
    public int hashCode() {
        return number + id.hashCode();
    }

    @Override
    // Object 클래스의 메소드 toString() 오버라이딩
    public String toString() {
        return id + " : " + info;
    }
}
