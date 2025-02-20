import java.util.Scanner;

public class ServiceCheckingAcc extends CheckingAcc{
    static private final double accountServiceCharge=10,serviceChargeExcessNumOfChecks=5;
    private final Scanner scanner=new Scanner(System.in);
    static private final int maxNoChecks=5;
    private int counter=1;
    protected double serviceChargeAcc,serviceChargeChecks;
    protected int  noOfChecks;
    protected int numOfWrittenChecks;
    public ServiceCheckingAcc(String ownerName, int accountNo, double balance){
    super(ownerName,accountNo,balance);
    serviceChargeAcc=accountServiceCharge;
    serviceChargeChecks=serviceChargeExcessNumOfChecks;
    noOfChecks=maxNoChecks;
    postServiceCharge();
        addRecord(String.format("Max no. of Checks :%13s%nAccount Service Charge : %8s%nCharge on checks in excess : %2.2f%n",noOfChecks,serviceChargeAcc,serviceChargeChecks));
    }

    public ServiceCheckingAcc(String ownerName, int accountNo, double balance, double serviceChargeAcc, double serviceChargeChecks){
        super(ownerName,accountNo,balance);
        this.serviceChargeAcc=serviceChargeAcc;
        this.serviceChargeChecks=serviceChargeChecks;
        noOfChecks=maxNoChecks;
        postServiceCharge();
        addRecord(String.format("Max no. of Checks :%13s%nAccount Service Charge : %8s%nCharge on checks in excess : %2.2f%n :",noOfChecks,serviceChargeAcc,serviceChargeChecks));
    }
    public void setServiceChargeAcc( double serviceChargeAcc) {
        this.serviceChargeAcc=(serviceChargeAcc);
    }
    public double getServiceChargeAcc( double serviceChargeAcc) {
        return serviceChargeAcc;
    }
    public void setServiceChargeChecks(double serviceChargeChecks){
        this.serviceChargeChecks=serviceChargeChecks;
    }
    public double getServiceChargeChecks(){
        return serviceChargeChecks;
    }
    public int getNoOfChecks(){
        return noOfChecks;
    }
    public void setNoOfChecks(int numOfWrittenChecks){
        this.noOfChecks=numOfWrittenChecks;
    }
    @Override
      void writeChecks(double enterAmount){
        double extraAmt=0;
        if (enterAmount>0&&enterAmount<=getBalance()){
            if (counter>noOfChecks){
                extraAmt=serviceChargeChecks;
                setBalance(getBalance()-extraAmt);
                System.out.println("you have used "+noOfChecks+" checks that are allowed");
                System.out.println("so,extra checks is charged by extra amount of "+serviceChargeChecks);
                addRecord("you have used "+noOfChecks+" checks that are allowed\n");
                addRecord("so,extra checks is charged by extra amount of "+serviceChargeChecks+"\n");
            }
            System.out.println("Check is written successfully ");
            addRecord("check no. "+counter+"\n Check is written successfully\n ");
            System.out.println("Amount is deducted successfully");
            addRecord("Amount : "+enterAmount+" is deducted successfully\n");
            addRecord("Previous Balance is "+(getBalance())+"\n");
            setBalance(getBalance()-extraAmt);
            setBalance(getBalance()-enterAmount);
            System.out.println("New balance is "+getBalance());
            addRecord(String.format("New balance is %.2f",getBalance())+"\n");
            counter++;

        }else {
            System.out.println("Insufficient Balance.");
            addRecord("Insufficient Balance.\n");
            System.out.println("you cannot withdraw "+enterAmount);
            addRecord("you cannot withdraw "+enterAmount+"\n");
            System.out.println("Current Balance : "+getBalance());
            addRecord(String.format("Current Balance : %.2f",getBalance())+"\n\n");
        }
    }


    public void postServiceCharge(){
        if (getBalance()>=10) {
            setBalance(getBalance() - 10);
            addRecord("Post service charge is deducted" + 10 + "\n");
        }else {
            System.out.println("Sir,you have to pay post service charge.\n" +
                    "that cost "+10+". Pay it now. To get access of your account");
           boolean t=true;
            while (t){
                System.out.print("Deposit more than 10$ : ");
                double m=scanner.nextDouble();
                deposit(m);
                if (getBalance()>=10){
                    addRecord("Thanks for depositing money.\n");
                    addRecord("Post service charges deducted successfully");
                    setBalance(getBalance()-10);
                    t=false;
                }
            }
        }

    }

    @Override
    public String toString() {
        return super.toString()+String.format("Max no. of Checks :%21s%nAccount Service Charge : %16s%nChecks charge%27.2f%n ",noOfChecks,serviceChargeAcc,serviceChargeChecks);
    }

}