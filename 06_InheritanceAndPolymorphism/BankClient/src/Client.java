public abstract class Client {
    protected double balance = 0;

    public void depositCash(double cash) {
        balance = balance + cash;
        System.out.println("Денежные средства в размере " + cash + " рублей зачислены.");
    }

    public void withdrawCash(double cash) {
        if (balance - cash >= 0) {
            balance = balance - cash;
            System.out.println("Денежные средства в размере " + cash + " рублей выведены.");
        } else {
            System.out.println("Вы не можете вывести сумму больше вашего остатка.");
        }
    }

    public void getBalance() {
        System.out.println("Баланс на счёте " + balance + " рублей.");
    }

    public abstract void getInformation();
}