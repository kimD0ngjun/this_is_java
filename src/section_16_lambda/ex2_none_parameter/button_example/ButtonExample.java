package section_16_lambda.ex2_none_parameter.button_example;

public class ButtonExample {
    public static void main(String[] args) {
        Button buttonOk = new Button();

        buttonOk.setClickListener(() -> System.out.println("Ok 버튼을 클릭함"));
        // 매개값으로 람다식 대입

        buttonOk.click();

        Button buttonCancel = new Button();

        buttonCancel.setClickListener(() -> System.out.println("Cancel 버튼을 클릭함"));
        // 매개값으로 람다식 대입

        buttonCancel.click();
    }
}
