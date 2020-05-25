package BankApp;

public class Savings extends Account {
    // List properties to the Savings account
    private int safetyDepositBoxID, safetyDepositBoxKey;

    // Constructor to initialize settings for the Savings properties
    public Savings(String name, String SSN, double initDeposit) {
        super(name, SSN, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    public void setRate() {
        rate = getBaseRate() - 0.25;
    }

    private void setSafetyDepositBox() {
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
    }

    // List any methods specific to savings account
    public void showInfo() {

        System.out.println("ACCOUNT TYPE: Savings");
        super.showInfo();
        System.out.println("Your Savings Account Features" + "\nSafety Deposit Box ID : " + safetyDepositBoxID
                + "\nSafety Deposit Box Key: " + safetyDepositBoxKey);
    }

}