package section_16_lambda.ex6_constructor_reference;

public class Member {
    private String id;
    private String name;

    public Member(String id) {
        this.id = id;
        System.out.println("Member(String id)");
    }

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("Member(String id, String name)");
    }

    @Override
    public String toString() {
        return "{ id : " + this.id + ", name : " + this.name + " }";
    }
}
