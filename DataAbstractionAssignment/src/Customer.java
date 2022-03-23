import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;


    Customer(){
        //create default constructor
        this.accountNumber = 0;
        this.deposits = new ArrayList<Deposit>();
        this.withdraws = new ArrayList<Withdraw>();
        this.checkBalance = 0;
        this.savingBalance = 0;
        this.savingRate = 0;
        this.name = "NA";
    }

    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        //constructor code here
        this.accountNumber = accountNumber;
        this.deposits = new ArrayList<Deposit>();
        this.withdraws = new ArrayList<Withdraw>();
        this.checkBalance = checkDeposit;
        this.savingBalance = savingDeposit;
        this.savingRate = 0;
        this.name = name;
    }

    //Requires:double, Date, String
    //Modifies:this, deposits
    //Effects:creates a Deposit and adds it to deposits array and adds to balance
    public double deposit(double amt, Date date, String account){
        //your code here
        Deposit current = new Deposit(amt, date, account);
        this.deposits.add(current);
        if (account.equals(SAVING)){
            this.savingBalance = this.savingBalance + amt;
        }
        else if (account.equals(CHECKING)){
            this.checkBalance = this.checkBalance + amt;
        }
        return 0;
    }

    //Requires:double, Date, String
    //Modifies:this, withdraws
    //Effects:creates a Withdraw and adds it to withdraw array
    public double withdraw(double amt, Date date, String account){
        //your code here
        if(checkOverdraft(amt, account) == true){
            Withdraw current = new Withdraw(amt, date, account);
            this.withdraws.add(current);
            if (account.equals(SAVING)){
                this.savingBalance = this.savingBalance - amt;
            }
            else if (account.equals(CHECKING)){
                this.checkBalance = this.checkBalance - amt;
            }
        }
        else{
            System.out.println("Insufficient Funds");
        }
        return 0;
    }

    private boolean checkOverdraft(double amt, String account){
        //your code here
        boolean state = false;
        if(account.equals(SAVING)){
            if(savingBalance - amt <= -100){
                state = false;
            }
            else if(savingBalance - amt >= -100){
                state = true;
            }
        }
        else if(account.equals(CHECKING)){
            if(checkBalance - amt <= -100){
                state = false;
            }
            else if(checkBalance - amt >= -100){
                state = true;
            }
        }
        return state;
    }


    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

    public ArrayList<Deposit> getDeposits() {

        return deposits;
    }

    public ArrayList<Withdraw> getWithdraws() {

        return withdraws;
    }

    public double getCheckBalance() {
        return checkBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }
}
