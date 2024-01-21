package section_10_nested_class.ex06;

public class ButtonExample {
    public static void main(String[] args) {
        // 객체 생성
        Button button = new Button();

        class OkListener implements Button.ClickListener {
            @Override
            public void onClick() {
                System.out.println("click OK button");
            }
        } // 먼저 정적 중첩 인터페이스를 구현하는 OK 리스너 클래스를 선언한 후...

        // 버튼 객체에 인터페이스 구현 객체 주입
        button.setClickListener(new OkListener());
        // 매개변수 타입이 인터페이스인데 왜 실현 객체가 들어갈 수 있냐면 다형성 때문
        // ClickListener clickListener = new OkListener();

        button.click(); // 그리고 메소드 실행~

        /* 다형성을 추가로 활용하자면... */

        // 이번엔 또 다른 인터페이스 구현 클래스 선언
        class CancelListener implements Button.ClickListener {
            @Override
            public void onClick() {
                System.out.println("click Cancel Button");
            }
        }

        button.setClickListener(new CancelListener());
    }
}
