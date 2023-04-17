package pl.sda.bankapp.model;

import pl.sda.bankapp.enums.AccountType;
import pl.sda.bankapp.enums.Currency;

import java.math.BigDecimal;

public class SavingAccount extends Account {

    private static final int MONTHLY_FEE = 3;

    private BigDecimal interestRate;

    public SavingAccount(long id,
                         long customerId,
                         String accountNumber,
                         Currency currency,
                         BigDecimal currentAmount) {

        super(id, customerId, accountNumber, currency, currentAmount, AccountType.SAVING);
    }


    @Override
    public void chargeAccount() {
        setCurrentAmount(getCurrentAmount().subtract(BigDecimal.valueOf(MONTHLY_FEE)));
    }

    // TODO: Scheduling
    public void addInterest() {
        BigDecimal interest = calculateInterest();
        BigDecimal total = getCurrentAmount().add(interest);
        setCurrentAmount(total);
    }

    private BigDecimal calculateInterest() {
        return getCurrentAmount().multiply(interestRate);
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
}
