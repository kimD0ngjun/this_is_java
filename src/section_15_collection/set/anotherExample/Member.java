package section_15_collection.set.anotherExample;

public class Member {
    public String name;
    public int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age; // name값과 age가 같으면 동일한 해시코드 리턴
    }

    @Override
    public boolean equals(Object object) {
        if(object instanceof Member target) {
            return target.name.equals(name) && (target.age == age);
        } else {
            return false;
        } // name과 age가 같으면 true 리턴
    }

    // 최종적으로 동등성 확보
}
