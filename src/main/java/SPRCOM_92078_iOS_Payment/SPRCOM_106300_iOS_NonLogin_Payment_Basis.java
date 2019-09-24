package SPRCOM_92078_iOS_Payment;

import iOS_Base.MainBase;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static Listeners_iOS.listeners_iOS.saveTextLog_Allure_er;
import static Util.iOS_Driver_Methods.*;

@Listeners(Listeners_iOS.listeners_iOS.class)
@Epic("SPRCOM-92078 My Sprint App iOS - Payment")
@Feature("SPRCOM-106300 My Sprint App iOS - NonLogin Payment")
public class SPRCOM_106300_iOS_NonLogin_Payment_Basis extends MainBase {

    @Test(groups = {"NonLogin", "MakePayment"}, priority = 1)
    @Description("Basic Functions - icon, button, amount, card info field functions")
    @Severity(SeverityLevel.NORMAL)
    @Story("SPRCOM-106302 Payment Basic Functions")
    public void SPRCOM_106302()
    {
        SPRCOM_106302_Step1();
        SPRCOM_106302_Step2();
        SPRCOM_106302_Step3();
        SPRCOM_106302_Step4();
        SPRCOM_106302_Step5();
        SPRCOM_106302_Step6();
        SPRCOM_106302_Step7();
    }

    @Step("1. Click ‘Make a payment’ Button")
    private void SPRCOM_106302_Step1()
    {
        saveTextLog_Allure_er("Payment page is displayed");

        if(findByID_Exist(20, "Make a payment")) {
            findByID_Click(5, "Make a payment");
        } else {
            assertFail(false, 0, "Unknown Error - Make a payment not found");
        }
    }

    @Step("2. Input amount less than $1")
    private void SPRCOM_106302_Step2()
    {
        saveTextLog_Allure_er("The error message '- Min. payment amount limit $1' should show up");
        findByClassType_Clear(5, "XCUIElementTypeTextField", 0);
        findByClassType_SendKey(5, "XCUIElementTypeTextField", 0, "99");
        findByID_Click(5, "Next");
        if(!findByValueXpath_Exist(
                7,
                "//XCUIElementTypeStaticText[@name=\" - Min. payment amount limit $1\"]")) {
            assertFail(true, 3, "Error message is not displayed");
        }

    }

    @Step("3. Input amount more than $2000")
    private void SPRCOM_106302_Step3()
    {
        saveTextLog_Allure_er("The error message '- Max. payment amount limit $2000' should show up");
        findByClassType_Clear(5, "XCUIElementTypeTextField", 0);
        findByClassType_SendKey(5, "XCUIElementTypeTextField", 0, "200001");
        findByID_Click(5, "Next");
        if(!findByValueXpath_Exist(
                7,
                "//XCUIElementTypeStaticText[@name=\"- Max. payment amount limit $2000\"]")) {
            assertFail(true, 3, "Error message is not displayed");
        }
    }

    @Step("4. Tap 'payment method' and tap 'Add payment method'")
    private void SPRCOM_106302_Step4()
    {
        saveTextLog_Allure_er("Add payment method card info page is displayed");
        findByAccessibilityID_Click(5, "Payment method");
        findByAccessibilityID_Click(5, "Add payment method");
    }

    @Step("5. Tap 'OK' if camera access shows up")
    private void SPRCOM_106302_Step5()
    {
        saveTextLog_Allure_er("Camera access allowed");
        if(findByID_Exist(5, "OK")) {
            findByID_Click(5, "OK");
        }
    }

    @Step("6. ZipCode test: Input less than 5 digits")
    private void SPRCOM_106302_Step6()
    {
        saveTextLog_Allure_er("'Invalid ZIP code' error message is displayed");
        findByID_SendKeys(5, "ZIP", "6543");
        findByID_Click(3, "Next");
        findByID_Click(3, "Next");
        findByID_Click(3, "Done");
        if(!findByValueXpath_Exist(
                3,
                "//XCUIElementTypeStaticText[@name=\"- Invalid ZIP code.\"]")) {
            assertFail(true, 4, "Error message did not show");
        }
    }

    @Step("7. Back to the main page")
    private void SPRCOM_106302_Step7()
    {
        saveTextLog_Allure_er("Main Page is displayed");
        findByAccessibilityID_Click(5, "Cancel");
        findByAccessibilityID_Click(10, "Cancel");
        Assert.assertTrue(findByAccessibilityID_Exist(10, "Make a payment"));
    }
}
