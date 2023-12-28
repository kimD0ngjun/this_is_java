package before_section_9;

public class Account {
    private String accountNumber;
    private String name;
    private int amount;

    // 단위 계좌생성
    public Account(String accountNumber, String name, int amount) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    // 단위 계좌 목록 확인
    public void checkAccount() {
        System.out.println("------------\n게좌목록\n------------");
        System.out.println(this.accountNumber + "    " + this.name + "    " + this.amount);
    }

    // 예금 메소드
    public void inputAmount(int inputAmount) {
        this.amount = this.amount + inputAmount;
    }

    // 출금 메소드
    public void outputAmount(int outputAmount) {
        this.amount = this.amount - outputAmount;
    }
}
