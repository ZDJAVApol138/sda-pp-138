package pl.sda.bankapp.service;

import lombok.RequiredArgsConstructor;
import pl.sda.bankapp.model.Address;
import pl.sda.bankapp.model.Bank;
import pl.sda.bankapp.model.Customer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@RequiredArgsConstructor
public class BankService {

    private final Bank bank;
    private final Scanner scanner;
    private final AccountFactory accountFactory = new AccountFactory();

    public void listCustomers() {
        if (bank.getCustomers().size() == 0) {
            System.out.println("Customers list empty!");
            return;
        }
        System.out.println("Customers list: ");
        bank.listCustomer();
    }

    public void createCustomer() {
        String name = getString("Name: ");
        String surname = getString("Surname: ");
        String phone = getString("Phone: ");
        String email = getString("Email: ");
        String pesel = getString("Pesel: ");
        String city = getString("City: ");
        String street = getString("Street: ");
        String postCode = getString("Post code: ");
        String dateOfBirthSt = getString("Date of birth (dd/mm/yyyy): ");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthSt, formatter);

        Address address = new Address(city, street, postCode);
        Customer customer = new Customer(name, surname, phone, email, pesel, address, dateOfBirth);
        bank.addCustomer(customer);
    }

    private String getString(String text) {
        System.out.println(text);
        return scanner.nextLine();
    }
}
