import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class BankApp {
   private int uniqueAccountNoAssigner=1;
    private int positionAssignerInVector=1;
    private final Scanner scanner=new Scanner(System.in);
    Vector<BankAccount> bankAccounts=new Vector<>(20);
    public BankApp(){
        int select;
        do {
            mainWin();
            int accType;
            select = scanner.nextByte();
            if (select == 1) {
                accountType();
                accType = scanner.nextInt();
                if (accType > 0 && accType <= 6) {
                    int accNum;
                    System.out.print("Enter name of account owner : ");
                    String name = scanner.next();
                    System.out.print("Enter account no.");
                    accNum = scanner.nextInt();
                    if (verifyAccountPresence(name, accNum)) {
                        int pos = getAccountPositionInData(name, accNum);
                        System.out.println(accType);
                        showServiceDetail(accType, pos);
                    } else {
                        System.out.print("Given Account of data  (");
                        System.out.print(" Name : " + name + "  Account no. " + accNum);
                        System.out.print(") not found.");
                        System.out.println("Try again.");
                    }
                }else {
                    System.out.println("Wrong selection of account type.");
                }
            }
            else if (select==2){
                accType=newUser();
                System.out.println("Re-enter your name sir ");
                int pos=accountSearchByName(scanner.next());
                showServiceDetail(accType,pos);

            }
            else if (select==3){
                System.out.println("Thanks for visiting sasta wala bank.");
                System.out.println("App is closing .......");
            }else {
                System.out.println("Invalid selection");
            }
        }while (select!=3);

    }
    public void mainWin(){
        System.out.println("______________________________");
        System.out.println("****** Bank Al-Sasta ******");
        System.out.println("______________________________");
        System.out.println("press 1. for user to login");
        System.out.println("press 2. for new member to make account");
        System.out.println("press 3. to close app.");
    }
    public void showServiceDetail(int accType,int position){
        System.out.println("______________________________");
        System.out.println("****** Account Details ******");
        System.out.println("______________________________");
        System.out.println(bankAccounts.get(position));
        int functionSelection;
        switch (accType){
            case 1: case 2: case 3:
                do {
                    System.out.println("Press 1 to write check.");
                    System.out.println("Press 2 to deposit money.");
                    System.out.println("Press 3 to get monthly statement.");
                    System.out.println("Press 0 to log out.");
                    functionSelection=scanner.nextInt();
                    if (functionSelection == 1) {
                        if (accType == 1) {
                            if (bankAccounts.get(position) instanceof ServiceCheckingAcc) {

//   new ServiceCheckingAcc(bankAccounts.get(position).getOwnerName(), bankAccounts.get(position).getAccNo(), bankAccounts.get(position).getBalance());
                                System.out.print("enter amount : ");
                               ((ServiceCheckingAcc) bankAccounts.get(position)).writeChecks(scanner.nextDouble());
                            }
                        } else if (accType == 2) {
                            if (bankAccounts.get(position) instanceof NoServiceCheckingAcc) {
                                System.out.print("enter amount : ");
                                ((NoServiceCheckingAcc) bankAccounts.get(position)).writeChecks(scanner.nextDouble());
                            }
                        } else {
                            if (bankAccounts.get(position) instanceof HighInterestRateChecking) {
                                System.out.print("enter amount : ");
                                ((HighInterestRateChecking) bankAccounts.get(position)).writeChecks(scanner.nextDouble());
                            }
                        }
                    } else if(functionSelection==2) {
                       System.out.print("enter amount  to deposit : ");
                       bankAccounts.get(position).deposit(scanner.nextDouble());
                   }
                   else if (functionSelection==3) {
                       System.out.println(bankAccounts.get(position).monthlyStatement());
                   } else if (functionSelection==0) {
                        System.out.println("successfully logged out.");
                    } else System.out.println("Wrong selection.");
                }while (functionSelection!=0);
                break;
            case 4: case 5:
                do {
                    System.out.println("press 0 to exit.");
                    System.out.println("Press 1 to withdraw money.");
                    System.out.println("Press 2 to deposit money.");
                    System.out.println("Press 3 to get monthly statement.");
                    functionSelection=scanner.nextInt();
                    if (functionSelection==1) {
//                        if (accType==5){
//                            ((bankAccounts.get(position))).withDraw(scanner.nextDouble());
//                        }
                         bankAccounts.get(position).withDraw(scanner.nextDouble());
                    }else if (functionSelection==2) {
                        bankAccounts.get(position).deposit(scanner.nextDouble());
                    } else if (functionSelection==3) {
                        System.out.println(bankAccounts.get(position).monthlyStatement());
                    } else if (functionSelection==0) {
                        System.out.println("existing from account.");
                    }else {
                        System.out.println("Wrong selection....");
                    }
                }while (functionSelection!=0);
                break;
            case 6:
                do {
                    System.out.println("Press 1 to withdraw money.");
                    System.out.println("Press 2 to get monthly statement.");
                    System.out.println("Press 3 to view monthly statement.");
                    System.out.println("press 0 to exit.");
                    functionSelection=scanner.nextInt();
                    if (functionSelection==1) {
                        System.out.print("enter amount to withdraw : ");
                        bankAccounts.get(position).withDraw(scanner.nextDouble());
                    }else if (functionSelection==2) {
                        System.out.println(bankAccounts.get(position).monthlyStatement());
                    } else if (functionSelection==0) {
                        System.out.println("existing from account.");
                    } else if (functionSelection==3) {
                        System.out.printf("Show current balance : %.2f%n",bankAccounts.get(position).getBalance());
                    }
                    else {
                        System.out.println("Invalid selection.");
                    }
                }while (functionSelection!=0);
                break;
            default:
                System.out.println("Invalid selection.");
        }
//        System.out.println("press 1. to check money.");
//        System.out.println("press 2. to withdraw money.");
//        System.out.println("press 3. to Add money.");
//        System.out.println("press 4. to modify name.");
//        System.out.println("press 5. to check money.");
//        System.out.println("press 6. to check money.");
//        System.out.println("press 7. to check money.");
//        System.out.println("press 8. to create monthly statement of account.");
//        System.out.println("press 9. to log out account.");
    }
    public void accountType(){
        System.out.println("Select Account type");
        System.out.println("press 1. for checking Service Account");
        System.out.println("press 2. for Checking Account without Service charge");
        System.out.println("press 3. for High interest rate checking Account");
        System.out.println("press 4. for Saving Account");
        System.out.println("press 5. for High interest Saving Account");
        System.out.println("press 6. for certificate of deposit Account");
        System.out.println("press 7. to back.");
    }
    public boolean verifyAccountPresence(String  ownerName,int account) {
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getOwnerName().toLowerCase().equals(ownerName) && bankAccount.getAccNo() == account) {
                return true;
            }
        }
        return false;
    }
    public int getAccountPositionInData(String  ownerName,int account){
        for (int i = 0; i < bankAccounts.size(); i++) {
            if (bankAccounts.get(i).getOwnerName().toLowerCase().equals(ownerName) && bankAccounts.get(i).getAccNo() == account){
                return i;
            }
        }
        return -1;
    }
    public int newUser(){
        accountType();
        int i=0;
        int accType=scanner.nextInt();
        if (accType>=1&&accType<=6) {
            System.out.print("Enter your name : ");
            String name = scanner.next();
            System.out.print("Enter Amount : ");
            double balance = scanner.nextDouble();
            System.out.println();
            switch (accType) {
                case 1:
                    bankAccounts.add(new ServiceCheckingAcc(name, 34567 + uniqueAccountNoAssigner, balance));
                    break;
                case 2:
                    bankAccounts.add(new NoServiceCheckingAcc(name, 34567 + uniqueAccountNoAssigner, balance));
                    break;
                case 3:
                    bankAccounts.add(new HighInterestRateChecking(name, 34567 + uniqueAccountNoAssigner, balance));
                    break;
                case 4:
                    bankAccounts.add(new SavingAcc(name, 34567 + uniqueAccountNoAssigner, balance));
                    break;
                case 5:
                    bankAccounts.add(new HighInterestSavingAccount(name, 34567 + uniqueAccountNoAssigner,balance));
                    break;
                case 6:
                    System.out.print("Enter total number of months for you to deposit money : ");
                    //accType use as maturity month
                    int maturityMonth = scanner.nextInt();
                    double interestRate ;
                    if (maturityMonth < 9) interestRate = 1.7;
                    else if (maturityMonth < 15) interestRate = 2.1;
                    else if (maturityMonth < 30) interestRate = 3.4;
                    else if (maturityMonth > 30) interestRate = 5.4;
                    else interestRate=5.5;
                    bankAccounts.add(new COD(name, 34567 + uniqueAccountNoAssigner, balance, interestRate, maturityMonth));
                    break;
                default:
                    System.out.println("Invalid selection");
            }
        }

        System.out.println("Your account is successfully registered.");
        uniqueAccountNoAssigner++;
        return accType;
    }
    public int accountSearchByName(String name){
        int i=0;
        while (!(name.equalsIgnoreCase(bankAccounts.get(i).getOwnerName()))){
           if (i==bankAccounts.size()-1){
               return -1;
           }
            i++;
        }
        return i;
    }
    //use only to create fake account.
    public void makeBotAccountFromFile()throws IOException {
        Scanner s=new Scanner(new FileReader("D:\\bankAccount.doc"));
        int i=0;
        while (s.hasNextLine()){
           bankAccounts.get(i).setOwner(s.next());
           bankAccounts.get(i).setAccNo(s.nextInt());
           bankAccounts.get(i).setBalance(s.nextInt());
           s.nextLine();
           i++;
           s.close();
        }
    }
}
