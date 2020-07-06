public class Individual extends Client {

    protected int getWithdrawalCommission(int commission) {
        return 0;
    }

    public void getInformation() {
        System.out.println("Условие пополнения: беспроцентное.");
        System.out.println("Условие снятия: беспроцентное.");
        getBalance();
    }
}