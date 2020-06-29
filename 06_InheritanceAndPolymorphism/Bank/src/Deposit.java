import java.time.LocalDate;

public class Deposit extends BankAccount{
    private LocalDate lastDepositDay;

    public void withdrawCash(double cash) {
        if (lastDepositDay.plusDays(30).isBefore(LocalDate.now())) {
            super.withdrawCash(cash);
        } else {
            System.out.println("Последнее пополнение было меньше месяца назад. Снятие наличных невозможно.");
        }
    }

    public void putCash(double cash) {
        super.putCash(cash);
        lastDepositDay = LocalDate.now();
    }

    public boolean send(BankAccount receiver, double amount) {
        if (lastDepositDay.plusDays(30).isBefore(LocalDate.now())) {
            return super.send(receiver, amount);
        } else {
            System.out.println("Последнее пополнение было меньше месяца назад. Перевод денежных средств невозможен.");
            return false;
        }
    }
 }