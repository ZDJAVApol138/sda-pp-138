package pl.sda.bankapp.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.sda.bankapp.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class Bank {

    private final String name;

    @Setter
    private List<Customer> customers = new ArrayList<>();

    public void listCustomers() {
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
}
