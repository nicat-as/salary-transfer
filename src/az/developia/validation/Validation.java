package az.developia.validation;

import az.developia.domain.Amount;
import az.developia.util.LogUtil;

import java.math.BigDecimal;

public class Validation {
    public static void checkCurrency(Amount amount, Amount otherAmount) {
        LogUtil.printWithThread("Required : " + amount + " | balance : " + otherAmount);
        if (!amount.getCurrency().equals(otherAmount.getCurrency())) {
            throw new RuntimeException("prev currency : " + amount.getCurrency() + " currency: " + amount.getCurrency() + " is not valid");
        }
    }

    public static void checkNegativeAmount(Amount amount) {
        LogUtil.printWithThread("Required : " + amount);
        if (amount.getValue().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("value is negative : " + amount.getValue());
        }
    }

    public static void checkBalance(Amount amount, Amount otherAmount) {
        LogUtil.printWithThread("Required : " + amount + " | balance : " + otherAmount);
        if (amount.getValue().compareTo(otherAmount.getValue()) > 0) {
            throw new RuntimeException("balance not enough");
        }
    }
}
