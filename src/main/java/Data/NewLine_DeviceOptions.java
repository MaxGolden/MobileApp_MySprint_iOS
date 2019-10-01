package Data;

import org.testng.annotations.DataProvider;

public class NewLine_DeviceOptions {

    @DataProvider(name = "DeviceOption")
    public Object[][] getData() {
        Object[][] deviceOption = {
                // deviceType, brand, model, planOption, phonePlan, protectionOption
                {"Phones", "Apple", "Apple iPhone XR", "finance", "Sprint Unlimited Plus – Our Favorite Plan!", "Add protection"},
//                {"Tablets", "Apple", "Apple iPad (6th generation)", "full", "Unlimited Tablet Plan", "Add protection"},
//                {"Watches", "Apple", "Apple iPhone XR", "finance", "Unlimited", "Add protection"},
        };
        return deviceOption;
    }
}
