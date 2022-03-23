import java.util.Date;

public class main {
    public static void main(String[] args) {

        Customer Kai = new Customer();

        Kai.deposit(100, new Date(), Customer.SAVING);
        Kai.deposit(300, new Date(), Customer.SAVING);

        Kai.deposit(700, new Date(), Customer.CHECKING);

        Kai.withdraw(200, new Date(), Customer.SAVING);
        Kai.withdraw(400, new Date(), Customer.SAVING);

        Kai.withdraw(500, new Date(), Customer.CHECKING);

        Kai.displayDeposits();
        Kai.displayWithdraws();
    }
}
