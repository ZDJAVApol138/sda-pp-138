package pl.sda.bankapp.model;

import lombok.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private long id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String pesel;
    private Address address;
    private LocalDate dateOfBirth;
    private final List<Account> accounts = new ArrayList<>();
    private final int age = Period.between(dateOfBirth, LocalDate.now()).getYears();

//    private int calculateAge() {
//        LocalDate now = LocalDate.now();
//        int years = now.getYear() - dateOfBirth.getYear();
//        int month = now.getMonthValue() - dateOfBirth.getMonthValue();
//        if (month >= 0) {
//            int days = now.getDayOfMonth() - dateOfBirth.getDayOfMonth();
//            if (days >= 0) {
//                years++;
//            }
//        }
//        return years;
//    }

    public boolean addAccount(Account account) {
        return accounts.add(account);
    }

    public boolean removeAccount(Account account) {
        return accounts.remove(account);
    }

    public void listAccounts() {
//        accounts.forEach(account -> System.out.println(account));
//        for (Account account : accounts) {
//            System.out.println(account);
//        }

        accounts.forEach(System.out::println);
    }
}
