package BankApp;

public abstract class Account implements IBaseRate {
    // List common properties for savings and checking accounts
    private String name, SSN;
    protected String accountNumber;
    private double balance;
    protected double rate;
    private static int index = 10000;

    // Constructor to set base properties and initialize the account
    public Account(String name, String SSN, double initDeposit) {
        this.name = name;
        this.SSN = SSN;
        this.balance = initDeposit;

        // Set account number
        index++;
        this.accountNumber = setAccountNumber();

        setRate();

    }

    public abstract void setRate();

    private String setAccountNumber() {
        String lastTwoOfSSN = SSN.substring(SSN.length() - 2, SSN.length());
        int uniqueID = index;
        int randomNum = (int) (Math.random() * Math.pow(10, 3));
        return lastTwoOfSSN + uniqueID + randomNum;
    }

    public void compound() {

        double accruedInterest = balance * (rate / 100);
        balance = balance + accruedInterest;
        System.out.println("Accured Interest: $" + accruedInterest);
        printBalance();
    }

    // List common methods - transactions
    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Depositing $" + amount);
        printBalance();
    }

    public void withdraw(double amount) {
        balance = balance - amount;
        System.out.println("Withdrawing $" + amount);
        printBalance();
    }

    public void transfer(String toWhere, double amount) {
        balance = balance - amount;
        System.out.println("Transfering $" + amount + " to " + toWhere);
        printBalance();
    }

    public void printBalance() {
        System.out.println("Your balance is now: $" + balance);
    }

    public void showInfo() {
        System.out.println("NAME: " + name + "\nACCOUNT NUMBER: " + accountNumber + "\nBALANCE: " + balance + "\nRATE: "
                + rate + "%");
    }
}