package before_section_9;

import java.util.Scanner;

public class BankApplication {
    private static Account[] accounts = new Account[100];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. 계좌생성");
            System.out.println("2. 계좌목록");
            System.out.println("3. 예금");
            System.out.println("4. 출금");
            System.out.println("5. 종료");
            System.out.print("선택> ");

            String choose = scanner.nextLine();
            int chooseNumber = Integer.parseInt(choose);

            if (chooseNumber == 5) {
                System.out.println("프로그램 종료");
                break;
            }

            chooseList(chooseNumber);
        }
    }

    private static void chooseList(int chooseNumber) {
        if (chooseNumber == 1) {
            System.out.println("------------\n게좌생성\n------------");
            System.out.print("계좌번호: ");
            String accountNumber = scanner.nextLine();
            System.out.print("계좌주: ");
            String name = scanner.nextLine();
            System.out.print("초기입금액: ");
            String ammountString = scanner.nextLine();
            int amount = Integer.parseInt(ammountString);

            Account account = new Account(accountNumber, name, amount);
            for (int i = 0; i < accounts.length; i++) {
                if (accounts[i] == null) {
                    accounts[i] = account;
                    break;
                }
            }

            System.out.println("결과: 계좌가 생성되었습니다.");
        }

        if (chooseNumber == 2) {
            System.out.println("------------\n게좌목록\n------------");
            for(Account account : accounts) {
                if(account == null) {
                    break;
                }
                System.out.println(account.getAccountNumber() + "   " + account.getName() + "   " + account.getAmount());
            }
        }

        if (chooseNumber == 3) {
            System.out.println("------------\n예금\n------------");
            System.out.print("계좌번호: ");
            String accountNumber = scanner.nextLine();
            System.out.print("예금액: ");
            String input = scanner.nextLine();
            int inputAmount = Integer.parseInt(input);
            for(Account account : accounts) {
                if (account.getAccountNumber().equals(accountNumber)) {
                    account.inputAmount(inputAmount);
                    break;
                }
            }
        }

        if (chooseNumber == 4) {
            System.out.println("------------\n출금\n------------");
            System.out.print("계좌번호: ");
            String accountNumber = scanner.nextLine();
            System.out.print("예금액: ");
            String output = scanner.nextLine();
            int outputAmount = Integer.parseInt(output);
            for(Account account : accounts) {
                if (account.getAccountNumber().equals(accountNumber)) {
                    account.outputAmount(outputAmount);
                    break;
                }
            }
            System.out.println("결과: 출금이 성공되었습니다.");
        }
    }
}