import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {

    By searchImageViewBy = By.xpath("\t//android.widget.ImageView[@content-desc=\"Search\"]");
    By searchEditTextBy = By.id("com.google.android.youtube:id/search_edit_text");
    By titleBy = By.id("com.google.android.youtube:id/title");
    By channelTitleBy = By.id("com.google.android.youtube:id/channel_title_container");
    By commentsCounterViewBy = By.id("com.google.android.youtube:id/comments_count");

    public static int elementPresetTimeout = 300;

    public static AndroidDriver<AndroidElement> mobiledriver;
    @BeforeTest
    public void setUp() throws Exception{
        mobiledriver = AndroidSetup.getDriver(AndroidSetup.getLgDevice());

    }
    @AfterTest
    public void tearDown() throws Exception{
        mobiledriver.quit();
    }

    public AndroidElement findById(String id) throws Exception {
        By findBy = By.id(id);
        return waitForPresence(mobiledriver, elementPresetTimeout, findBy);
    }

    public static AndroidElement waitForPresence(AndroidDriver driver, int timeLimitInSeconds, By by) throws Exception {
        try {
            AndroidElement mobileElement = (AndroidElement) mobiledriver.findElement(by);
            WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
            wait.until(ExpectedConditions.visibilityOf(mobileElement));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            wait.until(ExpectedConditions.elementToBeClickable(mobileElement));
            return mobileElement;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
