public class TopManager implements Employee {
    private int salary;
    private static final int MIN_SALARY = 100000;
    private static final int PERCENT_OF_SALARY = 150;
    private Company employeeCompany;

    public TopManager() {
        salary = generateBaseSalary();
    }

    public int getMonthSalary() {
        if (employeeCompany.getIncome() > 10000000) {
            return salary + salary * PERCENT_OF_SALARY / 100;
        }
        return salary;
    }

    private static int generateBaseSalary() {
        return MIN_SALARY + (int) (Math.random() * 21) * 1000;
    }

    public int moneyEarned() {
        return 0;
    }

    public void setCompany(Company employeeCompany) {
        this.employeeCompany = employeeCompany;
    }
}
