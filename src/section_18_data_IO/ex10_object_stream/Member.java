package section_18_data_IO.ex10_object_stream;

import java.io.Serial;
import java.io.Serializable;

public class Member implements Serializable {
    @Serial
    private static final long serialVersionUID = 5609410980801882073L;
    private String id;
    private String name;

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " : " + name;
    }
}
