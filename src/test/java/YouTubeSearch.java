import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class YouTubeSearch {
  public static AndroidDriver<?> mobiledriver;

    @BeforeTest
    public void setUpAppiumDriver() throws Exception{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appiumVersion", "1.9.1");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.1.2");
        capabilities.setCapability("deviceName", "and");
        capabilities.setCapability("udid", "LGD724273e98ee");
        capabilities.setCapability("appPackage", "com.google.android.youtube");
        capabilities.setCapability("appActivity", "com.google.android.apps.youtube.app.WatchWhileActivity");
        mobiledriver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);//Your appium server url
    }

    @Test
    public void testSearchClick() {
        mobiledriver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Search\"]")).click();
    }

    @AfterTest
    public void closeAppiumDriver() throws Exception{
        mobiledriver.quit();
    }
}


