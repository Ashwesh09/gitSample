interface WorldBank {
    void showBalance();

    double withdraw(double amount);

    double deposite(double amount);

}

interface RBI extends WorldBank {
    double ROI = 4.0 / 100;

    double calculateYearlyInterset();
    
}
class PhoneNumber {
    String countryCode;
    String phu;
    
    public PhoneNumber(String countryCode, String phu) {
        this.countryCode = countryCode;
        this.phu = phu;
    }
    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    public String getPhu() {
        return phu;
    }
    public void setPhu(String phu) {
        this.phu = phu;
    }
    @Override
    public String toString() {
        return "PhoneNumber =" + countryCode + "-" + phu;
    }
    
}
class generalAccount1 implements RBI{
    String accountHolderName;
    double accountBalance;
    int accountNumber;
    PhoneNumber phNum;

    public generalAccount1(String accountHolderName, double accountBalance, int accountNumber, PhoneNumber phNum) {
        this.accountHolderName = accountHolderName;
        this.accountBalance = accountBalance;
        this.accountNumber = accountNumber;
        this.phNum = phNum;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
    public void showBalance() {
        System.out.println("Account balance is:" + this.accountBalance);
    }

    public double withdraw(double amount) {
        if (this.accountBalance < amount) {
            System.out.println("Balance is '0'");
            return this.accountBalance;
        }
        this.accountBalance -= amount;
        return this.accountBalance;
    }

    public double deposite(double amount) {
        this.accountBalance += amount;
        return this.accountBalance;
    }

    public double calculateYearlyInterset() {
        return this.accountBalance * ROI;
    }
    @Override
    public String toString() {
        return "\nAccountNumber=" + accountNumber + "\nAccountHolderName=" + accountHolderName
                +"\nAccountBalance=" + accountBalance + "\n"+phNum;
    }
    
}
class SBIaccount extends generalAccount1 {
    
    public SBIaccount(String accountHolderName, double accountBalance, int accountNumber,PhoneNumber phoneNumber ) {
        super(accountHolderName, accountBalance + 200 , accountNumber,phoneNumber); // an amount credited to a new account
    }

    void displayFeatures() {
        System.out.println("\nIf you create an account in next 30 day you will get Rs. 200 as an amount credited to a new account in SBI\n");
    }
}

class ICICIaccount extends generalAccount1 {

    
    public ICICIaccount(String accountHolderName, double accountBalance, int accountNumber,PhoneNumber phoneNumber ) {
        super(accountHolderName, accountBalance + 200 , accountNumber,phoneNumber); // an amount credited to a new account
    }
    @Override
    public double calculateYearlyInterset() {
        return this.accountBalance * (ROI+(2.0/100));  //additionalInterest - 2%
    }

    void displayFeatures() {
        System.out.println("\nYou will get 2% more interest with opening a new ICICI account\n");
    }
}

public class bankEgwithInterface {
    public static void main(String[] args) {
        PhoneNumber phoneNInd = new PhoneNumber("+91", "12345657890");
        SBIaccount sbi = new SBIaccount("Ashwesh", 0.0, 1, phoneNInd);
        PhoneNumber phoneNUSA = new PhoneNumber("+1", "5465456450");
        ICICIaccount icici = new ICICIaccount("ABC", 0.0, 1,phoneNUSA);
        // SBI operations
        System.out.println("---- Showing SBI feature ----");
        sbi.displayFeatures();
        System.out.println("---- Showing ICICI feature ----");
        icici.displayFeatures();
        System.out.println("\nDepositing Rs.1100 in SBI account");
        sbi.deposite(1100.0);
        System.out.println("\n---- SBI account info: ----\n" + sbi + "\n");
        System.out.println("Withdrawing Money of Rs. 230");
        sbi.withdraw(230);
        sbi.showBalance();
        System.out.println("\nYearly interset for SBI account:" + sbi.calculateYearlyInterset());
        System.out.println("\n---- SBI account info: ----\n" + sbi + "\n");
        
        // Now for ICICI
        System.out.println("\nDepositing Rs.  2300 in icici account");
        icici.deposite(2300);
        System.out.println("\n---- ICICI account info: ----\n" + icici+"\n");
        System.out.println("Withdrawing Money of Rs. 110");
        icici.withdraw(110);
        icici.showBalance();
        System.out.println("\nYearly interset for icici account:" + icici.calculateYearlyInterset());
        System.out.println("\n---- ICICI account info: ----\n" + icici+"\n");
    }
    
}
