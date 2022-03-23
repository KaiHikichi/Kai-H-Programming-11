import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    //Requires:nothing
    //Modifies:this
    //Effects:displays withdraw as a string
    public String toString(){
        //your code here
        String returnString;
        returnString = "Withdraw of: $" + this.amount + " Date: " + this.date + " into account: " + this.account;
        return returnString;
    }
}
