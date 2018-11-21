import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class AndroidSetup {
    private String automationName;
    private String appiumVersion;
    private String platformName;
    private String platformVersion;
    private String deviceName;
    private String udid;
    private String appPackage;
    private String appActivity;
    private String url;

    //Constructor
    public AndroidSetup(String platformVersion,
                        String deviceName, String udid,
                        String appPackage, String appActivity) {
        this.automationName = "Appium";
        this.appiumVersion = "1.9.1";
        this.platformName = "Android";
        this.platformVersion = platformVersion;
        this.deviceName = deviceName;
        this.udid = udid;
        this.appPackage = appPackage;
        this.appActivity = appActivity;
        this.url = "http://0.0.0.0:4723/wd/hub";
    }

    //Factory method that creates new instance of Android Setup related to LG Device
    public static AndroidSetup getLgDevice() {
        return new AndroidSetup(
                "7.1.2",
                "and",
                "LGD724273e98ee",
                "com.google.android.youtube",
                "com.google.android.apps.youtube.app.WatchWhileActivity");
    }

    //Factory method that creates new instance of Android Driver related to passed setup parameter
    public static AndroidDriver<AndroidElement> getDriver(AndroidSetup setup) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", setup.automationName);
        capabilities.setCapability("appiumVersion", setup.appiumVersion);
        capabilities.setCapability("platformName", setup.platformName);
        capabilities.setCapability("platformVersion", setup.platformName);
        capabilities.setCapability("deviceName", setup.deviceName);
        capabilities.setCapability("udid", setup.udid);
        capabilities.setCapability("appPackage", setup.appPackage);
        capabilities.setCapability("appActivity", setup.appActivity);
        return new AndroidDriver<AndroidElement>(new URL(setup.url), capabilities);
    }
}