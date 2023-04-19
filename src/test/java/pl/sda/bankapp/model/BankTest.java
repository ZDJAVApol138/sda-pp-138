package pl.sda.bankapp.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import pl.sda.bankapp.exception.NotFoundException;

import java.util.UUID;

class BankTest {

    private Bank bank;

    @BeforeEach
    void setup() {
        bank = new Bank("Test Bank");
    }

    @Test
    void testFindCustomerNotFound() {
        // given
        String nonExisingPesel = UUID.randomUUID().toString();

        // when
        Executable executable = () -> bank.findCustomer(nonExisingPesel);

        // then
        Assertions.assertThrows(NotFoundException.class, executable);
    }

    @Test
    void testFindCustomerSuccess() {
        // given
        String pesel = "99061902390";
        Customer expectedCustomer = new Customer();
        expectedCustomer.setPesel(pesel);

        bank.addCustomer(expectedCustomer);

        // when
        Customer actualCustomer = bank.findCustomer(pesel);

        // then
        Assertions.assertEquals(expectedCustomer, actualCustomer);
    }
}