package section_13_generic.ex3;

public class Box<T> {
    public T content;

    public boolean compare(Box<T> otherContent) {
        boolean result = content.equals(otherContent.content);
        return result;
    }
}
