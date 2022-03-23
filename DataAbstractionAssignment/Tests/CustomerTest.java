import org.junit.Before;
import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.assertEquals;
public class CustomerTest {

    Customer testCustomer;
    Date date;
    double delta;

    @Before
    public void setup(){
        testCustomer = new Customer("Bob Vance", 1, 100, 100);
        date = new Date(122, 2, 18, 17, 18, 02);
        delta = 0.01;
    }

    @Test
    public void testDeposit(){
        //check initial balance
        assertEquals(100,testCustomer.getCheckBalance(),delta);
        assertEquals(100,testCustomer.getSavingBalance(), delta);
        //add deposit
        testCustomer.deposit(100, date, Customer.SAVING);
        testCustomer.deposit(100, date, Customer.CHECKING);
        //check changed balance
        assertEquals(200,testCustomer.getCheckBalance(),delta);
        assertEquals(200,testCustomer.getSavingBalance(), delta);
    }

    @Test
    public void testWithdrawWithoutOvercast(){
        //check initial balance
        assertEquals(100,testCustomer.getCheckBalance(),delta);
        assertEquals(100,testCustomer.getSavingBalance(), delta);
        //add withdraw
        testCustomer.withdraw(50, date, Customer.SAVING);
        testCustomer.withdraw(50, date, Customer.CHECKING);
        //check changed balance
        assertEquals(50,testCustomer.getCheckBalance(),delta);
        assertEquals(50,testCustomer.getSavingBalance(), delta);

    }

    @Test
    public void testWithdrawWithOvercast(){
        //check initial balance
        assertEquals(100,testCustomer.getCheckBalance(),delta);
        assertEquals(100,testCustomer.getSavingBalance(), delta);
        //attempt to add withdraw
        testCustomer.withdraw(200, date, Customer.SAVING);
        testCustomer.withdraw(200, date, Customer.CHECKING);
        //check unchanged balance
        assertEquals(100,testCustomer.getCheckBalance(),delta);
        assertEquals(100,testCustomer.getSavingBalance(), delta);

    }

}