package section_15_collection.tree.comparable;

public class Person implements Comparable<Person>{
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person person) {
        if(this.age < person.age) return -1;
        else if(this.age == person.age) return 0;
        else return 1;
    }
}
