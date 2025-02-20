public abstract class CheckingAcc extends BankAccount{
    public CheckingAcc(String ownerName, int accNo, double balance){
        super(ownerName,accNo,balance);
    }
    public CheckingAcc(){
        super();
    }
    abstract void writeChecks(double enterAmount);
}
