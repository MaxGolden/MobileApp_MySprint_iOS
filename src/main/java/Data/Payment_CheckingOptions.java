package Data;

import org.testng.annotations.DataProvider;

public class Payment_CheckingOptions {

    @DataProvider(name = "CheckingNumber")
    public Object[][] getData() {
        Object[][] checking_data = {
                {"000001", "00110111", "BANK"},
        };
        return checking_data;
    }
}
