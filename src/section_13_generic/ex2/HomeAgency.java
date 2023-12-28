package section_13_generic.ex2;

public class HomeAgency implements Rentable<Home> {
    @Override
    public Home rent(String homeName) {
        return new Home(homeName);
    }
}
