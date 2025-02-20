import java.util.Scanner;

public class COD extends BankAccount {
    private static final double INTEREST_RATE=0.7;
    private final Scanner scanner=new Scanner(System.in);
    private static final int NUMBER_OF_MATURITY_MONTHS=6;
    private double interestRate;
    private int maturityMonths,cdMonth;
    private double cdMoney;
    public COD(String owner, int acc, double balance){
        super(owner,acc,balance);
        cdMoney=getBalance();
        interestRate=INTEREST_RATE;
        maturityMonths=NUMBER_OF_MATURITY_MONTHS;
        postInterest(getBalance());
        cdMonth=0;
        addRecord(String.format("Maturity months : %2d%nInterest Rate : %.2f%nCertificate of Deposit month : %d%n",maturityMonths,interestRate,cdMonth));
    }
    public COD(String owner, int acc, double balance, double interestRate, int maturityMonths){
        super(owner,acc,balance);
        cdMoney=getBalance();
        setInterestRate(interestRate);
        setMaturityMonths(maturityMonths);
        addRecord(String.format("Maturity months : %d%nInterest Rate :" +
                " %.2f%nCertificate of Deposit month : %d%n",this.maturityMonths,this.interestRate,cdMonth));
        postInterest(getBalance());
        cdMonth=0;
    }

    public  double getInterestRate() {
        return interestRate;
    }
    public int getCdMonth() {
        return cdMonth;
    }
    public int getMaturityMonths() {
        return maturityMonths;
    }
    public void setInterestRate(double interestRate) {
        while (interestRate<INTEREST_RATE||interestRate>3.99){
            System.out.println("Interest rate must be within 0.7% to 3.99%");
            interestRate=scanner.nextDouble();
        }
        this.interestRate=interestRate;
    }

    public void setCdMonth(int cdMonth) {
        while (cdMonth > maturityMonths || cdMonth < 1) {
            System.out.println("certificate of deposit month must be b/w 1 to " + NUMBER_OF_MATURITY_MONTHS);
            cdMonth = scanner.nextInt();
        }
        this.cdMonth=cdMonth;
    }

    public void setMaturityMonths(int maturityMonths) {
        while (maturityMonths<3){
            System.out.print("Maturity Month must be greater than 3 : ");
            maturityMonths=scanner.nextInt();
        }
        this.maturityMonths = maturityMonths;
    }
    public void postInterest(double enterBalance){
        addRecord("Total Profit after "+maturityMonths+" months is: "+(((interestRate/100)*enterBalance)*maturityMonths)+"\n");
    }

    @Override
    public void withDraw(double enterAmount) {
      if (enterAmount<0){
          System.out.println("Enter amount is not valid.");
          addRecord("Enter amount is not valid."+enterAmount+"\n\n");
      }
        else if (enterAmount>0&&enterAmount<=getBalance()) {
           System.out.println("Your are withdrawing your money " + enterAmount);
           addRecord("Your are withdrawing your money " + enterAmount+"\n");
           System.out.println("According to bank you will be charge according to percentage of money ");
           addRecord("According to bank you will be charge according to percentage of money \n");
           System.out.println("so, percentage of money withdrawing is : " + ((enterAmount * 100) / getBalance()) + "%");
           addRecord("so, percentage of money withdrawing is : " + ((enterAmount * 100) / getBalance()) + "%\n");
           System.out.println("Your profit of "+ ((enterAmount * 100) / getBalance())+"% removed ");
           double cutProfit=((interestRate/100)*(getBalance()-enterAmount))*maturityMonths;
           setBalance(getBalance()-enterAmount);
           System.out.println("Now Amount of profit you gonna received at end of maturity months is : "+cutProfit+"\n");
           addRecord("Now Amount of profit you gonna received at end of maturity months is : "+cutProfit+"\n\n");
       }
       else {
          System.out.println("your account has insufficient balance to withdraw amount : "+enterAmount+"\n\n");
        addRecord("your account has insufficient balance to withdraw amount : "+enterAmount+"\n\n");
       }
    }

    @Override
    public String toString() {
        if (cdMoney==getBalance()) {
            if (cdMonth < 1) return super.toString() + String.format("Maturity months : %d%nInterest Rate :" +
                    " %.2f%nCertificate of Deposit month : %d%n", maturityMonths, interestRate, cdMonth) +
                    "Total Profit after " + maturityMonths + " months is: " + (((interestRate / 100) * cdMoney) * maturityMonths) + '\n';
            else return super.toString() + String.format("Maturity months : %d%nInterest Rate :" +
                    " %.2f%nCertificate of Deposit month : %d%n", maturityMonths, interestRate, cdMonth) +
                    "Total Profit after " + maturityMonths + " months is: " + (((interestRate / 100) * cdMoney) * maturityMonths) + '\n'
                    +"Received profit : "+(getBalance()*(interestRate/100)*cdMonth)+"\n";

        }
        else {
            if (cdMonth<1)
            return super.toString() + String.format("Maturity months : %d%nInterest Rate :" +
                    " %.2f%nCertificate of Deposit month : %d%n", maturityMonths, interestRate, cdMonth) +
                    "Total Profit after " + maturityMonths + " months is: " + (((interestRate / 100) * cdMoney) * maturityMonths) + '\n'
                    + "Due to withdraw of money total profit is decreased \n"
                    + "Actual profit after withdrawal is : " + (((interestRate / 100) *getBalance() )* maturityMonths) + "\n";
            else  return super.toString() + String.format("Maturity months : %d%nInterest Rate :" +
                    " %.2f%nCertificate of Deposit month : %d%n", maturityMonths, interestRate, cdMonth) +
                    "Total Profit after " + maturityMonths + " months is: " + (((interestRate / 100) * cdMoney) * maturityMonths) + '\n'
                    + "Due to withdraw of money total profit is decreased \n"
                    + "Actual profit after withdrawal is : " + (getBalance() * (interestRate / 100) * maturityMonths) + "\n"
                    + "Received profit : " + (getBalance() * (interestRate / 100) * cdMonth) + "\n";

        }
    }


}
