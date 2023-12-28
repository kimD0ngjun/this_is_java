package section_13_generic.ex2;

public interface Rentable<P> {
    P rent(String name);
}
