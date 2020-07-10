public class TopManager implements Employee {
    private int salary;
    private static final int MIN_SALARY = 100000;
    private static final int PERCENT_OF_SALARY = 150;

    public TopManager() {
        salary = generateBaseSalary();
    }

    public int getMonthSalary() {
        //to be done after Company class completing
        return salary;
    }

    private static int generateBaseSalary() {
        return MIN_SALARY + (int) (Math.random() * 21) * 1000;
    }
}
