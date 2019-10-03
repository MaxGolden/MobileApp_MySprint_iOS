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
public class SPRCOM_107200_LoginAO_AddNewLine_Shop extends MainBase {

    @Test(groups = {"AccountOwner", "Login"}, priority = 5, dataProvider = "DeviceOption",
            dataProviderClass = Data.NewLine_DeviceOptions.class)
    @Description("My Sprint app Login - Sales: Add New Line with new device, which includes 'Add a New Device' " +
            "and 'Save Money Together' on the ShopPage")
    @Severity(SeverityLevel.CRITICAL)
    @Story("SPRCOM-107212 ShopPage: Add new line to Cart")
    public void SPRCOM_107212(String deviceType, String brand, String model, String planOption, String phonePlan,
                              String protectionOption) throws Exception
    {
        SPRCOM_107212_Step1();
        SPRCOM_107212_Step2(deviceType);
        SPRCOM_107212_Step3();
        SPRCOM_107212_Step4(model);
        SPRCOM_107212_Step5();
        SPRCOM_107212_Step6(planOption);
        SPRCOM_107212_Step7(phonePlan, deviceType);
        SPRCOM_107212_Step8(protectionOption);
        SPRCOM_107212_Step9();
    }

    @Step("1. Make sure MainPage is loaded and tap ‘Shop’ page")
    private void SPRCOM_107212_Step1()
    {
        saveTextLog_Allure_er("Shop page is displayed");
        if(findByID_Exist(15, "Make a payment")) {
            findByCoord_Click(208, 830);
        }
        if(!findByID_Exist(3, "Browse devices")) {
            assertFail(false, 0, "Page not displayed");}
    }

    @Step("2. Use device type and brand name from data provider and tap them on Shop page")
    private void SPRCOM_107212_Step2(String deviceType) throws Exception
    {
        saveTextLog_Allure_er("Shop Option page is displayed (Add new or upgrade)");
        findByAccessibilityID_Click(5, deviceType, true);
        Thread.sleep(3000);
        findByCoord_Click(130, 500);
    }

    @Step("3. Tap ‘Add a new Phone’ ")
    private void SPRCOM_107212_Step3()
    {
        saveTextLog_Allure_er("Loading for a long time at first launch(20s) and Shop devices page is displayed");
        findByAccessibilityID_Click(40, "Add a new phone", true);
    }

    @Step("4. Default filter, tap ‘Apple iPhone XS’")
    private void SPRCOM_107212_Step4(String model)
    {
        saveTextLog_Allure_er("Device Details page is displayed");
        findByAccessibilityID_Click(60, model, true);
    }
    @Step("5. Make sure Continue button is enabled and tap it")
    private void SPRCOM_107212_Step5()
    {
        saveTextLog_Allure_er("Payment page is displayed");
        findByAccessibilityID_Click(30, "Continue", true);
    }

    @Step("6. Use Data Provider with three options and tap continue")
    private void SPRCOM_107212_Step6(String planOption)
    {
        saveTextLog_Allure_er("Wait for loading(20s) and Plans page is displayed");
        String planOptionNew;
        if(planOption.equals("full")) {
            planOptionNew = "Full price";
        } else if(planOption.equals("lease")) {
            planOptionNew = "Sprint Flex 18 mo. lease starting at";
        } else {
            planOptionNew = "Buy it with 24 monthly installments";
        }
        findByAccessibilityID_Click(30, planOptionNew);
        findByAccessibilityID_Click(5, "Continue");
    }

    @Step("7. Make sure default Continue button is disabled and click default shared plan ($20)? , tap Continue")
    private void SPRCOM_107212_Step7(String phonePLan, String deviceType)
    {
        saveTextLog_Allure_er("Protection page is displayed");
        if(deviceType.equals("Tablets")) {
            findByAccessibilityID_Click(30, "Select and continue", true);
        } else {
            if(findByAccessibilityID_Exist(30, phonePLan)) {
                findByAccessibilityID_Click(3, phonePLan, true);
            } else {
                findByAccessibilityID_Click(3, "2GB", true);
            }
            findByAccessibilityID_Click(5, "Continue");
        }
    }

    @Step("8. Tap button ‘Add protection’?")
    private void SPRCOM_107212_Step8(String protectionOption)
    {
        saveTextLog_Allure_er("Wait for loading(15s), Cart page is displayed");
        findByAccessibilityID_Click(25, protectionOption);
    }

    @Step("9. Leave the cart and back to main page")
    private void SPRCOM_107212_Step9()
    {
        saveTextLog_Allure_er("Main page is displayed");
        findByAccessibilityID_Click(25, "Cancel");
        if(findByID_Exist(5, "Browse devices")) {
            findByCoord_Click(40, 830);
        } else {
            assertFail(false, 0, "Page not displayed");
        }
    }
}
