public class JuridicalEntity extends Client {

    private static final double WITHDRAWAL_COMMISSION = 0.01;

    public void withdrawCash(double cash) {
        double withdrawFee = WITHDRAWAL_COMMISSION * cash;
        if (balance - cash - withdrawFee >= 0) {
            super.withdrawCash(cash);
            balance = balance - withdrawFee;
            System.out.println("Комиссия за снятие составляет " + withdrawFee + " рублей.");
        } else {
            System.out.println("Вы не можете вывести сумму больше вашего остатка.");
        }
    }

    public void getInformation() {
        System.out.println("Условие пополнения: беспроцентное.");
        System.out.println("Условие снятия: 1%.");
        getBalance();
    }
}