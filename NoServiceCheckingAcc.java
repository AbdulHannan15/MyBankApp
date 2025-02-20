import java.util.Scanner;

public class NoServiceCheckingAcc extends CheckingAcc {
    private static final double MINI_BALANCE=1000;
    private int checkCounter=1;
    private static final double INTEREST_RATE=0.2;
    protected static final Scanner scanner=new Scanner(System.in);
    protected double miniBalance=MINI_BALANCE,interestRate=INTEREST_RATE;
    public NoServiceCheckingAcc(){
        super();
    }
    public NoServiceCheckingAcc(String owner, int acc, double balance){
        super();
        setBalance(balance);
        while (getBalance()<miniBalance){
            System.out.println("Balance must be greater than "+miniBalance);
            balance=scanner.nextDouble();
            setBalance(getBalance()+balance);
        }
        setOwner(owner);setAccNo(acc);
        addRecord(String.format("Minimum Balance :%16.2f%nInterest Rate :%18.2f%n",miniBalance,interestRate));
        setBalance(getBalance()+((interestRate/100) *getBalance()));
        addRecord("Added interest Amount : \t"+((interestRate/100) *getBalance())+'\n'+'\n');
    }
    public NoServiceCheckingAcc(String owner, int acc, double balance, double miniBalance, double interestRate){
        this.miniBalance=miniBalance;
        setBalance(balance);
        while (getBalance()<miniBalance){
            System.out.println("Balance must be greater than "+miniBalance);
            balance=scanner.nextDouble();
            setBalance(getBalance()+balance);
        }
        setOwner(owner);setAccNo(acc);
        setMiniBalance(miniBalance);
        setInterestRate(interestRate);
        addRecord(String.format("Minimum Balance :%12.2f%nInterest Rate :%10.2f%n",miniBalance,interestRate));
        setBalance(getBalance()+((double)( interestRate/100) *getBalance()));
        addRecord("Added interest Amount :    "+(((double) interestRate/100) *getBalance())+'\n');
    }
    public void setMiniBalance(double balance){
            while (balance<1000){
                System.out.print("Deposit money more 1000 to access or use account : ");
                balance= scanner.nextDouble();
            miniBalance=balance;
        }
    }
    public void setInterestRate(double interestRate){
            while (interestRate<0.01||interestRate >5){
                System.out.println("Interest rate must be equal or greater 0.1%");
                interestRate=scanner.nextDouble();
            }
            this.interestRate=interestRate;
    }
    public double getMiniBalance(){
        return miniBalance;
    }
    public double getInterestRate(){
        return interestRate;
    }
    public boolean verifyMiniBalance(double miniBalance){
        return miniBalance >= MINI_BALANCE;
    }
    @Override
    void writeChecks(double enterAmount) {
        double extraAmt=0;
        if (enterAmount>0&&enterAmount<=getBalance()-miniBalance){
            System.out.println("Check no."+checkCounter+" is written successfully\n ");
            addRecord("Check no."+checkCounter+" is written successfully\n ");
            System.out.println("Amount is deducted successfully");
            addRecord("Amount : "+enterAmount+" is deducted successfully\n");
            addRecord("Previous Balance is "+(getBalance())+"\n");
            double newBalance=getBalance()-enterAmount;
            setBalance(newBalance);
            System.out.println("New balance is "+(newBalance));
            addRecord(String.format("New balance is %.2f",getBalance())+"\n\n");
            checkCounter++;
        }else {
            System.out.println("Remaining Balance is insufficient for minimum balance.");
            addRecord("Remaining Balance is insufficient for minimum balance.\n");
            System.out.println("Sorry,you cannot withdraw "+enterAmount);
            addRecord("Sorry,you cannot withdraw "+enterAmount+"\n");
            System.out.println("Current Balance : "+getBalance());
            addRecord(String.format("Current Balance : %.2f",getBalance())+"\n\n");
        }
    }
    @Override
    public void withDraw(double enterAmount) {
        if (enterAmount>0&&enterAmount<=getBalance()-miniBalance){
            System.out.println("Your amount is withdraw successfully.");
            addRecord("Your amount is withdraw successfully.\n");
            System.out.println("previous Balance : "+getBalance());
            addRecord("previous Balance : "+getBalance()+"\n");
            System.out.println("New Balance : "+(getAccNo()-enterAmount));
            addRecord("New Balance : "+(getAccNo()-enterAmount)+"\n\n");
        }
        else {
            System.out.println("Sorry sir, you cannot withdraw "+enterAmount+
                    "\nbecause remaining amount is less than minimum balance.");
            addRecord("Sorry sir, you cannot withdraw "+enterAmount+
                    "\nbecause remaining amount is less than minimum balance.\n\n");
        }
    }

    @Override
    public String toString() {
        return super.toString()+String.format("Minimum Balance :%24.2f%nInterest Rate :%24.2f%n",miniBalance,interestRate);
    }
}
