public class SavingAcc extends BankAccount{
    private static final double INTEREST_RATE=0.3;
    protected double interestRate;

    //To get monthly intereset call post Intereset in Mian or in connstructor
    public SavingAcc(String ownerName, int accountNo, double balance){
        super(ownerName,accountNo,balance);
        interestRate=INTEREST_RATE;
        addRecord(String.format("Monthly Interest rate : %12.2f%n",interestRate));
        addRecord("Added Interest amount \t\t\t: "+((interestRate/100)*getBalance())+'\n');
        addRecord("\n");
    }
    public SavingAcc(String ownerName, int accountNo, double balance, double interestRate){
        super(ownerName,accountNo,balance);
        setInterestRate(interestRate);
        addRecord("Added Interest amount \t\t\t\t\t : "+((interestRate/100)*getBalance())+'\n');
    }
    public double getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(double interestRate) {
        if (interestRate>=0.3&&interestRate<1.99)this.interestRate = interestRate;
        else this.interestRate=INTEREST_RATE;
    }
    public void postInterest(){
        addRecord("Interest Added amount in end of month : "+((interestRate/100)*getBalance())+'\n');
    }

    @Override
    public String toString() {
        return super.toString()+String.format("Monthly Interest rate : %17.2f%nAdded Interest amount :%18.2f%n"
                ,interestRate,((interestRate/100)*getBalance())+'\n');
    }
}
