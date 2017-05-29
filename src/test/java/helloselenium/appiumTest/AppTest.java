package helloselenium.appiumTest;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private static AndroidDriver driver;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/Apps/Amazon/");
        File app = new File(appDir, "in.amazon.mShop.android.shopping.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "TestAndroid");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "browser");
        capabilities.setCapability("platformVersion", "5.1");
//        capabilities.setCapability("app", app.getAbsolutePath());
//        capabilities.setCapability("appPackage", "com.android.chrome");
//        capabilities.setCapability("appActivity","com.google.android.apps.chrome.ChromeTabbedActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        driver.get("http://www.google.com");

        WebElement keyword = driver.findElementByName("q");
        keyword.sendKeys("Hello Selenium");
        keyword.sendKeys(Keys.ENTER);
//        driver.findElement(By.id("btnK")).click();

        Thread.sleep(10000);
        driver.quit();

    }
}
