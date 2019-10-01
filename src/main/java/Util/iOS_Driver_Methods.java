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

    private static String Error_Dialog_Button = "OK";
    private static String Error_Dialog_Password = "T3stM3.P1s";

    // Appium iOS find element by using Resource ID
    public static void findByAccessibilityID_Click(int timeNum, String accessibilityID, boolean errorDialogCheck) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        List<IOSElement> CountNum = iosDriver.findElementsByAccessibilityId(accessibilityID);
        try {
            if(CountNum.size() > 0) {
                iosDriver.findElementByAccessibilityId(accessibilityID).click();
            } else {
                if(errorDialogCheck) {
                    Error_dialog_detect("Server error");
                } else {
                    assertFail(true,10, "Element not found");
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
                iosDriver.findElementByAccessibilityId(accessibilityID).click();
            } else {
                assertFail(true, 5, "Element not found");
            }
        }catch (NoSuchElementException e) {
            System.out.println("Exception");
        }
    }

    public static void findByAccessibilityID_SendKey(int timeNum, String accessibilityID, String keysInfo) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        iosDriver.findElementByAccessibilityId(accessibilityID).sendKeys(keysInfo);
    }

    public static void findByAccessibilityID_SendKey(int timeNum, String accessibilityID, String keysInfo, String FailMessage) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        List<IOSElement> CountNum = iosDriver.findElementsByAccessibilityId(accessibilityID);
        try {
            if(CountNum.size() > 0) {
                iosDriver.findElementByAccessibilityId(accessibilityID).sendKeys(keysInfo);
            } else {
                Error_dialog_detect(FailMessage);
            }
        }catch (NoSuchElementException e) {
            System.out.println("Exception");
        }
    }

    public static void findByAccessibilityID_Clear(int timeNum, String accessibilityID) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        iosDriver.findElementByAccessibilityId(accessibilityID).clear();
    }

    public static String findByAccessibilityID_GetText(int timeNum, String accessibilityID) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        return iosDriver.findElementByAccessibilityId(accessibilityID).getText();
    }

    public static boolean findByAccessibilityID_Enable(int timeNum, String accessibilityID) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        return iosDriver.findElementByAccessibilityId(accessibilityID).isEnabled();
    }

    public static List<IOSElement> findByAccessibilityID_Counts(int timeNum, String accessibilityID) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        return iosDriver.findElementsByAccessibilityId(accessibilityID);
    }

    public static boolean findByAccessibilityID_Exist(int timeNum, String accessibilityID) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        List<IOSElement> CountNum = iosDriver.findElementsByAccessibilityId(accessibilityID);
        try {
            return CountNum.size() > 0;
        }catch (NoSuchElementException e) {
            System.out.println("Error: No such element found!");
        }
        return true;
    }

    // Appium iOS find element by using class Type
    public static void findByClassType_Click(int timeNum, String classType) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        iosDriver.findElementByClassName(classType).click();
    }

    public static void findByClassType_Click(int timeNum, String classType, int IndexNum) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        iosDriver.findElementsByClassName(classType).get(IndexNum).click();
    }

    public static void findByClassType_Clear(int timeNum, String classType) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        iosDriver.findElementByClassName(classType).clear();
    }

    public static void findByClassType_Clear(int timeNum, String classType, int index) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        iosDriver.findElementsByClassName(classType).get(index).clear();
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

    // Appium iOS find element by using class name
    public static void findByName_Click(int timeNum, String className) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        iosDriver.findElementByName(className).click();
    }

    public static void findByName_SendKey(int timeNum, String className, String keys) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        iosDriver.findElementByName(className).sendKeys(keys);
    }

    public static void findByName_Clear(int timeNum, String className) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        iosDriver.findElementByName(className).clear();
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

    // Appium find element by using value with text - "text(\"Add a new device\")"
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

    // Appium iOS find element by using TouchAction with coordinators
    public static void findByCoord_Click(int X, int Y) {
        TouchAction t = new TouchAction(iosDriver);
        t.tap(PointOption.point(X, Y)).release().perform();
    }

    // Appium iOS find element by using Xpath
    public static void findByValueXpath_Click(int timeNum, String classValue) {
        iosDriver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
        iosDriver.findElementByXPath(classValue).click();
    }

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

    // Appium iOS scroll down by using TouchAction
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

    private static void Error_dialog_detect(String FailMessage) {
        if(findByID_Exist(3, Error_Dialog_Button)) {
            assertFail(true, 5, "Error dialog detected, check detail with " +
                            "screenshot attachment");
        } else if(findByAccessibilityID_Exist(3, "Sign In")) {
            iosDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            iosDriver.findElementByClassName("XCUIElementTypeSecureTextField").sendKeys(Error_Dialog_Password);
            iosDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            iosDriver.findElementByAccessibilityId("Sign In").click();
            saveTextLog_Allure("Login page detected, and login with account password");
        } else {
            assertFail(true, 5, FailMessage);
        }
    }

    // Allure message show in the allure report
    private static void allure_mes(String FailMessage) {
        saveTextLog_Allure("FAIL: " + FailMessage);
    }

    // Assert fail and back to main page
    public static void assertFail(boolean toMainPage, int backSteps, String FailMessage) {
        allure_mes(FailMessage);
        saveScreenshotPNG_Allure_Fail(iosDriver);
        if(toMainPage) {
            for(int i = 1; i <= backSteps; i++) {
                if(findByID_Exist(2, "OK")) {
                    findByID_Click(2, "OK");
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
