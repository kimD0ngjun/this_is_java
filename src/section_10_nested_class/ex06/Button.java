package section_10_nested_class.ex06;

public class Button {
    // static nested interface
    public static interface ClickListener {
        // abstract method
        void onClick();
    }

    // field
    private ClickListener clickListener;

    // method (setter) for polymorphism
    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    // method
    public void click() {
        this.clickListener.onClick();
    }
}
