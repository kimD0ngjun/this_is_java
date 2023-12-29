package section_14_multi_thread.ex6_synchronized_method.synchronized_block;

public class User2Thread extends Thread {
    private Calculator calculator;

    public User2Thread() {
        setName("두 번째 스레드");
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        calculator.setMemory2(50);
    }
}
