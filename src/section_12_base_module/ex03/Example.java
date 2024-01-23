package section_12_base_module.ex03;

public class Example {
    private String id;
    private int number;
    private String info;

    public Example(String id, int number, String info) {
        this.id = id;
        this.number = number;
        this.info = info;
    }

    @Override
    // Object 클래스의 메소드 equals(Object object) 오버라이딩
    public boolean equals(Object object) {
        if(object instanceof Example example) {
            if (id.equals(example.id)) {
                return true;
            }
        }

        return false;
    }
}
