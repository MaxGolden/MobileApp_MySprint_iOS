package iOS_Base;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeTest;

import static Util.iOS_Driver_Methods.*;


public class DefaultPages extends MainBase {

    @BeforeTest(groups = {"MainBase"})
    @Severity(SeverityLevel.CRITICAL)
    public void pagesFirstLaunch() throws Exception {
        // Allow notification
//        findByID_Click(5, "Allow");
        if(findByID_Exist(8, "Allow")) {
            findByID_Click(5, "Allow");
        }

        if(findByID_Exist(15, "Continue")) {
            findByAccessibilityID_Click(3, "Continue");
            findByAccessibilityID_Click(3, "Continue");
            if(findByID_Exist(3, "Continue")) {
                findByAccessibilityID_Click(3, "Continue");
            }
        } else {
            findByAccessibilityID_Click(30, "Sign In");
            findByAccessibilityID_Click(5, "Create Your Profile");
            Thread.sleep(1000);
            findByCoord_Click(391, 68);
            findByID_Click(5, "App Settings");
            findByAccessibilityID_Click(5, "Environment");
            findByAccessibilityID_Click(5, "Change Environment");
            Thread.sleep(1000);
            findByPoint_ScrollDown(true, 200, 750, 50);
            Thread.sleep(1000);
            iosDriver.navigate().back();
            findByAccessibilityID_Click(5, "MDN");
            findByClassType_Click(5, "XCUIElementTypeTextField");
            findByClassType_SendKey(5, "XCUIElementTypeTextField", "3369549079");
            findByAccessibilityID_Click(5, "Save");
            Thread.sleep(7000);
            iosDriver.navigate().back();
            findByAccessibilityID_Click(5, "Done");
            Thread.sleep(500);
            iosDriver.navigate().back();
            findByAccessibilityID_Click(5, "Done");
            if(findByID_Exist(20, "Continue")) {
                findByAccessibilityID_Click(3, "Continue");
                findByAccessibilityID_Click(3, "Continue");
                if (findByID_Exist(3, "Continue")) {
                    findByAccessibilityID_Click(3, "Continue");
                }
            } else {
                assertFail(false, 0, "Unknown Error");
            }
        }
    }
}
