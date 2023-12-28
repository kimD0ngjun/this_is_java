package section_13_generic.ex2;

public class Home {
    private String home;

    public Home(String home) {
        this.home = home;
    }

    public void turnOnLight() {
        int code = hashCode();
        System.out.println("사실 이 집의 이름은 " + home + "입니다.");
        System.out.println(code + " 집의 불을 킵니다.");
    }

    @Override
    public int hashCode() {
        return home.hashCode();
    }
}
