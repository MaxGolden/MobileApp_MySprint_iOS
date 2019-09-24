package SPRCOM_92078_iOS_Payment;

import iOS_Base.MainBase;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static Listeners_iOS.listeners_iOS.saveTextLog_Allure_er;
import static Util.iOS_Driver_Methods.*;

@Listeners(Listeners_iOS.listeners_iOS.class)
@Epic("SPRCOM-92078 My Sprint App iOS - Payment")
@Feature("SPRCOM-106300 My Sprint App iOS - NonLogin Payment")
public class SPRCOM_106300_iOS_NonLogin_ApplePay extends MainBase {

    @Test(groups = {"NonLogin", "MakePayment"}, priority = 2)
    @Description("Payment making with ApplePay")
    @Severity(SeverityLevel.NORMAL)
    @Story("SPRCOM-106304 Payment making with ApplePay")
    public void SPRCOM_106304() throws InterruptedException
    {
        SPRCOM_106304_Step1();
        SPRCOM_106304_Step2();
        SPRCOM_106304_Step3();
        SPRCOM_106304_Step4();
        SPRCOM_106304_Step5();
        SPRCOM_106304_Step6();
    }

    @Step("1. Click ‘Make a payment’ Button")
    private void SPRCOM_106304_Step1() throws InterruptedException
    {
        saveTextLog_Allure_er("Payment page is displayed");
        if(findByID_Exist(20, "Make a payment")) {
            findByID_Click(5, "Make a payment");
        } else {
            assertFail(false, 0, "Unknown Error - Make a payment not found");
        }
    }

    @Step("2. Tap 'Amount' and enter $1")
    private void SPRCOM_106304_Step2() throws InterruptedException
    {
        saveTextLog_Allure_er("Button 'Next' is able to tap");
        findByClassType_Clear(5, "XCUIElementTypeTextField", 0);
        findByClassType_SendKey(5, "XCUIElementTypeTextField", 0, "100");
        findByID_Click(5, "Next");
    }

    @Step("3. Set payment method to 'Apple Pay' and tap 'Next'")
    private void SPRCOM_106304_Step3() throws InterruptedException
    {
        saveTextLog_Allure_er("Bottom payment sheet is displayed");
        findByAccessibilityID_Click(5, "Payment method");
        findByAccessibilityID_Click(5, "Apple Pay");
        findByAccessibilityID_Click(5, "Next");
    }
    @Step("4. Tap 'Continue' if Warning dialog is displayed")
    private void SPRCOM_106304_Step4()
    {
        saveTextLog_Allure_er("Bottom payment sheet is displayed");
        if(findByID_Exist(5, "Warning")) {
            findByID_Click(5, "Continue");
        }
    }

    @Step("5. Tap 'Pay with Passcode")
    private void SPRCOM_106304_Step5()
    {
        saveTextLog_Allure_er("Result page is displayed");
        findByID_Click(5, "Pay with Passcode");
    }

    @Step("6. Tap 'OK' whether the result is fail or success")
    private void SPRCOM_106304_Step6()
    {
        saveTextLog_Allure_er("MainPage is displayed");
        findByID_Click(10, "OK");
    }


}
