package pl.sda.bankapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.sda.bankapp.enums.AccountType;
import pl.sda.bankapp.enums.Currency;
import pl.sda.bankapp.model.Account;
import pl.sda.bankapp.model.PremiumAccount;
import pl.sda.bankapp.model.SavingAccount;
import pl.sda.bankapp.model.StandardAccount;

import java.util.stream.Stream;

class AccountFactoryTest {

    public static Stream<Arguments> supplier() {
        return Stream.of(
                Arguments.of(Currency.PLN, AccountType.SAVING, SavingAccount.class),
                Arguments.of(Currency.USD, AccountType.STANDARD, StandardAccount.class),
                Arguments.of(Currency.GBP, AccountType.PREMIUM, PremiumAccount.class)
        );
    }

    @ParameterizedTest
    @MethodSource("supplier")
    void testCreateAccount(Currency currency, AccountType accountType, Class<Account> clazz) {
        // given
        AccountFactory accountFactory = new AccountFactory();

        // when
        Account account = accountFactory.createAccount(accountType, currency);

        // then
        Assertions.assertEquals(clazz, account.getClass());
        Assertions.assertEquals(currency, account.getCurrency());
        Assertions.assertEquals(accountType, account.getAccountType());
    }
}