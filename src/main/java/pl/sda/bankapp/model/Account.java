package pl.sda.bankapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.bankapp.enums.AccountType;
import pl.sda.bankapp.enums.Currency;
import pl.sda.bankapp.utils.AccountNumberGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
public abstract class Account {

    private Currency currency;
    private AccountType accountType;
    private final UUID id = UUID.randomUUID();
    private BigDecimal currentAmount = BigDecimal.ZERO;
    private final String accountNumber = AccountNumberGenerator.generate();

    public Account(Currency currency, AccountType accountType) {
        this.currency = currency;
        this.accountType = accountType;
    }

    public abstract void chargeAccount();

    public void deposit(BigDecimal depositAmount) {
        currentAmount = currentAmount.add(depositAmount);
    }

    public void withdraw(BigDecimal withdrawAmount) {
        if (currentAmount.compareTo(withdrawAmount) >= 0) {
            currentAmount = currentAmount.subtract(withdrawAmount);
        }
    }
}
