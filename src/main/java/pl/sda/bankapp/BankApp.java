package pl.sda.bankapp;

import pl.sda.bankapp.model.Bank;
import pl.sda.bankapp.dao.AccountsDAO;
import pl.sda.bankapp.dao.CustomersDAO;
import pl.sda.bankapp.dao.PersistenceContext;
import pl.sda.bankapp.service.BankService;

import java.util.Scanner;

public class BankApp {

    public static void main(String[] args) {
        Bank bank = new Bank("ING Bank Sląski");
        Scanner scanner = new Scanner(System.in);
        BankService bankService = new BankService(bank, scanner);

        AccountsDAO accountsDAO = new AccountsDAO();
        CustomersDAO customersDAO = new CustomersDAO(accountsDAO);
        PersistenceContext persistenceContext = new PersistenceContext(customersDAO);
        persistenceContext.loadData(bank);

        String options = """
                =============================
                1 - List customer          ||
                2 - Create customer        ||
                3 - Remove customer        ||
                4 - Find customer          ||
                5 - Create account         ||
                6 - Remove account         ||
                7 - List accounts          ||
                8 - Save                   ||
                9 - Exit                   ||
                =============================
                """;

        String userInput;
        do {
            System.out.println(options);
            userInput = scanner.nextLine();
            switch (userInput) {
                case "1" -> bankService.listCustomers();
                case "2" -> bankService.createCustomer();
                case "3" -> bankService.removeCustomer();
                case "4" -> bankService.getCustomerByPesel();
                case "5" -> bankService.createCustomerAccount();
                case "6" -> bankService.removeCustomerAccount();
                case "7" -> bankService.listCustomerAccounts();
                case "8" -> persistenceContext.persistData(bank);
                case "9" -> System.out.println("Bye!");
                default -> System.err.println("Invalid option!");
            }
        } while (!"9".equals(userInput));

        persistenceContext.persistData(bank);
    }
}
