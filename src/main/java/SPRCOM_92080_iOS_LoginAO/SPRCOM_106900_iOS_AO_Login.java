package SPRCOM_92080_iOS_LoginAO;

import iOS_Base.MainBase;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static Listeners_iOS.listeners_iOS.saveTextLog_Allure_er;
import static Util.iOS_Driver_Methods.*;

@Listeners(Listeners_iOS.listeners_iOS.class)
@Epic("SPRCOM-92080 My Sprint App iOS - Login")
@Feature("SPRCOM-106900 My Sprint App iOS - AOLogin")
public class SPRCOM_106900_iOS_AO_Login extends MainBase {

    @Test(groups = {"AccountOwner", "Login"}, priority = 2, dataProvider = "AccountOwner",
            dataProviderClass = Data.AccountOwner_Info.class)
    @Description("My Sprint app Login as account owner")
    @Severity(SeverityLevel.CRITICAL)
    @Story("SPRCOM-106904 Login as account owner")
    public void SPRCOM_106904(String Env, String MDN, String ACCusername, String ACCpassword)
    {
        SPRCOM_106904_Step1();
        SPRCOM_106904_Step2();
        SPRCOM_106904_Step3(ACCusername, ACCpassword);
        SPRCOM_106904_Step4();
    }

    @Step("1. Make sure button ‘Make a payment’ showed in main page")
    private void SPRCOM_106904_Step1()
    {
        saveTextLog_Allure_er("Button ‘Make a payment’ is displayed in main page");
        if(!findByAccessibilityID_Exist(10, "Make a payment")) {
            assertFail(false, 0, "Make a payment button not found!");
        }
    }

    @Step("2. Tap the profile icon in the upper right corner and click ‘Sign in’ in the bottom sheet")
    private void SPRCOM_106904_Step2()
    {
        saveTextLog_Allure_er("‘Sign in’ page is displayed");
        findByCoord_Click(380, 66);
        if(findByID_Exist(5, "Sign in")) {
            findByID_Click(5, "Sign in");
        }
    }

    @Step("3. Enter username and password")
    private void SPRCOM_106904_Step3(String ACCusername, String ACCpassword)
    {
        saveTextLog_Allure_er("Username and password are entered");
        findByClassType_SendKey(5, "XCUIElementTypeTextField", ACCusername);
        findByClassType_SendKey(5, "XCUIElementTypeSecureTextField", ACCpassword);
    }

    @Step("4. Tap Sign in button")
    private void SPRCOM_106904_Step4()
    {
        saveTextLog_Allure_er("Sign in Success, main page is displayed");
        findByAccessibilityID_Click(5, "Sign In");

        if(findByAccessibilityID_Exist(3, "Get Priority Status")) {
            iosDriver.navigate().back();
        }
    }
}
