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
public class SPRCOM_107200_LoginAO_AddNewLine_Main extends MainBase {

    @Test(groups = {"AccountOwner", "Login"}, priority = 2, dataProvider = "DeviceOption",
            dataProviderClass = Data.NewLine_DeviceOptions.class)
    @Description("My Sprint app Login - Sales: Add New Line with new device, which includes 'Add a New Device' " +
            "and 'Save Money Together' on the MainPage")
    @Severity(SeverityLevel.CRITICAL)
    @Story("SPRCOM-107202 MainPage: Add new line to Cart")
    public void SPRCOM_107202(String deviceType, String brand, String model, String planOption, String phonePlan,
                              String protectionOption)
    {
        SPRCOM_107202_Step1();
        SPRCOM_107202_Step2();
        SPRCOM_107202_Step3(deviceType);
        SPRCOM_107202_Step4(model);
        SPRCOM_107202_Step5();
        SPRCOM_107202_Step6(planOption);
        SPRCOM_107202_Step7(phonePlan, deviceType);
        SPRCOM_107202_Step8(protectionOption);
        SPRCOM_107202_Step9();
    }

    @Step("1. Make sure MainPage loaded and Tap ‘Add a New Device’")
    private void SPRCOM_107202_Step1()
    {
        saveTextLog_Allure_er("Priority page is displayed or device sheet is displayed");
        if(findByID_Exist(20, "Make a payment")) {
            findByAccessibilityID_Click(5, "Add a New Device");
        } else {
            assertFail(false, 0, "Unknown Error - Make a payment not found");
        }
    }

    @Step("2. Tap 'Get priority status' if priority page showed up")
    private void SPRCOM_107202_Step2()
    {
        saveTextLog_Allure_er("Device options page is displayed");
        if(findByAccessibilityID_Exist(5, "Get Priority Status")) {
            findByAccessibilityID_Click(5, "Get Priority Status");
        }
    }

    @Step("3. Tap 'Device' icon based on data provider")
    private void SPRCOM_107202_Step3(String deviceType)
    {
        saveTextLog_Allure_er("Device list page is displayed");
        findByID_Click(5, deviceType);
    }

    @Step("4. Default filter, tap model form data provider")
    private void SPRCOM_107202_Step4(String model)
    {
        saveTextLog_Allure_er("Device Details page is displayed");
        findByID_Click(60, model, true);
    }

    @Step("5. Make sure Continue button is enabled and tap it")
    private void SPRCOM_107202_Step5()
    {
        saveTextLog_Allure_er("Payment page is displayed");
        findByAccessibilityID_Click(25, "Continue", true);
    }

    @Step("6. Use Data Provider with three options and tap continue")
    private void SPRCOM_107202_Step6(String planOption)
    {
        saveTextLog_Allure_er("Wait for loading(20s) and Plans page is displayed");
        String planOptionNew;
        if(planOption.equals("full")) {
            planOptionNew = "Full price";
        } else if(planOption.equals("Lease")) {
            planOptionNew = "Sprint Flex 18 mo. lease starting at";
        } else {
            planOptionNew = "Buy it with 24 monthly installments";
        }
        findByID_Click(15, planOptionNew);
        findByID_Click(5, "Continue");
    }

    @Step("7. Make sure default Continue button is disabled and click plan, tap Continue")
    private void SPRCOM_107202_Step7(String phonePLan, String deviceType)
    {
        saveTextLog_Allure_er("Protection page is displayed");
        if(deviceType.equals("Tablets")) {
            findByAccessibilityID_Click(30, "Select and continue", true);
        } else {
            findByAccessibilityID_Click(30, phonePLan, true);
            findByAccessibilityID_Click(5, "Continue");
        }
    }
    @Step("8. Tap button ‘Add protection’")
    private void SPRCOM_107202_Step8(String protectionOption)
    {
        saveTextLog_Allure_er("Cart page is displayed");
        findByID_Click(15, protectionOption, true);
    }
    @Step("9. Return back to main page")
    private void SPRCOM_107202_Step9()
    {
        saveTextLog_Allure_er("Main page is displayed");
        findByID_Click(25, "Cancel", true);
    }
}
