package section_14_multi_thread.ex5_thread_method.joinMethod;

public class SumThread extends Thread{
    private long sum;

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    @Override
    public void run() {
        for(int i=1; i<=100; i++) {
            sum+=i;
        }
    }
}
