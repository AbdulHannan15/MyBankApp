public class HighInterestRateChecking extends NoServiceCheckingAcc{
    public static final double MINI_BALANCE=5000,INTEREST_RATE=0.5;
    public HighInterestRateChecking(String owner, int acc, double balance){
       super(owner, acc, balance);
       this.miniBalance=MINI_BALANCE;
       while (getBalance()<miniBalance){
           System.out.println("Balance must be greater than "+miniBalance);
           balance=scanner.nextDouble();
           setBalance(balance+getBalance());
       }
        setInterestRate(INTEREST_RATE);
        addRecord(String.format("Minimum Balance :%16.2f%nInterest Rate :%18.2f%n",miniBalance,interestRate));
        postInterest();
    }
    public HighInterestRateChecking(String owner, int acc, double balance, double minimunBalance, double inerestRate){
        super();
        this.miniBalance=minimunBalance;
        setBalance(balance);
        while (getBalance()<miniBalance){
            System.out.println("Balance must be greater than "+miniBalance);
            balance=scanner.nextDouble();
            setBalance(getBalance()+balance);
        }
        setOwner(owner);setAccNo(acc);
        setInterestRate(inerestRate);
        setInterestRate(inerestRate);
        addRecord(String.format("Minimum Balance :%16.2f%nInterest Rate :%18.2f%n",miniBalance,interestRate));
        postInterest();
    }

    @Override
    public void setInterestRate(double interestRate) {
        while (interestRate<0.5||interestRate>9){
            System.out.println("Interest must be b/w 0.5 to 9.0 : ");
            interestRate=scanner.nextDouble();
        }
        this.interestRate=interestRate;
    }
    @Override
    void writeChecks(double enterAmount) {
        if (enterAmount>0&&enterAmount<=getBalance()-miniBalance){
            System.out.println("Check is written successfully ");
            addRecord("Check is written successfully\n ");
            System.out.println("Amount is deducted successfully");
            addRecord("Amount : "+enterAmount+" is deducted successfully\n");
            addRecord("Previous Balance is "+(getBalance())+"\n");
            double newBalance=getBalance()-enterAmount;
            setBalance(newBalance);
            System.out.println("New balance is "+(newBalance));
            addRecord(String.format("New balance is %.2f",getBalance())+"\n\n");
        }else {
            System.out.println("Remaining Balance is insufficient for minimum balance.");
            addRecord("Remaining Balance is insufficient for minimum balance.\n");
            System.out.println("Sorry,you cannot withdraw "+enterAmount);
            addRecord("Sorry,you cannot withdraw "+enterAmount+"\n");
            System.out.println("Current Balance : "+getBalance());
            addRecord(String.format("Current Balance : %.2f",getBalance())+"\n\n");
        }
    }
   public void postInterest(){
        double inter=(interestRate/100)*getBalance();
        setBalance(getBalance()+inter);
        addRecord(String.format("Added interest Amount : %.2f%n",inter));
   }

    @Override
    public String toString() {
        return super.toString()+String.format("Added interest Amount :%18.2f%n",(interestRate/100)*getBalance());
    }

    @Override
    public String monthlyStatement() {
        return super.monthlyStatement();
    }
}
