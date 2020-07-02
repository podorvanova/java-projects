public class SoleTrader extends Client{

    public boolean depositCash(int cash) {
        int depositCommission;
        if (cash < 1000) {
            depositCommission = 100;
        } else {
            depositCommission = 200;
        }
        int depositFee = cash / depositCommission;
        boolean result = super.depositCash(cash - depositFee);
        if (result) {
            System.out.println("Комиссия пополнения составляет " + depositFee + " рублей.");
        }
        return result;
    }

    public void getInformation() {
        System.out.println("Условие пополнения: 1% - до 1000 рублей, либо 0.5% свыше 1000 рублей.");
        System.out.println("Условие снятия: беспроцентное.");
        getBalance();
    }
}
