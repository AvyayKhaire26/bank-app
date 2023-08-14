import java.util.UUID;

public class HDFC implements BankAccountInterface{

    private String name; // name of the customer

    private String accountNumber; // acc number of customer , unique for everyone (UUID)

    private String password;

    private double balance;

    final double rateOfInterest = 7.1; // rate of interest has to be fixed , hence used final

    final String IFSCCode = "HDFC374873"; //branch IFSC code , fixed hence final

    //default constructor
    public HDFC() {

    }

    //parameterised constructor
    public HDFC(String name, String password, double balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.accountNumber = String.valueOf(UUID.randomUUID()); //Universal Unique Identifier
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    @Override
    public String fetchBalance(String password) {
        if(this.password.equals(password)) {
            return "Your balance is " + this.balance;
        }
        return "Password is incorrect";
    }

    @Override
    public String addMoney(double amount) {
        this.balance += amount;
        return "Amount of Rs." + amount + " added successfully. New balance is : " + this.balance;
    }

    @Override
    public String withdrawMoney(double amount, String password) {
        if(this.password.equals(password)) {
            if(this.balance < amount) {
                return "Insufficient balance";
            }
            this.balance -= amount;
            return "Amount of Rs." + amount + " deducted successfully. New balance is : " + this.balance;
        }
        return "Password is incorrect";
    }

    @Override
    public String changePassword(String oldPassword, String newPassword) {
        if(this.password.equals(oldPassword)) {
            this.password = newPassword;
            return "Password changed successfully";
        }
        return "Incorrect original password";
    }

    @Override
    public double calculateInterest(int year) {
        return (this.balance * rateOfInterest * year)/100.0;
    }

    @Override
    public String toString() {
        return "HDFC{" +
                "name='" + name + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", rateOfInterest=" + rateOfInterest +
                ", IFSCCode='" + IFSCCode + '\'' +
                '}';
    }
}
