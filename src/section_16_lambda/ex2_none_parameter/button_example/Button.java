package section_16_lambda.ex2_none_parameter.button_example;

public class Button {
    @FunctionalInterface
    public static interface ClickListener {
        void onClick();
    } // 함수형 인터페이스

    private ClickListener clickListener;

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void click() {
        this.clickListener.onClick();
    }
}
