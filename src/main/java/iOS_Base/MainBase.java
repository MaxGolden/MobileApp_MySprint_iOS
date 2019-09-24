package iOS_Base;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.File;
import java.net.URL;

public class MainBase {

    public static IOSDriver<IOSElement> iosDriver=null;
    
    private static void unzip(File appZip, String dest, String pw){
        try {
            ZipFile zipFile = new ZipFile(appZip);
            if (zipFile.isEncrypted()) {
                zipFile.setPassword(pw);
            }
            zipFile.extractAll(dest);
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }
    
    @BeforeSuite(groups = "MainBase")
    @Parameters({"appS3Url", "deviceName", "versionNO", "portNum"})
    @Severity(SeverityLevel.CRITICAL)
    public static IOSDriver<IOSElement> setUp(String appS3Url, String deviceName, String versionNO, String portNum) throws Exception
    {
        String destDir = "src/main/java/app/";
        boolean exist_file = new File(destDir + "SprintBeta.app.zip").exists();
        if(!exist_file) {
            FileUtils.copyURLToFile(new URL(appS3Url), new File(destDir + "SprintBeta.app.zip"));
            File appZip = new File(destDir+"SprintBeta.app.zip");
            unzip(appZip, destDir, "None");
        }
        File app = new File("src/main/java/app","SprintBeta.app");
        
        DesiredCapabilities d = new DesiredCapabilities();
        d.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        d.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
        d.setCapability(MobileCapabilityType.PLATFORM_VERSION, versionNO);
        d.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        d.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        iosDriver = new IOSDriver<>(new URL("http://127.0.0.1:" + portNum + "/wd/hub"), d);
        System.out.println("System: \n My Sprint Beta - \n Test Device: " + deviceName + "\n App Version: 618 " +
                "\n Others: N/A \n -----------------------------------------------");

        return iosDriver;
    }

    @AfterSuite(groups = "MainBase")
    public void tearDown() {
        iosDriver.quit();
        System.out.println("System: Test Done, iOS Driver Quitting ...\n -----------------------------------------------");
    }
}
