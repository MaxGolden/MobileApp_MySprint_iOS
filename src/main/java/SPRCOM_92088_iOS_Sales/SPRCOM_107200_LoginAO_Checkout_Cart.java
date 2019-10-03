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
public class SPRCOM_107200_LoginAO_Checkout_Cart extends MainBase {

    @Test(groups = {"AccountOwner", "Login"}, priority = 3)
    @Description("My Sprint App iOS - Check out Test")
    @Severity(SeverityLevel.CRITICAL)
    @Story("SPRCOM-107204 Cart Checkout")
    public void SPRCOM_107204()
    {
        SPRCOM_107204_Step1();
        SPRCOM_107204_Step2();
        SPRCOM_107204_Step3();
        SPRCOM_107204_Step4();
        SPRCOM_107204_Step5();
        SPRCOM_107204_Step6();
        SPRCOM_107204_Step7();
        SPRCOM_107204_Step8();
    }

    @Step("1. Tap cart icon in the upper right")
    private void SPRCOM_107204_Step1()
    {
        saveTextLog_Allure_er("Cart page is displayed");
        if(findByID_Exist(20, "Make a payment")) {
            findByCoord_Click(350, 70);
        } else {
            assertFail(false, 0, "Unknown Error - Make a payment not found");
        }
    }

    @Step("2. Tap button ‘Check out’")
    private void SPRCOM_107204_Step2()
    {
        saveTextLog_Allure_er("Number page is displayed");
        if(findByAccessibilityID_Exist(20, "Check out")) {
            findByAccessibilityID_Click(20, "Check out");
        } else {
            findByID_Click(2, "Cancel");
            assertFail(false, 0, "No item in cart, back to main page");
        }
    }

    @Step("3. Tap ‘get a new number’ and Continue")
    private void SPRCOM_107204_Step3()
    {
        saveTextLog_Allure_er("Wait for loading(15s), Personal Info page is displayed");
        findByAccessibilityID_Click(20, "Get a new number");
        findByAccessibilityID_Click(3, "Continue");
    }

    @Step("4. Enter First name and Last name")
    private void SPRCOM_107204_Step4()
    {
        saveTextLog_Allure_er("First name and Last name are entered");
        findByClassType_Clear(45, "XCUIElementTypeTextField", 0);
        findByClassType_SendKey(3, "XCUIElementTypeTextField", 0, "Max");
        findByClassType_Clear(3, "XCUIElementTypeTextField", 1);
        findByClassType_SendKey(3, "XCUIElementTypeTextField", 1, "Jin");
        findByID_Click(3, "Next");
        findByID_Click(3, "Next");
        findByID_Click(3, "Done");
    }

    @Step("5. Tap Button Continue")
    private void SPRCOM_107204_Step5()
    {
        saveTextLog_Allure_er("Delivery Options page(5s) is displayed");
        findByAccessibilityID_Click(15, "Continue");
    }

    @Step("6. Tap Overnight shipping, and tap Continue")
    private void SPRCOM_107204_Step6()
    {
        saveTextLog_Allure_er("Summary page is displayed");
        if(findByAccessibilityID_Exist(20, "Overnight shipping")) {
            findByAccessibilityID_Click(3, "Overnight shipping");
        }
        findByAccessibilityID_Click(10, "Continue");
    }

    @Step("7. Enter CVV and tap Submit order")
    private void SPRCOM_107204_Step7()
    {
        saveTextLog_Allure_er("Rate dialog pop up (decline- “OK”)?");
        findByaccessibilityID_ScrollDown(15, "Checkout", "Order summary", 1);
        findByClassType_SendKey(10, "XCUIElementTypeSecureTextField", "000");
        findByID_Click(5, "Done");
        findByAccessibilityID_Click(3, "Submit order");
    }

    @Step("8. Tap Not now")
    private void SPRCOM_107204_Step8()
    {
        saveTextLog_Allure_er("Payment result page is displayed");
        if(findByID_Exist(30, "Not Now")) {
            findByID_Click(5, "Not Now");
        }
        findByID_Click(5, "OK");
        if(!findByAccessibilityID_Exist(5, "Make a payment")) {
            assertFail(true, 5, "No main page shows up");
        }
    }
}
