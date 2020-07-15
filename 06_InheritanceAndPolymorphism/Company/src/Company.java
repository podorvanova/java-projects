import java.util.ArrayList;
import java.util.Comparator;
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

    public ArrayList<Employee> getLowestSalaryStaff(int count) {
        if (count <= 0 || count > employees.size()) {
            System.out.println("count не должен быть отрицательным и превышать количество сотрудников в компании.");
            return null;
        } else {
            employees.sort(Comparator.comparingInt(Employee::getMonthSalary));
            ArrayList<Employee> sortedLowestSalary = new ArrayList<>();
            System.out.println("Список минимальных зарплат в компании:");
            for (int i = 0; i < count; i++) {
                sortedLowestSalary.add(employees.get(i));
                System.out.println((i + 1) + ". " + employees.get(i).getMonthSalary() + " рублей.");
            }
            return sortedLowestSalary;
        }
    }

    public ArrayList<Employee> getTopSalaryStaff(int count) {
        if (count <= 0 || count > employees.size()) {
            System.out.println("count не должен быть отрицательным и превышать количество сотрудников в компании.");
            return null;
        } else {
            employees.sort(Comparator.comparingInt(Employee::getMonthSalary).reversed());
            ArrayList<Employee> sortedTopSalary = new ArrayList<>();
            System.out.println("Список максимальных зарплат в компании:");
            for (int i = 0; i < count; i++) {
                sortedTopSalary.add(employees.get(i));
                System.out.println((i + 1) + ". " + employees.get(i).getMonthSalary() + " рублей.");
            }
            return sortedTopSalary;
        }
    }
}
