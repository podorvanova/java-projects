public class SoleTrader extends Client{

    public void depositCash(double cash) {
        double depositCommission;
        if (cash < 1000) {
            depositCommission = 0.01;
        } else {
            depositCommission = 0.005;
        }
        double depositFee = cash * depositCommission;
        super.depositCash(cash - depositFee);
        System.out.println("Комиссия пополнения составляет " + depositFee + " рублей.");
    }

    public void getInformation() {
        System.out.println("Условие пополнения: 1% - до 1000 рублей, либо 0.5% свыше 1000 рублей.");
        System.out.println("Условие снятия: беспроцентное.");
        getBalance();
    }
}
