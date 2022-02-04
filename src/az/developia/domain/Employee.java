package az.developia.domain;

public class Employee {
    private Long id;
    private String name;
    private String department;
    private Amount salary;
    private BankAccount account;

    public Employee(Long id, String name, String department, Amount salary, BankAccount account) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.account = account;
    }

    public void paySalary() {
        this.account.increaseBalance(this.salary);
    }

    public Amount getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", account=" + account +
                '}';
    }
}
