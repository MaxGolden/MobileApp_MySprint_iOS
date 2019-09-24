package Util;

import iOS_Base.MainBase;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static Listeners_iOS.listeners_iOS.saveScreenshotPNG_Allure_Fail;
import static Listeners_iOS.listeners_iOS.saveTextLog_Allure;

public class iOS_Driver_Methods extends MainBase {

    private static String Error_Dialog_Title = "com.sprint.care.beta:id/dialogTitle_tv"; //??
    private static String Error_Dialog_Message = "com.sprint.care.beta:id/dialogMessage_tv"; //??
    private static String Error_Dialog_Positive = "com.sprint.care.beta:id/positive_btn"; //?
    private static String Error_Dialog_Password_Field = "T3stM3.P1s";
    private static String Error_Dialog_Password = "T3stM3.P1s";

    // Appium find element by using Resource ID and click with error dialog check
    public static void findByAccessibilityID_Click(int timeNum, String accessibilityID, boolean errorDialogCheck,
                                              String FailMessage) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        List<IOSElement> CountNum = iosDriver.findElementsById(accessibilityID);
        try {
            if(CountNum.size() > 0) {
                iosDriver.findElementById(accessibilityID).click();
            } else {
                if(errorDialogCheck) {
                    Error_dialog_detect(FailMessage);
                } else {
                    assertFail(true,10, FailMessage);
                }
            }
        }catch (NoSuchElementException e) {
            System.out.println("Exception");
        }
    }

    public static void findByAccessibilityID_Click(int timeNum, String accessibilityID) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        List<IOSElement> CountNum = iosDriver.findElementsByAccessibilityId(accessibilityID);
        try {
            if(CountNum.size() > 0) {
                iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
                iosDriver.findElementById(accessibilityID).click();
            } else {
                assertFail(true, 5, "Element not found");
            }
        }catch (NoSuchElementException e) {
            System.out.println("Exception");
        }
    }

    // Appium find element by using Resource ID and send keys
    public static void findByAccessibilityID_SendKey(int timeNum, String accessibilityID, String keysInfo) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        iosDriver.findElementById(accessibilityID).sendKeys(keysInfo);
    }

    public static void findByAccessibilityID_SendKey(int timeNum, String accessibilityID, String keysInfo, String FailMessage) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        List<IOSElement> CountNum = iosDriver.findElementsById(accessibilityID);
        try {
            if(CountNum.size() > 0) {
                iosDriver.findElementById(accessibilityID).sendKeys(keysInfo);
            } else {
                Error_dialog_detect(FailMessage);
            }
        }catch (NoSuchElementException e) {
            System.out.println("Exception");
        }
    }

    // Appium find element by using Resource ID and clear
    public static void findByAccessibilityID_Clear(int timeNum, String accessibilityID) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        iosDriver.findElementById(accessibilityID).clear();
    }

    // Appium find element by using Resource ID and get the text
    public static String findByAccessibilityID_GetText(int timeNum, String accessibilityID) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        return iosDriver.findElementById(accessibilityID).getText();
    }

    // Appium find element by using Resource ID and check the status is enabled
    public static boolean findByAccessibilityID_Enable(int timeNum, String accessibilityID) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        return iosDriver.findElementById(accessibilityID).isEnabled();
    }

    // Appium find element by using Resource ID and check existence
    public static List<IOSElement> findByAccessibilityID_Counts(int timeNum, String accessibilityID) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        return iosDriver.findElementsById(accessibilityID);
    }

    // Appium find element by using Resource ID and check existence
    public static boolean findByAccessibilityID_Exist(int timeNum, String accessibilityID) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        List<IOSElement> CountNum = iosDriver.findElementsById(accessibilityID);
        try {
            return CountNum.size() > 0;
        }catch (NoSuchElementException e) {
            System.out.println("Error: No such element found!");
        }
        return true;
    }

    public static void findByClassType_Clear(int timeNum, String classType) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        iosDriver.findElementByClassName(classType).clear();
    }
    public static void findByClassType_Clear(int timeNum, String classType, int index) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        iosDriver.findElementsByClassName(classType).get(index).clear();
    }
    // Appium find element by using class name and click
    public static void findByClassType_Click(int timeNum, String classType) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        iosDriver.findElementByClassName(classType).click();
    }

    public static void findByClassType_Click(int timeNum, String classType, int IndexNum) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        iosDriver.findElementsByClassName(classType).get(IndexNum).click();
    }

    public static void findByClassType_SendKey(int timeNum, String classType, String keys) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        iosDriver.findElementByClassName(classType).sendKeys(keys);
    }

    public static void findByClassType_SendKey(int timeNum, String classType, int index, String keys) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        iosDriver.findElementsByClassName(classType).get(index).sendKeys(keys);
    }

    public static boolean findByClassType_Exist(int timeNum, String classType) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        List<IOSElement> CountNum = iosDriver.findElementsByClassName(classType);
        try {
            return CountNum.size() > 0;
        }catch (NoSuchElementException e) {
            System.out.println("Error: No such element found!");
        }
        return true;
    }

    public static void findByName_Click(int timeNum, String className) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        iosDriver.findElementByName(className).click();
    }

    public static void findByName_SendKey(int timeNum, String className, String keys) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        iosDriver.findElementByName(className).sendKeys(keys);
    }

    public static boolean findByName_Exist(int timeNum, String className) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        List<IOSElement> CountNum = iosDriver.findElementsByName(className);
        try {
            return CountNum.size() > 0;
        }catch (NoSuchElementException e) {
            System.out.println("Error: No such element found!");
        }
        return true;
    }
    //'//XCUIElementTypeTable[@value="WebView"]'
    public static void findByValueXpath_Click(int timeNum, String classValue) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        iosDriver.findElementByXPath(classValue).click();
    }

    ////XCUIElementTypeStaticText[@name=" - Min. payment amount limit $1"]
    public static boolean findByValueXpath_Exist(int timeNum, String classValue) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        List<IOSElement> CountNum = iosDriver.findElementsByXPath(classValue);
        try {
            return CountNum.size() > 0;
        }catch (NoSuchElementException e) {
            System.out.println("Error: No such element found!");
        }
        return true;
    }

    // Appium find element by using value with text and click - "text(\"Add a new device\")"
    public static void findByID_Click(int timeNum, String textContent) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        iosDriver.findElementById(textContent).click();
    }

    public static void findByID_Click(int timeNum, String textContent, boolean errorDialogCheck) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        List<IOSElement> CountNum = iosDriver.findElementsById(textContent);
        try {
            if(CountNum.size() > 0) {
                iosDriver.findElementById(textContent).click();
            } else {
                if(errorDialogCheck) {
                    Error_dialog_detect("Error Dialog Found");
                } else {
                    assertFail(true, 10, "Element not found");
                }
            }
        }catch (NoSuchElementException e) {
            System.out.println("Exception");
        }
    }

    public static void findByID_SendKeys(int timeNum, String textContent, String keys) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        iosDriver.findElementById(textContent).sendKeys(keys);
    }
    // Appium find element by using value and check existence
    public static boolean findByID_Exist(int timeNum, String textContent) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        List<IOSElement> CountNum = iosDriver.findElementsById(textContent);
        try {
            return CountNum.size() > 0;
        }catch (NoSuchElementException e) {
            System.out.println("Error: No such element found!");
        }
        return true;
    }

    // Appium find element by using value with text and check the status is enabled
    public static List<IOSElement> findByID_Counts(int timeNum, String textContent) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        return iosDriver.findElementsById(textContent);
    }

    // Appium find element by using TouchAction with coordinators
    public static void findByCoord_Click(int X, int Y) {
        TouchAction t = new TouchAction(iosDriver);
        t.tap(PointOption.point(X, Y)).release().perform();
    }

    // Appium find element and scroll down by using TouchAction
    public static void findByaccessibilityID_ScrollDown(int timeNum, String Element1, String Element2, int TimeNum) {
        TouchAction t = new TouchAction(iosDriver);
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        IOSElement scroll_point1 = iosDriver.findElementById(Element1);
        IOSElement scroll_point2 = iosDriver.findElementById(Element2);
        t.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(scroll_point1))
                .withDuration(Duration.ofSeconds(TimeNum)))
                .moveTo(ElementOption.element(scroll_point2))
                .release()
                .perform();
    }

    public static void findByaccessibilityID_ScrollDown(int timeNum, String Element1, String Element2) {
        TouchAction t = new TouchAction(iosDriver);
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        IOSElement scroll_point1 = iosDriver.findElementById(Element1);
        IOSElement scroll_point2 = iosDriver.findElementById(Element2);
        t.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(scroll_point1))
                .withDuration(Duration.ofSeconds(40)))
                .moveTo(ElementOption.element(scroll_point2))
                .release()
                .perform();
    }

    public static void findByPoint_ScrollDown(boolean reverse, int X, int Y, int scrollDist) {
        TouchAction t = new TouchAction(iosDriver);
        if(reverse) {
            t.longPress(PointOption.point(X,Y))
                    .moveTo(PointOption.point(X, Y + scrollDist))
                    .release()
                    .perform();
        } else  {
            t.longPress(PointOption.point(X,Y + scrollDist))
                    .moveTo(PointOption.point(X, Y))
                    .release()
                    .perform();
        }
    }

    public static void findByPoint_ScrollDown(boolean reverse) {
        TouchAction t = new TouchAction(iosDriver);
        if(reverse) {
            t.longPress(PointOption.point(200,300))
                    .moveTo(PointOption.point(200, 1200))
                    .release()
                    .perform();
        } else  {
            t.longPress(PointOption.point(200,1200))
                    .moveTo(PointOption.point(200, 300))
                    .release()
                    .perform();
        }
    }

    // Appium find element by using Xpath and click
    public static void findByXpath_Click(int timeNum, String Xpath) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        iosDriver.findElementByXPath(Xpath).click();
    }

    private static void Error_dialog_detect(String FailMessage) {
        if(findByAccessibilityID_Exist(3, Error_Dialog_Title)) {
            String error_title = iosDriver.findElementById(Error_Dialog_Title).getText();
            if(error_title.toLowerCase().equals("unlock")) {
                iosDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                iosDriver.findElementById(Error_Dialog_Password_Field).sendKeys(Error_Dialog_Password);
                iosDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                iosDriver.findElementById(Error_Dialog_Positive).click();

                /////////// More progress //////////

                saveTextLog_Allure("Fast Login dialog detected, and login with account password");
            } else {
                String error_mes = iosDriver.findElementById(Error_Dialog_Message).getText();
                assertFail(
                        true, 5, "Error dialog detected, check detail with " +
                                "screenshot attachment \n MORE INFO: " + error_mes);
                iosDriver.quit();
            }
        } else if(findByAccessibilityID_Exist(3, "com.sprint.care.beta:id/warning")) {
            allure_mes("Sprint network unavailable");
            Assert.fail();
            iosDriver.quit();
        } else {
            assertFail(true, 5, FailMessage);
        }
    }

    // Allure message show in the allure report
    public static void allure_mes(String FailMessage) {
        saveTextLog_Allure("FAIL: " + FailMessage);
    }

    // Android Driver navigate back
    public static void navigateBack(int timeNum, int backTimes) throws Exception {
        Thread.sleep(timeNum * 1000);
        for(int i=1; i<=backTimes; i++) {
            if(findByAccessibilityID_Exist(5, "Make a payment")) {
                System.out.println("Back to the main page");
            } else {
                iosDriver.navigate().back();
            }
        }
    }

    public static void assertFail(boolean toMainPage, int backSteps, String FailMessage) {

        allure_mes(FailMessage);
        saveScreenshotPNG_Allure_Fail(iosDriver);

        if(toMainPage) {
            for(int i = 1; i <= backSteps; i++) {
                if(findByAccessibilityID_Exist(2, "com.sprint.care.beta:id/dialogTitle_tv")) {
                    findByAccessibilityID_Click(2, "com.sprint.care.beta:id/positive_btn");
                }
                iosDriver.navigate().back();
                if(findByAccessibilityID_Exist(5, "Make a payment")) {
                    Assert.fail();
                }
            }
        } else {
            Assert.fail();
        }
    }

}
