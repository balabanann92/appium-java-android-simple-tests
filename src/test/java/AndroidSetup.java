import java.net.URL;
import io.appium.java_client.android.AndroidDriver;

public class AndroidSetup {
    public String automationName;
    public String appiumVersion;
    public String platformName;
    public String platformVersion;
    public String deviceName;
    public String udid;
    public String appPackage;
    public String appActivity;
    public String URL;
    public AndroidDriver mobiledriver;
}


//    DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("automationName", "Appium");
//                capabilities.setCapability("appiumVersion", "1.9.1");
//                capabilities.setCapability("platformName", "Android");
//                capabilities.setCapability("platformVersion", "7.1.2");
//                capabilities.setCapability("deviceName", "and");
//                capabilities.setCapability("udid", "LGD724273e98ee");
//                capabilities.setCapability("appPackage", "com.google.android.youtube");
//                capabilities.setCapability("appActivity", "com.google.android.apps.youtube.app.WatchWhileActivity");
//                mobiledriver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);//Your appium server url