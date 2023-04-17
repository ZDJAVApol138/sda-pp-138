package pl.sda.bankapp.model;


import pl.sda.bankapp.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;


public class Bank {

    private final String name;
    private final List<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void listCustomer() {
        customers.forEach(System.out::println);
    }

    public boolean addCustomer(Customer customer) {
        return customers.add(customer);
    }

    public boolean removeCustomer(String pesel) {
        Customer customerToRemove = findCustomer(pesel);
        return customers.remove(customerToRemove);
    }

    public Customer findCustomer(String pesel) {
        return customers.stream()
                .filter(customer -> customer.getPesel().equals(pesel))
                .findFirst()
                .orElseThrow(() ->
                        new NotFoundException(
                                "Customer with pesel '%s' does not exist!".formatted(pesel)
                        )
                );
    }

    public String getName() {
        return name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
