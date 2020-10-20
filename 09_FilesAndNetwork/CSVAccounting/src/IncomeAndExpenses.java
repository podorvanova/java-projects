public class IncomeAndExpenses {
    public double income;
    public double expenses;

    public IncomeAndExpenses(double income, double expenses) {
        this.income = income;
        this.expenses = expenses;
    }

    public static IncomeAndExpenses sum(IncomeAndExpenses incomeAndExpenses1, IncomeAndExpenses incomeAndExpenses2) {
        return new IncomeAndExpenses(
                incomeAndExpenses1.income + incomeAndExpenses2.income,
                incomeAndExpenses1.expenses + incomeAndExpenses2.expenses
        );
    }
}
