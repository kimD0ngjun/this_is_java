package section_14_multi_thread.ex6_synchronized_method.synchronized_block;

public class User1Thread extends Thread {
    private Calculator calculator;

    public User1Thread() {
        setName("첫 번째 스레드");
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        calculator.setMemory1(100);
    }
}
