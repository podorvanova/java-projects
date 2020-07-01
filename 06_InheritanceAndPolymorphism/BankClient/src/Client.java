public abstract class Client {
    protected double balance = 0;

    public boolean depositCash(double cash) {
        if (cash > 0) {
            balance = balance + cash;
            System.out.println("Денежные средства в размере " + cash + " рублей зачислены.");
            return true;
        } else {
            System.out.println("Сумма зачисления должна быть больше 0 рублей.");
            return false;
        }
    }

    public boolean withdrawCash(double cash) {
        if (cash > 0) {
            if (balance - cash >= 0) {
                balance = balance - cash;
                System.out.println("Денежные средства в размере " + cash + " рублей выведены.");
                return true;
            } else {
                System.out.println("Вы не можете вывести сумму больше вашего остатка.");
                return false;
            }
        } else {
            System.out.println("afeas");
            return false;
        }
    }

    public void getBalance() {
        System.out.println("Баланс на счёте " + balance + " рублей.");
    }

    public abstract void getInformation();
}
