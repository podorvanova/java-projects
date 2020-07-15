import java.util.ArrayList;
import java.util.List;

public class Company {
    private ArrayList<Employee> employees = new ArrayList<>();

    public int getIncome() {
        int income = 0;
        for (Employee employee : employees) {
            income += employee.moneyEarned();
        }
        return income;
    }

    public void hire(Employee employee) {
        employee.setCompany(this);
        employees.add(employee);
    }

    public void hireAll(List<Employee> employees) {
        for (Employee employee : employees) {
            hire(employee);
        }
    }

    public void fire(Employee employee) {
        employee.setCompany(null);
        employees.remove(employee);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}
