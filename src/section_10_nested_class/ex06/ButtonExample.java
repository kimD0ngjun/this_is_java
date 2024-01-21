package section_10_nested_class.ex06;

public class ButtonExample {
    // 객체 생성
    Button buttonOK = new Button();

    class OkListner implements Button.ClickListener {
        @Override
        public void onClick() {
            System.out.println("click OK button");
        }
    } // 먼저 정적 중첩 인터페이스를 구현하는 OK 리스너 클래스를 선언한 후...
}
