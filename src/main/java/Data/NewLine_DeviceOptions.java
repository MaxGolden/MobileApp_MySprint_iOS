package Data;

import org.testng.annotations.DataProvider;

public class NewLine_DeviceOptions {

    @DataProvider(name = "DeviceOption")
    public Object[][] getData() {
        Object[][] deviceOption = {

                // deviceType, brand, model, planOption, phonePlan, protectionOption
                {"Phones", "Apple", "Apple iPhone XR", "Lease", "Unlimited", "Add protection"},

        };
        return deviceOption;
    }
}
