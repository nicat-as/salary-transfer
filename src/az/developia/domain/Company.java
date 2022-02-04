package az.developia.domain;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static az.developia.util.LogUtil.printWithThread;

public class Company {
    private String name;
    private BankAccount bankAccount;
    private List<Employee> employees;
    private ReentrantLock paySalaryLock;

    public Company(String name, BankAccount bankAccount, List<Employee> employees) {
        this.name = name;
        this.bankAccount = bankAccount;
        this.employees = employees;
        this.paySalaryLock = new ReentrantLock();
    }

    public void paySalaries(List<Employee> employees) {
        employees.forEach(e -> {
            printWithThread("Pay salary start for " + e.getId());
            try {
                this.paySalaryLock.lock();
                bankAccount.decreaseBalance(e.getSalary());
                try {
                    e.paySalary();
                } catch (Exception ex) {
                    bankAccount.increaseBalance(e.getSalary());
                }
                printWithThread("bank remaining balance: " + bankAccount.getAmount());
                this.paySalaryLock.unlock();
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException("Couldn't pay salary of employee : " + e.getName() + " id: " + e.getId());
            }

            printWithThread("Pay salary end for " + e.getId());

        });
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }


}
