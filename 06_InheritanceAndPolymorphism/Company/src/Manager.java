public class Manager implements Employee{
    private final int salary;
    private static final int MIN_SALARY = 40000;
    private static final int PERCENT_MONEY_EARNED = 5;

    public Manager() {
        salary = generateBaseSalary() + moneyEarned() * PERCENT_MONEY_EARNED / 100;
    }

    public int getMonthSalary() {
        return salary;
    }

    private static int generateBaseSalary() {
        return MIN_SALARY + (int) (Math.random() * 6) * 1000;
    }

    private int moneyEarned() {
        int moneyEarned = (int) (Math.random() * 25000) + 115000;
        return moneyEarned;
    }
}
