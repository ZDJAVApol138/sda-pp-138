package pl.sda.bankapp.model;

import pl.sda.bankapp.enums.AccountType;
import pl.sda.bankapp.enums.Currency;

import java.math.BigDecimal;

public class StandardAccount extends Account {

    private static final int MONTHLY_FEE = 5;

    public StandardAccount(Currency currency) {
        super(currency, AccountType.STANDARD);
    }

    @Override
    public void chargeAccount() {
        setCurrentAmount(getCurrentAmount().subtract(BigDecimal.valueOf(MONTHLY_FEE)));
    }
}
