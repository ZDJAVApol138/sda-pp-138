package pl.sda.bankapp;

import pl.sda.bankapp.model.Bank;
import pl.sda.bankapp.service.BankService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank("Loyd's");
        Scanner scanner = new Scanner(System.in);
        BankService bankService = new BankService(bank, scanner);
        bankService.listCustomers();
        System.out.println("==========================");
        bankService.createCustomer();
        System.out.println("==========================");
        bankService.listCustomers();
    }
}
