package pl.sda.bankapp.model;


import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import pl.sda.bankapp.enums.Currency;
import pl.sda.bankapp.exception.NotFoundException;
import pl.sda.bankapp.utils.AccountNumberGenerator;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;

class CustomerTest {

    @Test
    void testConstructorLogic() {
        // given
        Faker faker = new Faker();
        Name name = faker.name();

        String firstName = name.firstName();
        String lastName = name.lastName();
        String phoneNumber = faker.phoneNumber().phoneNumber();
        String email = faker.internet().emailAddress();
        String city = faker.address().city();
        String postCode = faker.address().zipCode();
        String street = faker.address().streetAddress();
        String pesel = faker.idNumber().valid();

        LocalDate dateOfBirth = faker.date().birthday()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        Address address = new Address(city, street, postCode);

        int expectedAge = Period.between(dateOfBirth, LocalDate.now()).getYears();

        // when
        Customer customer = new Customer(
                firstName, lastName, phoneNumber, email, pesel, address, dateOfBirth
        );
        int actualAge = customer.getAge();

        // then
        Assertions.assertEquals(expectedAge, actualAge);
    }

    @Test
    void testAddAccountSuccess() {
        // given
        Customer customer = new Customer();
        Account account = new StandardAccount(Currency.USD);
        List<Account> accounts = customer.getAccounts();

        // when
        boolean added = customer.addAccount(account);

        // then
        Assertions.assertTrue(added);
        Assertions.assertTrue(accounts.contains(account));
    }

    @Test
    void testRemoveAccountSuccess() {
        //given
        Customer customer = new Customer();
        Account account = new SavingAccount(Currency.EUR);
        List<Account> accounts = customer.getAccounts();
        customer.addAccount(account);

        //when
        boolean removed = customer.removeAccount(account);

        //then
        Assertions.assertTrue(removed);
        Assertions.assertFalse(accounts.contains(account));
    }

    @Test
    void testGetAccountSuccess() {
        // given
        Customer customer = new Customer();
        Account expectedAccount = new PremiumAccount(Currency.PLN);
        customer.addAccount(expectedAccount);
        String accountNumber = expectedAccount.getAccountNumber();

        // when
        Account actualAccount = customer.getAccount(accountNumber);

        // then
        Assertions.assertEquals(expectedAccount, actualAccount);
    }

    @Test
    void testGetAccountNotFound() {
        // given
        Customer customer = new Customer();
        String expectedMessage = "Account not found!";
        String nonExistingAccountNumber = AccountNumberGenerator.generate();

        // when
        Executable executable = () -> customer.getAccount(nonExistingAccountNumber);

        // then
        NotFoundException ex = Assertions.assertThrows(NotFoundException.class, executable);
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }
}