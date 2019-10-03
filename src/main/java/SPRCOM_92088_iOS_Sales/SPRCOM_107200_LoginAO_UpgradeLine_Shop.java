package SPRCOM_92088_iOS_Sales;

import Data.AccountOwner_Info;
import iOS_Base.MainBase;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static Listeners_iOS.listeners_iOS.saveTextLog_Allure_er;
import static Util.iOS_Driver_Methods.*;

@Listeners(Listeners_iOS.listeners_iOS.class)
@Epic("SPRCOM-92088 My Sprint App iOS - Sales")
@Feature("SPRCOM-107200 My Sprint App iOS - LoginAO Sales")
public class SPRCOM_107200_LoginAO_UpgradeLine_Shop extends MainBase {

    String MDN = AccountOwner_Info.getData()[0][1].toString();
    String MDN_dash = MDN.substring(0, 3) + "-" + MDN.substring(3, 6) + "-" + MDN.substring(6);

    @Test(groups = {"AccountOwner", "Login"}, priority = 6, dataProvider = "DeviceOption",
            dataProviderClass = Data.Upgrade_DeviceOptions.class)
    @Description("My Sprint app Login: Sales - ShopPage: Get your new device - upgrade")
    @Severity(SeverityLevel.NORMAL)
    @Story("SPRCOM-107214 ShopPage: Upgrade device")
    public void SPRCOM_107214(String deviceType, String brand, String model, String planOption, String phonePlan,
                              String protectionOption, String RestValueOption) throws Exception
    {
        SPRCOM_107214_Step1();
        SPRCOM_107214_Step2(deviceType);
        SPRCOM_107214_Step3();
        SPRCOM_107214_Step4(model);
        SPRCOM_107214_Step5();
        SPRCOM_107214_Step6(planOption);
        SPRCOM_107214_Step7(protectionOption);
        SPRCOM_107214_Step8(RestValueOption);
        SPRCOM_107214_Step9();
    }

    @Step("1. Make sure MainPage is loaded and tap ‘Shop’ page")
    private void SPRCOM_107214_Step1()
    {
        saveTextLog_Allure_er("Shop page is displayed");
        if(findByID_Exist(15, "Make a payment")) {
            findByCoord_Click(208, 830);
        }
        if(!findByID_Exist(3, "Browse devices")) {
            assertFail(false, 0, "Page not displayed");}
    }

    @Step("2. Use device type and brand name from data provider and tap them on Shop page")
    private void SPRCOM_107214_Step2(String deviceType) throws Exception
    {
        saveTextLog_Allure_er("Shop Option page is displayed (Add new or upgrade)");
        findByID_Click(5, deviceType, true);
        Thread.sleep(1000);
        findByCoord_Click(130, 500);
    }

    @Step("3. Make sure MainPage is loaded and tap ‘Shop’ page")
    private void SPRCOM_107214_Step3()
    {
        saveTextLog_Allure_er("Shop page is displayed");
        if(findByAccessibilityID_Exist(40, MDN_dash)) {
            findByAccessibilityID_Click(3, MDN_dash, true);
        } else {
            findByAccessibilityID_Click(3, MDN, true);
        }
    }

    @Step("4. Tap model from data provider")
    private void SPRCOM_107214_Step4(String model)
    {
        saveTextLog_Allure_er("Device Details page is displayed");
        findByID_Click(60, model, true);
    }
    @Step("5. Make sure Continue button is enabled and tap it")
    private void SPRCOM_107214_Step5()
    {
        saveTextLog_Allure_er("Payment page is displayed");
        findByID_Click(45, "Continue", true);
    }

    @Step("6. Use Data Provider with three options and tap continue")
    private void SPRCOM_107214_Step6(String planOption)
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
        findByID_Click(20, planOptionNew, true);
        findByID_Click(5, "Continue");
    }


    @Step("7. Tap button ‘Add protection’?")
    private void SPRCOM_107214_Step7(String protectionOption)
    {
        saveTextLog_Allure_er("Wait for loading(15s), Return page is displayed");
        findByID_Click(45, protectionOption, true);
    }

    @Step("8. Default Continue disabled, tap ‘Buy this phone` or ‘Return this phone’ and tap Continue")
    private void SPRCOM_107214_Step8(String RestValueOption)
    {
        saveTextLog_Allure_er("20s loading, Cart page is displayed");
        if(findByID_Exist(35, RestValueOption)) {
            findByID_Click(5, RestValueOption, true);
            if(findByAccessibilityID_Exist(2, "Continue")) {
                findByAccessibilityID_Click(2, "Continue");
            }
            if(findByAccessibilityID_Exist(2, "Continue")) {
                findByAccessibilityID_Click(2, "Continue");
            }
        }
    }

    @Step("9. Return back to main page")
    private void SPRCOM_107214_Step9()
    {
        saveTextLog_Allure_er("Main page is displayed");
        findByID_Click(40, "Cancel", true);
        if(findByID_Exist(5, "Browse devices")) {
            findByCoord_Click(40, 830);
        } else {
            assertFail(false, 0, "Page not displayed");
        }
    }
}
