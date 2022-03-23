import java.util.Date;

public class Deposit {
    private double amount;
    private Date date;
    private String account;

    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    //Requires:nothing
    //Modifies:this
    //Effects:displays deposit as a string
    public String toString(){
        //your code here
        String returnString;
        returnString = "Deposit of: $" + this.amount + " Date: " + this.date + " into account: " + this.account;
        return returnString;
    }
}
