import org.junit.Before;
import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.assertEquals;

public class WithdrawTests {
    Withdraw testSet;
    Date date;

    @Before
    public void setup(){
        date = new Date(122, 2, 18, 17, 18, 02);
        testSet = new Withdraw(100.0, date,Customer.SAVING);
    }

    @Test
    public void testToString(){
        //checks Strings are equal
        String testString = "Withdraw of: $100.0 Date: Fri Mar 18 17:18:02 PDT 2022 into account: Saving";
        assertEquals(testString, testSet.toString());
    }


}
