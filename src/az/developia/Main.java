package az.developia;

import az.developia.domain.*;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var e1 = new Employee(1L, "Ben", "marketing", new Amount(BigDecimal.valueOf(700), Currency.AZN), new BankAccount("ibanE1", new Amount(BigDecimal.valueOf(150), Currency.AZN)));
        var e2 = new Employee(2L, "John", "it", new Amount(BigDecimal.valueOf(500), Currency.AZN), new BankAccount("ibanE1", new Amount(BigDecimal.valueOf(150), Currency.AZN)));
        var e3 = new Employee(3L, "Hugh", "hr", new Amount(BigDecimal.valueOf(800), Currency.AZN), new BankAccount("ibanE1", new Amount(BigDecimal.valueOf(150), Currency.AZN)));
        var e4 = new Employee(4L, "Tom", "it", new Amount(BigDecimal.valueOf(850), Currency.AZN), new BankAccount("ibanE1", new Amount(BigDecimal.valueOf(150), Currency.AZN)));
        var e5 = new Employee(5L, "Luke", "marketing", new Amount(BigDecimal.valueOf(750), Currency.AZN), new BankAccount("ibanE1", new Amount(BigDecimal.valueOf(150), Currency.AZN)));

        var company = new Company("A company",
                new BankAccount("ibanACompany",
                        new Amount(BigDecimal.valueOf(2000), Currency.AZN)
                ),
                List.of(e1, e2, e3, e4, e5)
        );

        for (int i = 0; i < 5; i++) {
            var empSize = company.getEmployees().size();
            var emp = company
                    .getEmployees()
                    .subList(i, i + empSize / 5);
            new Thread(() -> company.paySalaries(emp)).start();

        }
    }
}
