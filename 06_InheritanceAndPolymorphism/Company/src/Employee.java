public interface Employee extends Comparable<Employee>{

    int getMonthSalary();

    void setCompany(Company employeeCompany);

    int moneyEarned();

    default int compareTo(Employee employee) {
        return Integer.compare(getMonthSalary(), employee.getMonthSalary());
    }
}
