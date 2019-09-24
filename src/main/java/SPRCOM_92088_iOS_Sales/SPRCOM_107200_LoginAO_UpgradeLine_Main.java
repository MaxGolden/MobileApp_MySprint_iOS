package SPRCOM_92088_iOS_Sales;

import iOS_Base.MainBase;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static Listeners_iOS.listeners_iOS.saveTextLog_Allure_er;
import static Util.iOS_Driver_Methods.*;

@Listeners(Listeners_iOS.listeners_iOS.class)
@Epic("SPRCOM-92088 My Sprint App iOS - Sales")
@Feature("SPRCOM-107200 My Sprint App iOS - LoginAO Sales")
public class SPRCOM_107200_LoginAO_UpgradeLine_Main extends MainBase {

    @Test(groups = {"AccountOwner", "Login"}, priority = 4, dataProvider = "DeviceOption",
            dataProviderClass = Data.Upgrade_DeviceOptions.class)
    @Description("My Sprint app Sales - MainPage: Get your new device - upgrade")
    @Severity(SeverityLevel.NORMAL)
    @Story("SPRCOM-107206 My Sprint App iOS - MainPage: Get your new device - upgrade")
    public void SPRCOM_107206(String deviceType, String brand, String model, String planOption, String phonePlan,
                              String protectionOption, String RestValueOption) throws Exception
    {
        SPRCOM_107206_Step1();
        SPRCOM_107206_Step_Extra();
        SPRCOM_107206_Step2(model);
        SPRCOM_107206_Step3();
        SPRCOM_107206_Step4(planOption);
        SPRCOM_107206_Step5(protectionOption);
        SPRCOM_107206_Step6(RestValueOption);
        SPRCOM_107206_Step7();
    }

    @Step("1. Make sure MainPage loaded and Tap ‘Reserve your new iPhone’")
    private void SPRCOM_107206_Step1()
    {
        saveTextLog_Allure_er("Loading for a long time at first launch(20s) and Shop devices page is displayed");
        if(findByID_Exist(20, "Make a payment")) {
            findByAccessibilityID_Click(5, "Reserve your new iPhone");
        } else {
            assertFail(false, 0, "Unknown Error - Make a payment not found");
        }
    }

    @Step("Extra. Tap 'get priority status' on the page")
    private void SPRCOM_107206_Step_Extra()
    {
        findByAccessibilityID_Click(5, "Get Priority Status");
        if(findByID_Exist(5, "OK")) {
            findByID_Click(5, "OK");
            assertFail(true, 1, "Backend server error");
        }
    }

    @Step("2. (Apple device options as default.) Tap `Apple` filter and tap `Cancel` and tap ‘Apple iPhone XS’ (Model)")
    private void SPRCOM_107206_Step2(String model)
    {
        saveTextLog_Allure_er("Device Details page is displayed");
        findByID_Click(60, "Apple");
        findByID_Click(5, "Cancel");
        findByID_Click(5, model);
    }
    @Step("3. Make sure Continue button is enabled and tap it")
    private void SPRCOM_107206_Step3()
    {
        saveTextLog_Allure_er("Payment page is displayed");
        findByID_Click(30, "Continue");
    }

    @Step("4. Use Data Provider with three options and tap continue")
    private void SPRCOM_107206_Step4(String planOption)
    {
        saveTextLog_Allure_er("Wait for loading(20s) and Plans page is displayed");
        findByID_Click(20, planOption);
        findByID_Click(5, "Continue");
    }
    @Step("5. Tap button ‘Add protection’?")
    private void SPRCOM_107206_Step5(String protectionOption)
    {
        saveTextLog_Allure_er("Wait for loading(15s), Return page is displayed");
        findByID_Click(45, protectionOption);
    }
    @Step("6. Default Continue disabled, tap ‘Buy this phone` or ‘Return this phone’ and tap Continue")
    private void SPRCOM_107206_Step6(String RestValueOption) throws Exception
    {
        saveTextLog_Allure_er("20s loading, Cart page is displayed");
        findByID_Click(35, RestValueOption);
        findByID_Click(10, "Continue");
    }
    @Step("7. Verify value and tap cancel")
    private void SPRCOM_107206_Step7() throws InterruptedException
    {
        saveTextLog_Allure_er("All payment values are correct, and MainPage is displayed");
        findByID_Click(40, "Cancel");
    }
}
