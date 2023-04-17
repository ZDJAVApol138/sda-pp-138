package pl.sda.bankapp.model;

import pl.sda.bankapp.enums.AccountType;
import pl.sda.bankapp.enums.Currency;

import java.math.BigDecimal;

public class PremiumAccount extends Account {

    private static final int MONTHLY_FEE = 10;

    public PremiumAccount(long id,
                          long customerId,
                          String accountNumber,
                          Currency currency,
                          BigDecimal currentAmount) {

        super(id, customerId, accountNumber, currency, currentAmount, AccountType.PREMIUM);
    }

    @Override
    public void chargeAccount() {
        setCurrentAmount(getCurrentAmount().subtract(BigDecimal.valueOf(MONTHLY_FEE)));
    }
}
