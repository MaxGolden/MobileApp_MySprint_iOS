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
public class SPRCOM_106900_iOS_ENV_MDN extends MainBase {

    @Test(groups = {"AccountOwner", "Login"}, priority = 1, dataProvider = "AccountOwner",
            dataProviderClass = Data.AccountOwner_Info.class)
    @Description("My Sprint app change Env and matched MDN")
    @Severity(SeverityLevel.CRITICAL)
    @Story("SPRCOM-106902 Change Env and MDN")
    public void SPRCOM_106902(String Env, String MDN, String ACCusername, String ACCpassword) throws Exception
    {
        SPRCOM_106902_Step1();
        SPRCOM_106902_Step2();
        SPRCOM_106902_Step3();
        SPRCOM_106902_Step4(MDN);
        SPRCOM_106902_Step5();
        SPRCOM_106902_Step6(Env);
    }

    @Step("1. Tap the profile icon in the upper right corner")
    private void SPRCOM_106902_Step1()
    {
        saveTextLog_Allure_er("Bottom Sheet should pop up");
        if(!findByAccessibilityID_Exist(10, "Make a payment")) {
            assertFail(false, 0, "Make a payment button not found!");
        }
        findByCoord_Click(380, 66);
    }

    @Step("2. Tap App Settings in the bottom sheet")
    private void SPRCOM_106902_Step2()
    {
        saveTextLog_Allure_er("Settings page is displayed");
        findByID_Click(5, "App Settings");
    }

    @Step("3. Scroll down and click ‘MDN’")
    private void SPRCOM_106902_Step3()
    {
        saveTextLog_Allure_er("MDN page is displayed");
        findByAccessibilityID_Click(5, "MDN");
    }

    @Step("4. Enter the phone number and tap Save")
    private void SPRCOM_106902_Step4(String MDN) throws Exception
    {
        saveTextLog_Allure_er("Current Page is loading and back to MDN page");
        if(!findByID_Exist(5, MDN)) {
            findByClassType_SendKey(5, "XCUIElementTypeTextField", "3369549079");
            findByAccessibilityID_Click(5, "save");
            Thread.sleep(5000);
        }
    }

    @Step("5. Tap return icon and tap Environment")
    private void SPRCOM_106902_Step5()
    {
        saveTextLog_Allure_er("Environment page is displayed");
        iosDriver.navigate().back();
        findByAccessibilityID_Click(5, "Environment");
    }

    @Step("6. Check the environment setting and click back and tap Done")
    private void SPRCOM_106902_Step6(String Env) throws Exception
    {
        saveTextLog_Allure_er("Main page is displayed");
        if(!findByID_Exist(5, Env)) {
            //(//XCUIElementTypeOther[@name="st2"])[2]
            findByAccessibilityID_Click(5, "Change Environment");
            Thread.sleep(1000);
            findByPoint_ScrollDown(true, 200, 750, 50);
            Thread.sleep(1000);
        }
        iosDriver.navigate().back();
        findByAccessibilityID_Click(5, "Done");
    }
}
