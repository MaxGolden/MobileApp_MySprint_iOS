package SPRCOM_92078_iOS_Payment;

import iOS_Base.MainBase;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static Listeners_iOS.listeners_iOS.saveTextLog_Allure;
import static Listeners_iOS.listeners_iOS.saveTextLog_Allure_er;
import static Util.iOS_Driver_Methods.*;

@Listeners(Listeners_iOS.listeners_iOS.class)
@Epic("SPRCOM-92078 My Sprint App iOS - Payment")
@Feature("SPRCOM-106800 My Sprint App iOS - LoginAO Payment")
public class SPRCOM_106800_iOS_LoginAO_AddChecking extends MainBase {

    @Test(groups = {"NonLogin", "MakePayment"}, priority = 5, dataProvider = "CheckingNumber",
            dataProviderClass = Data.Payment_CheckingOptions.class)
    @Description("Test the function of payment making with different types of checking accounts")
    @Severity(SeverityLevel.TRIVIAL)
    @Story("SPRCOM-106810 Payment Test with checking accounts")
    public void SPRCOM_106810(String checkRouting, String checkNum, String bankName)
    {
        SPRCOM_106810_Step1();
        SPRCOM_106810_Step2();

        if(findByID_Exist(2, "Continue")) {
            findByID_Click(2, "Continue");
        }

        String Last4digits = checkNum.substring(checkNum.length() - 4);
        if(findByAccessibilityID_Exist(2, Last4digits) & !findByID_Exist(2, "(Expired)")) {
            findByAccessibilityID_Click(2, Last4digits);
            saveTextLog_Allure("Card exist - skip step3");
            SPRCOM_106810_Step4();
            SPRCOM_106810_Step5();
            SPRCOM_106810_Step6();
            SPRCOM_106810_Step7();
            SPRCOM_106810_Step8();
        } else {
            findByAccessibilityID_Click(5, "Add payment method");
            SPRCOM_106810_Step_extra();
            SPRCOM_106810_Step3(checkRouting, checkNum);
            SPRCOM_106810_Step4();
            SPRCOM_106810_Step5();
            SPRCOM_106810_Step6();
            SPRCOM_106810_Step7();
            SPRCOM_106810_Step8();
        }
    }


    @Step("1. Click ‘Make a payment’ Button")
    private void SPRCOM_106810_Step1()
    {
        saveTextLog_Allure_er("Payment page is displayed");

        if(findByID_Exist(20, "Make a payment")) {
            findByID_Click(5, "Make a payment");
        } else {
            assertFail(false, 0, "Unknown Error - Make a payment not found");
        }
    }

    @Step("2. Change the amount to $1.00 and tap 'Payment method' and tap add payment method")
    private void SPRCOM_106810_Step2()
    {
        saveTextLog_Allure_er("Add payment method page is displayed");
        findByClassType_Clear(5, "XCUIElementTypeTextField", 0);
        findByClassType_SendKey(5, "XCUIElementTypeTextField", 0, "100");
        findByID_Click(5, "Next");
        findByAccessibilityID_Click(5, "Payment method");
    }

    @Step("Extra. Tap 'OK' if camera access shows up")
    private void SPRCOM_106810_Step_extra()
    {
        saveTextLog_Allure_er("Camera access allowed");
        if(findByID_Exist(5, "OK")) {
            findByID_Click(5, "OK");
        }
    }

    @Step("3. Fill the info of checking with different card number from data provider")
    private void SPRCOM_106810_Step3(String cardNum, String cardType)
    {
        saveTextLog_Allure_er("Checking info is entered");
        findByAccessibilityID_Click(5, "Checking");
        findByID_Click(5, "Routing number");
        findByID_Click(5, "Account number");
        findByID_Click(5, "Next");
        findByID_Click(5, "Done");
        if(findByAccessibilityID_Enable(5, "Save")) {
            findByID_Click(5, "Save");
        } else {
            assertFail(true, 3, "Unknown errors happened");
        }
    }

    @Step("4. Tap 'Next' on the payment page if Next button is enabled")
    private void SPRCOM_106810_Step4()
    {
        saveTextLog_Allure_er("Bottom payment sheet is displayed");
        if(findByAccessibilityID_Exist(5, "Next")) {
            findByID_Click(5, "Next");
        } else {
            assertFail(true, 3, "Unknown errors happened");
        }
    }

    @Step("5. Tap 'Continue' if Warning dialog is displayed")
    private void SPRCOM_106810_Step5()
    {
        saveTextLog_Allure_er("Bottom payment sheet is displayed");
        if(findByID_Exist(5, "Warning")) {
            findByID_Click(5, "Continue");
        }
    }


    @Step("6. Tap 'Authorize' button on the bottom sheet")
    private void SPRCOM_106810_Step6()
    {
        saveTextLog_Allure_er("Payment result page is displayed");
        if(findByID_Exist(5, "Authorize")) {
            findByID_Click(5, "Authorize");
        } else {
            assertFail(true, 5, "Authorize not found");
        }
    }

    @Step("7. Tap 'Not Now' button if the rate page is displayed")
    private void SPRCOM_106810_Step7()
    {
        saveTextLog_Allure_er("Payment result page is displayed");
        if(findByID_Exist(10, "Not Now")) {
            findByID_Click(3, "Not Now");
        }
    }

    @Step("8. Tap 'OK' to finish the payment")
    private void SPRCOM_106810_Step8()
    {
        saveTextLog_Allure_er("MainPage is displayed");
        findByAccessibilityID_Click(5, "OK");
    }
}
