public class JuridicalEntity extends Client {

    private static final int WITHDRAWAL_COMMISSION = 100;

    public boolean withdrawCash(int cash) {
        int withdrawFee = cash / WITHDRAWAL_COMMISSION;
        if (balance - cash - withdrawFee >= 0) {
            boolean result = super.withdrawCash(cash);
            if (result) {
                balance = balance - withdrawFee;
                System.out.println("Комиссия за снятие составляет " + withdrawFee + " рублей.");
                return true;
            }
            return false;
        } else {
            System.out.println("Вы не можете вывести сумму больше вашего остатка.");
            return false;
        }
    }

    public void getInformation() {
        System.out.println("Условие пополнения: беспроцентное.");
        System.out.println("Условие снятия: 1%.");
        getBalance();
    }
}