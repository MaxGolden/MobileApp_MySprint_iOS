package Data;

import org.testng.annotations.DataProvider;

public class Upgrade_DeviceOptions {

    @DataProvider(name = "DeviceOption")
    public Object[][] getData() {
        Object[][] deviceOption = {
//                {"Phones", "Apple", "Apple iPhone XR", "lease", "Unlimited", "Add protection", "Buy this phone"},
                {"Phones", "Apple", "Apple iPhone Xs", "finance", "Unlimited", "Add protection", "Return this phone"},

        };
        return deviceOption;
    }
}
