public class Card extends BankAccount {

    public void withdrawCash (double cash) {
        double withdrawFee = 0.01 * cash;
        super.withdrawCash(cash + withdrawFee);
    }

    public boolean send(BankAccount receiver, double amount) {
        double sendFee = 0.01 * amount;
        return super.send(receiver, amount + sendFee);
    }
}
