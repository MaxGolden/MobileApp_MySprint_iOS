package Data;

import org.testng.annotations.DataProvider;

public class AccountOwner_Info {

    @DataProvider(name = "AccountOwner")
    public Object[][] getData() {
        Object[][] accounts_data = {
                {"rtb1", "8155930790", "ONREG-21966_1", "T3stM3.P1s"},
//                {"st2", "3369549079", "TWREG-59003", "T3stM3.P1s"}
        };
        return accounts_data;
    }
}
