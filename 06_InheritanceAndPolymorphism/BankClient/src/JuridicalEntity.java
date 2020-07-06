public class JuridicalEntity extends Client {

    private static final int WITHDRAWAL_COMMISSION = 100;

    protected int getWithdrawalCommission(int cash) {
        return cash / WITHDRAWAL_COMMISSION;
    }

    public void getInformation() {
        System.out.println("Условие пополнения: беспроцентное.");
        System.out.println("Условие снятия: 1%.");
        getBalance();
    }
}