package az.developia.domain;

import az.developia.domain.Amount;
import az.developia.util.LogUtil;

import static az.developia.validation.Validation.*;

public class BankAccount {
    private String iban;
    private Amount amount;

    public BankAccount(String iban, Amount amount) {
        this.iban = iban;
        this.amount = amount;
    }

    public void increaseBalance(Amount amount) {
        checkCurrency(amount, this.amount);
        checkNegativeAmount(amount);

        this.amount.setValue(
                this.amount.getValue().add(amount.getValue())
        );
    }

    public void decreaseBalance(Amount amount) {
        LogUtil.printWithThread("decreaseBalance start - amount: " + amount);
        checkCurrency(amount, this.amount);
        checkNegativeAmount(amount);
        checkBalance(amount, this.amount);

        this.amount.setValue(
                this.amount.getValue().add(amount.getValue().negate())
        );
        LogUtil.printWithThread("decreaseBalance end - amount: " + amount);
    }

    public Amount getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "iban='" + iban + '\'' +
                ", amount=" + amount +
                '}';
    }
}
