package other.exception.practice8;

public class Account {
    private long balance;

    public Account() {
    }

    public long getBalance() {
        return balance;
    }

    public void deposit(int money) {
        this.balance += money;
    }

    public void withdraw(int money) throws InsufficientException {
        if(this.balance < money) {
            throw new InsufficientException("잔고 부족: " + (money-this.balance) + " 부족");
        }
        this.balance -= money;
    }
}
