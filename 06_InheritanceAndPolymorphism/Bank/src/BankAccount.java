public class BankAccount {
    private int balance = 0;

    public void withdrawCash(int cash) {
        balance = balance - cash;
        System.out.println("Денежные средства в размере " + cash + " рублей выведены.");
    }

    public void putCash(int cash) {
        balance = balance + cash;
        System.out.println("Денежные средства в размере " + cash + " рублей зачислены.");
    }

    public int getBalance() {
        System.out.println("Баланс на счёте " + balance + " рублей.");
        return balance;
    }
}
