import org.junit.Before;
import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.assertEquals;


public class DepositTests {
        Deposit testSet;
        Date date;

        @Before
        public void setup(){
            date = new Date(122, 2, 18, 17, 18, 02);
            testSet = new Deposit(100.0, date,Customer.CHECKING);
        }

        @Test
        public void testToString(){
            //checks Strings are equal
            String testString = "Deposit of: $100.0 Date: Fri Mar 18 17:18:02 PDT 2022 into account: Checking";
            assertEquals(testString, testSet.toString());
        }

}