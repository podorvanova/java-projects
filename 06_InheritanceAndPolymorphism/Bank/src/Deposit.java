import java.time.LocalDate;

public class Deposit extends BankAccount{
    private LocalDate lastDepositDay;

    public void withdrawCash(double cash) {
        if (lastDepositDay.plusDays(30).isBefore(LocalDate.now())) {
            super.withdrawCash(cash);
        } else {
            System.out.println("Последнее пополнее было меньше месяца назад. Снятие наличных не возможно.");
        }
    }

    public void putCash(double cash) {
        super.putCash(cash);
        lastDepositDay = LocalDate.now();
    }
 }