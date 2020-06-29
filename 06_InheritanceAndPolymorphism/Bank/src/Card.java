public class Card extends BankAccount {

    public void withdrawCash (double cash) {
        double withdrawFee = 0.01 * cash;
        if (balance - cash - withdrawFee >= 0) {
            super.withdrawCash(cash);
            balance = balance - withdrawFee;
        }
    }

    public boolean send(BankAccount receiver, double amount) {
        double sendFee = 0.01 * amount;
        return super.send(receiver, amount + sendFee);
    }
}
