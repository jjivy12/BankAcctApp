package BankApp;

import java.util.*;

public class BankAccountApp {
    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<Account>();
        // Read a CSV File then create new accounts based on that data
        String file = "C:\\Projects For WIN\\JavaProjectNewBank\\original.csv";

        List<String[]> newAccountHolders = CSV.read(file);
        for (String[] accountHolder : newAccountHolders) {
            String name = accountHolder[0];
            String SSN = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            System.out.println(name + " " + SSN + " " + accountType + "$ " + initDeposit);
            if (accountType.equals("Savings")) {
                accounts.add(new Savings(name, SSN, initDeposit));
            } else if (accountType.equals("Checking")) {
                accounts.add(new Checking(name, SSN, initDeposit));
            } else {
                System.out.println("ERROR READING ACCOUNT TYPE");
            }
            for (Account acc : accounts) {
                System.out.println("************************");
                acc.showInfo();
            }

        }
    }
}