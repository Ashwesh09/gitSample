import java.util.Scanner;

abstract class GeneralAccount {
    int accNo;
    String accHolderName;
    double accBalance;
    protected GeneralAccount(int accNo, String accHolderName, double accBalance) {
        this.accNo = accNo;
        this.accHolderName = accHolderName;
        this.accBalance = accBalance;
    }   
    public int getAccNo() {
        return accNo;
    }
    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }
    public String getAccHolderName() {
        return accHolderName;
    }
    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }
    public double getAccBalance() {
        return accBalance;
    }
    @Override
    public String toString() {
        return "\nDeatils: \nAccount Number=" + accNo + "\nAccount Holder Name=" + accHolderName + ",\nAccount Balance=" + accBalance;
    }

    GeneralAccount clone(GeneralAccount ac) {
        return ac;
    }

    public void additionalFeatures() {

    }

    GeneralAccount getStatement() {
        return this;

    }
    void getAccountDetails() {
        System.out.println("Account holder name : "+this.accHolderName+"\nAccount type : "+this.getClass().getName());
    }
}

class savingsAccounts extends GeneralAccount {
    static final double roi = 3.2 ;
    
    public savingsAccounts(int accNo, String accHolderName, double accBalance) {
        super(accNo, accHolderName, accBalance);
    }
    public double getRoi() {
        return roi;
    }
    double getYearlyInterset() {
        return roi * accBalance/100;
    }

    double getComputeYearlyInterset(int years) {
        return years * getYearlyInterset() / 100;
    }
}

class currentAccounts extends GeneralAccount {
    double avgDailyTransation;

    public currentAccounts(int accNo, String accHolderName,double accBalance) {
        super(accNo, accHolderName, accBalance);
    }

    public double getAvgDailyTransation() {
        return avgDailyTransation;
    }

    public void setAvgDailyTransation(double avgDailyTransation) {
        this.avgDailyTransation = avgDailyTransation;
    }

    double getYearlytransation() {
        return avgDailyTransation*(12*30);
    }

    double getTotalTransation(int days) {
        return avgDailyTransation * days;
    }
}

public class bankacc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no of accounts to create: ");
        int n = sc.nextInt();
        sc.nextLine();
        GeneralAccount[] generalAcc = new GeneralAccount[n];
        java.util.Arrays.sort(generalAcc);
        savingsAccounts[] savingAcc = new savingsAccounts[n];
        currentAccounts[] currentAcc = new currentAccounts[n];
        GeneralAccount[] salaryAcc = new GeneralAccount[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the salary account name for account no. " + (i+1) + ":\nEnter name:");
            salaryAcc[i] = new GeneralAccount(i+1,sc.nextLine(),60000) {
                double salary;
                double pf;
                double incomeTaxRate = 10 / 100;
                public double getYearlyTax(){
                    return (salary * incomeTaxRate);
                }

                public double getInHandSalary() {
                    return salary - (pf + getYearlyTax());
                }

                @Override
                public void additionalFeatures() {
                    getYearlyTax();
                    getInHandSalary();
                }
                @Override
                void getAccountDetails() {
                    System.out.println("Account Holder name : " + this.accHolderName + "\nAccount type : Salary Account.");
                }
            };
        }
        // for (int i = 0; i < n; i++) {
        //     System.out.print("Enter the general account name for account no. " + (i+1) + ":\nEnter name:");
        //     generalAcc[i] = new GeneralAccount((i + 1),sc.nextLine(),60000);
        // }
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the saving account name for account no. " + (i+1) + ":\nEnter name:");
            savingAcc[i] = new savingsAccounts((i + 1),sc.nextLine(),20000);
        }
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the current account name for account no. " + (i + 1) + ":\nEnter name:");
            currentAcc[i] = new currentAccounts((i + 1), sc.nextLine(),90000);
        }
        System.out.println();
        // for (int i = 0; i < n ; i++ )
        //     System.out.print("Details for general account no. " + (i + 1) + ": " + generalAcc[i] + "\n");
        // System.out.println();
        for (int i = 0; i < n ; i++ )
            System.out.print("Details for saving account no. " + (i + 1)+ ": " + savingAcc[i] + "\n");
        System.out.println();
        for (int i = 0; i < n ; i++ )
            System.out.print("Details for current account no. " +(i + 1) + ": " + currentAcc[i] + "\n");
        System.out.println();
        for (int i = 0; i < n ; i++ )
            System.out.print("Details for salary account no. " +(i + 1) + ": " + salaryAcc[i] + "\n");
        sc.close();

        // GeneralAccount clonedAcc = new GeneralAccount();
        // clonedAcc = clonedAcc.clone(salaryAcc[0]);
        // System.out.println("Cloned account:" + clonedAcc);
        
        System.out.println("\n------ After Modification ------\n");//\nStatement of generalAccount\n"
                //+ generalAcc[0].getStatement()+"\n");
        //(generalAcc[0].getStatement()).getAccountDetails();
        System.out.println("\nStatement of savingsAccount\n"
                + savingAcc[0].getStatement()+"\n");
        (savingAcc[0].getStatement()).getAccountDetails();
        System.out.println("\nStatement of currentAccount\n"
                + savingAcc[0].getStatement()+"\n");
        (savingAcc[0].getStatement()).getAccountDetails();
        System.out.println("\nStatement of salaryAccount\n"
                + salaryAcc[0].getStatement()+"\n");
        (salaryAcc[0].getStatement()).getAccountDetails();

    }
}