public class SoleTrader extends Client{

    protected int getDepositCommission(int cash) {
        int depositCommission;
        if (cash < 1000) {
            depositCommission = 100;
        } else {
            depositCommission = 200;
        }
        return cash / depositCommission;
    }

    protected int getWithdrawalCommission(int commission) {
        return 0;
    }

    public void getInformation() {
        System.out.println("Условие пополнения: 1% - до 1000 рублей, либо 0.5% свыше 1000 рублей.");
        System.out.println("Условие снятия: беспроцентное.");
        getBalance();
    }
}