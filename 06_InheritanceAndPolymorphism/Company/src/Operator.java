public class Operator implements Employee {
    private final int salary;
    private static final int MIN_SALARY = 30000;
    private Company employeeCompany;

    public Operator() {
        salary = (int) (Math.random() * 6) * 1000 + MIN_SALARY;
    }

    public int getMonthSalary() {
        return salary;
    }

    public int moneyEarned() {
        return 0;
    }

    public void setCompany(Company employeeCompany) {
        this.employeeCompany = employeeCompany;
    }
}