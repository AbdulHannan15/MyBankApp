public abstract class BankAccount {
    private String monthlyRecord="";
    private int accNo;
    private double balance;
    private String ownerName;
    public BankAccount(){
        ownerName="";
        accNo=0;
        balance=0;
    }
    public BankAccount(String ownerName, int accNo, double balance){
        setOwner(ownerName);
        setAccNo(accNo);
        setBalance(balance);
    }
    protected final void addRecord(String record){
        monthlyRecord=monthlyRecord.concat(record);
    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
     if (accNo>0)  this.accNo = accNo;
     else this.accNo=0;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
       if (balance>0)this.balance = balance;
       else this.balance=0;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwner(String ownerName) {
        this.ownerName= ownerName;
    }
    public void withDraw(double enterAmount){
        if (enterAmount>0&&enterAmount<=balance) {
            System.out.println("Entered amount : " + enterAmount + " is withdraw successfully");
            addRecord("Entered amount : " + enterAmount + " is withdraw successfully\n");
            System.out.println("Previous balance : "+balance);
            addRecord("Previous balance : "+balance+'\n');
            balance-=enterAmount;
            addRecord("New balance : "+balance+"\n\n");
            System.out.println("New balance : "+balance);
        }
        else {
            System.out.println("Your account has insufficient balance.");
            addRecord("Your account has insufficient balance to withdraw "+enterAmount+"\n");
            System.out.println("Your current balance is : "+balance);
            addRecord("Your current balance is : "+balance+"\n\n");
//            monthlyRecord=monthlyRecord.concat("Your account has insufficient balance cannot withdraw "+enterAmount+" .\n"+"Your current balance is : "+balance+'\n'+'\n');
        }
    }
    public void deposit(double enterAmount){
        if (enterAmount<=0){
            System.out.println("Entered amount is not valid.");
//            monthlyRecord=monthlyRecord.concat("Entered amount : "+enterAmount+" is not valid.\n\n");
            addRecord("Entered amount : "+enterAmount+" is not valid.\n\n");
        }
        else {
            System.out.println("Entered amount : "+enterAmount+" is successfully added");
            addRecord("Entered amount : "+enterAmount+" is successfully added\n");
            System.out.println("Previous Balance : "+balance);
            addRecord("Previous Balance : "+balance+'\n');
            balance+=enterAmount;
            System.out.println("New balance : "+balance);
            addRecord("new balance  : "+balance+'\n'+'\n');
        }
    }
    public String monthlyStatement(){
        String accountRecord=String.format("Owner name : %20s%nAccount no :%21d%nCurrent Balance :%16.2f%n",this.ownerName,this.accNo,this.balance);
    return "Monthly Statement of account : \n\n"+accountRecord+monthlyRecord;
    }

    @Override
    public String toString() {
        return String.format("Owner name : %28s%nAccount num : %27s%nBalance : %31.2f%n",ownerName,accNo,balance);
    }
}
