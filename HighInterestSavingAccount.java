import java.util.Scanner;

public class HighInterestSavingAccount extends SavingAcc{
    private static final double MINI_BALANCE=2500,INTEREST_RATE=0.5;
    protected double minimumBalance;
    private final Scanner scanner=new Scanner(System.in);
    public HighInterestSavingAccount(String owner, int acc, double balance){
        super(owner,acc,balance);
        minimumBalance=MINI_BALANCE;
        interestRate=INTEREST_RATE;
        while (getBalance()<minimumBalance){
            System.out.println("Added Balance is less than minimum balance."+minimumBalance);
            System.out.println("Add more money : ");
             double miniBalance=scanner.nextDouble();
            setBalance(getBalance()+miniBalance);
        }
        addRecord(String.format("Minimum Balance : %15.2f%n",minimumBalance));
        postInterest();
    }
    public HighInterestSavingAccount(String owner, int acc, double balance, double miniBalance, double interestRate){
        super(owner,acc,balance);
        this.minimumBalance=miniBalance;
        while (getBalance()<minimumBalance){
            System.out.println("Added Balance is less than minimum balance.");
            System.out.println("Add more money : ");
            miniBalance=scanner.nextDouble();
            setBalance(getBalance()+miniBalance);
        }
        addRecord(String.format("Minimum Balance : %15.2f%n",minimumBalance));
        postInterest();
    }
    public boolean verifyMinimumBalance(double enterBalance){
        return enterBalance>minimumBalance;
    }
    public void setMiniBalance(double miniBalance){
        while (miniBalance<minimumBalance){
            System.out.println("Set minimum balance must be greater "+MINI_BALANCE);
            miniBalance=scanner.nextDouble();
        }
    }
    public double getMiniBalance() {
        return minimumBalance;
    }
    public void withDraw(double enterAmount) {
        if ((enterAmount > 0) && (getBalance() -enterAmount) >= minimumBalance) {
            System.out.println("Entered amount : " + enterAmount + " is withdraw successfully");
            addRecord("Entered amount : " + enterAmount + " is withdraw successfully\n");
            System.out.println("Previous balance : " + getBalance());
            addRecord("Previous balance : " + getBalance() + '\n');
            setBalance(getBalance() - enterAmount);
            addRecord("New balance : " + getBalance() + "\n\n");
            System.out.println("New balance : " + getBalance());
        } else {
            System.out.println("Your account has insufficient balance.");
            addRecord("Your account has insufficient balance to withdraw " + enterAmount + "\n");
            System.out.println("Your current balance is : " + getBalance());
            addRecord("Your current balance is : " + getBalance() + "\n\n");
        }
    }

    @Override
    public String toString() {
        return super.toString()+String.format("Minimum Balance : %23.2f%n",minimumBalance);
    }

    @Override
    public void postInterest() {
        super.postInterest();
    }
}
