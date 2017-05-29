package helloselenium.appiumTest;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AndroidBrowser {
    private static AndroidDriver driver;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "TestAndroid");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "browser");
        capabilities.setCapability("platformVersion", "5.1");
        //capabilities.setCapability("orientation", "landscape");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        driver.get("http://www.google.com");

        WebElement keyword = driver.findElement(By.name("q"));
        keyword.sendKeys("abhishek yadav qa");
        keyword.sendKeys(Keys.ENTER);

        Thread.sleep(5000);
        driver.quit();
    }
}
