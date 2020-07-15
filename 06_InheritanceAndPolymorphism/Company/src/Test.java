import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Company coles = new Company();
        ArrayList<Employee> newEmployees = new ArrayList<>();

        //Найм 180 операторов, 80 менеджеров и 10 топ-менеджеров
        for (int i = 0; i < 180; i++) {
            newEmployees.add(new Operator());
        }
        for (int i = 0; i < 80; i++) {
            newEmployees.add(new Manager());
        }
        for (int i = 0; i < 10; i++) {
            newEmployees.add(new TopManager());
        }
        coles.hireAll(newEmployees);

        for (int i = 0; i < newEmployees.size(); i++) {
            System.out.print("Зарплата сотрудника " + (i + 1) + " составляет " + newEmployees.get(i).getMonthSalary() + " рублей. ");
            System.out.println("Сотрудник " + (i + 1) + " заработал для компании " + newEmployees.get(i).moneyEarned() + " рублей. ");
        }

        System.out.println("Доход компании за месяц составил " + coles.getIncome() + " рублей. ");

        //Увольнение 50% сотрудников
        for (int i = 0; i < newEmployees.size() / 2; i++) {
            coles.fire(newEmployees.get(i));
        }

        ArrayList<Employee> companyEmployees = coles.getEmployees();

        for (int i = 0; i < companyEmployees.size(); i++) {
            System.out.print("Зарплата сотрудника " + (i + 1) + " составляет " + companyEmployees.get(i).getMonthSalary() + " рублей. ");
            System.out.println("Сотрудник " + (i + 1) + " заработал для компании " + companyEmployees.get(i).moneyEarned() + " рублей. ");
        }

        //Списки самых низких и востребованных зарплат в компании
        coles.getLowestSalaryStaff(30);
        coles.getTopSalaryStaff(15);

    }
}