package SPRCOM_92088_iOS_Sales;

import iOS_Tests.MainBase;
import io.appium.java_client.ios.IOSElement;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static Listeners_Tests.Listeners_Example.saveTextLog_Allure;
import static Listeners_Tests.Listeners_Example.saveTextLog_Allure_er;

@Listeners(Listeners_Tests.Listeners_Example.class)
@Epic("SPRCOM-92088 My Sprint App iOS - Sales")
@Feature("SPRCOM-107200 My Sprint App iOS - LoginAO Sales")
public class SPRCOM_107200_iOS_LoginAO_Sales_MainPage_AddNewLine_Cart extends MainBase {

    public Float Monthly;
    public Float Today;

    @Test(groups = {"AccountOwner", "Login"}, priority = 2, dataProvider = "DeviceOption",
            dataProviderClass = Data.NewLine_DeviceOptions.class)
    @Description("My Sprint app Login - Sales: Add New Line with new device, which includes 'Add a New Device' " +
            "and 'Save Money Together' on the MainPage")
    @Severity(SeverityLevel.CRITICAL)
    @Story("SPRCOM-107202 My Sprint App iOS - MainPage: Add Device to Cart")
    public void SPRCOM_107202(String deviceType, String brand, String model, String planOption, String phonePlan,
                              String protectionOption) throws InterruptedException
    {
        SPRCOM_107202_Step1();
        SPRCOM_107202_Step2(deviceType);
        SPRCOM_107202_Step3(model);
        SPRCOM_107202_Step4();
        SPRCOM_107202_Step5(planOption);
        SPRCOM_107202_Step6(phonePlan);
        SPRCOM_107202_Step7(protectionOption);
        SPRCOM_107202_Step8();

    }

    @Step("1. Make sure MainPage loaded and Tap ‘Add a New Device’")
    private void SPRCOM_107202_Step1() throws InterruptedException
    {
        saveTextLog_Allure_er("Bottom Sheet should pop up with different type of devices");
        saveTextLog_Allure_er("Button ‘Make a payment’ is displayed in main page");
        iosDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        List<IOSElement> payment_m =iosDriver.findElementsById("Make a payment");
        try {
            if(payment_m.size() < 1) {
                System.out.println("FAIL: 15sec ... No main page showed with unknown reason! - Screenshot taken");
                saveTextLog_Allure("FAIL: 15sec ... No main page showed with unknown reason! - Screenshot taken");
                Assert.fail();
            }
        }catch (NoSuchElementException e) {
            System.out.println("Error: No such element found!");
        }

        iosDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        iosDriver.findElementByAccessibilityId("Add a New Device").click();

    }

    @Step("2. Tap Phones icon")
    private void SPRCOM_107202_Step2(String deviceType)
    {
        saveTextLog_Allure_er("Loading for a long time at first launch(20s) and Shop devices page is displayed");
        iosDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        iosDriver.findElementById(deviceType).click();
    }
    @Step("3. Default filter, tap ‘Apple iPhone XS’")
    private void SPRCOM_107202_Step3(String model)
    {
        saveTextLog_Allure_er("Device Details page is displayed");
        iosDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        iosDriver.findElementById(model).click();
    }
    @Step("4. Make sure Continue button is enabled and tap it")
    private void SPRCOM_107202_Step4()
    {
        saveTextLog_Allure_er("Payment page is displayed");
        iosDriver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        Assert.assertTrue(iosDriver.findElementByAccessibilityId("Continue").isEnabled());
        System.out.println("PASS: Continue - Default status is enabled");
        iosDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        iosDriver.findElementById("Continue").click();
    }

    @Step("5. Use Data Provider with three options and tap continue")
    private void SPRCOM_107202_Step5(String planOption)
    {
        saveTextLog_Allure_er("Wait for loading(20s) and Plans page is displayed");
        iosDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        iosDriver.findElementById(planOption).click();

        List<IOSElement> Device_Detail = iosDriver.findElementsByClassName("XCUIElementTypeStaticText");
//        System.out.println(Device_Detail);
//        for (IOSElement iosElement : Device_Detail) {
//            System.out.println(iosElement.getText());
//        }
        Today = Float.valueOf(Device_Detail.get(5).getText().replace("$", " "));
        Monthly = Float.valueOf(Device_Detail.get(6).getText().replace("$", " "));

        iosDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        iosDriver.findElementById("Continue").click();
    }
    @Step("6. Make sure default Continue button is disabled and click default shared plan ($20)? , tap Continue")
    private void SPRCOM_107202_Step6(String phonePLan)
    {
        saveTextLog_Allure_er("Protection page is displayed");
        iosDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        iosDriver.findElementById(phonePLan).click();

        if(phonePLan.equals("Unlimited Savings Plan")) {
            Monthly = Monthly + 20;
        }

        iosDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertTrue(iosDriver.findElementByAccessibilityId("Select and continue").isEnabled());
        System.out.println("PASS: Continue - status is enabled");

        iosDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        iosDriver.findElementById("Select and continue").click();
    }
    @Step("7. Tap button ‘Add protection’?")
    private void SPRCOM_107202_Step7(String protectionOption) throws InterruptedException
    {
        saveTextLog_Allure_er("Wait for loading(15s), Cart page is displayed");
        if(protectionOption.equals("Add protection")) {
            Monthly = Monthly + 19;
        }
        iosDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        iosDriver.findElementById(protectionOption).click();
    }
    @Step("8. Verify the value of monthly and today due")
    private void SPRCOM_107202_Step8() throws InterruptedException
    {
        saveTextLog_Allure_er("All payment values are correct");

        Thread.sleep(5000);
        iosDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Assert.assertTrue(iosDriver.findElementByAccessibilityId("Cancel").isEnabled());

        List<IOSElement> Device_Detail = iosDriver.findElementsByClassName("XCUIElementTypeStaticText");
//        for (IOSElement iosElement : Device_Detail) {
//            System.out.println(iosElement.getText());
//        }
        Assert.assertEquals(Monthly, Float.valueOf(Device_Detail.get(7).getText().replace("$", "")));
        // Add Shipping fee before checkout
        Today = Today + 10;
        Assert.assertEquals(Today, Float.valueOf(Device_Detail.get(9).getText().replace("$", "")));
        saveTextLog_Allure("Due Value verify Success");
        iosDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        iosDriver.findElementById("Cancel").click();
        Thread.sleep(2000);
    }


}
