package BankApp;

public class Checking extends Account {
    // List properties specific to a Checking account
    private int debitCardNum, debitCardPIN;

    // Constructor to initialize checking account properties
    public Checking(String name, String SSN, double initDeposit) {
        super(name, SSN, initDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    public void setRate() {
        rate = getBaseRate() * .15;
    }

    // List any methods specific to the checking account
    private void setDebitCard() {
        debitCardNum = (int) (Math.random() * Math.pow(10, 12));
        debitCardPIN = (int) (Math.random() * Math.pow(10, 4));

    }

    public void showInfo() {
        super.showInfo();
        System.out.println("Your Checking Account Features");
        System.out.println("CARD " + this.debitCardNum);
        System.out.println("PIN " + this.debitCardPIN);
    }
}