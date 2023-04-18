package pl.sda.bankapp.service;

import lombok.RequiredArgsConstructor;
import pl.sda.bankapp.model.Bank;

import java.util.Scanner;

@RequiredArgsConstructor
public class BankService {

    private final Bank bank;
    private final Scanner scanner;
    private final AccountFactory accountFactory = new AccountFactory();

}
