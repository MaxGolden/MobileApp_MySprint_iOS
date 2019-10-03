package iOS_Base;

import Data.AccountOwner_Info;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeTest;

import static Util.iOS_Driver_Methods.*;

public class DefaultPages extends MainBase {

    private String Env = AccountOwner_Info.getData()[0][0].toString();
    private String MDN = AccountOwner_Info.getData()[0][1].toString();

    @BeforeTest(groups = {"MainBase"})
    @Severity(SeverityLevel.CRITICAL)
    public void pagesFirstLaunch() throws Exception {
        // Allow notification
//        findByID_Click(5, "Allow");
        if(findByID_Exist(8, "Allow")) {
            findByID_Click(5, "Allow");
        }

        if(findByID_Exist(45, "Continue")) {
            findByAccessibilityID_Click(3, "Continue");
            findByAccessibilityID_Click(3, "Continue");
            if(findByID_Exist(3, "Continue")) {
                findByAccessibilityID_Click(3, "Continue");
            }
        } else {
            findByAccessibilityID_Click(10, "Sign In");
            findByAccessibilityID_Click(5, "Create Your Profile");
            Thread.sleep(1000);
            findByCoord_Click(391, 68);
            findByID_Click(5, "App Settings");
            findByAccessibilityID_Click(5, "Environment");

            if(!findByID_Exist(5, Env)) {
                //(//XCUIElementTypeOther[@name="st2"])[2]
                findByAccessibilityID_Click(5, "Change Environment");
                Thread.sleep(1000);
                findByPoint_ScrollDown(true, 200, 750, 50);
                Thread.sleep(1000);
            }
            iosDriver.navigate().back();
            findByAccessibilityID_Click(5, "MDN");
            findByClassType_Click(5, "XCUIElementTypeTextField");
            findByClassType_SendKey(5, "XCUIElementTypeTextField", MDN);
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
