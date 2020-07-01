public class JuridicalEntity extends Client {

    private static final double WITHDRAWAL_COMMISSION = 0.01;

    public boolean withdrawCash(double cash) {
        double withdrawFee = WITHDRAWAL_COMMISSION * cash;
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