import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {

    By searchImageViewBy = By.xpath("//android.widget.ImageView[@content-desc=\"Search\"]");
    By searchEditTextBy = By.id("com.google.android.youtube:id/search_edit_text");
    By titleBy = By.id("com.google.android.youtube:id/title");
    By channelTitleBy = By.id("com.google.android.youtube:id/channel_title_container");
    By commentsCounterViewBy = By.id("com.google.android.youtube:id/comments_count");

    @AndroidFindBy(id = "com.google.android.youtube:id/comments_count")
    public MobileElement androidComment;

    @AndroidFindBy(id = "com.google.android.youtube:id/title")
    public MobileElement androidTextView;

    @AndroidFindBy(id = "com.google.android.youtube:id/author")
    public MobileElement videoDetails;

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

    public static AndroidElement waitForPresence(AndroidDriver driver, int timeLimitInSeconds, By by) {
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

    public static void waitForElement(AndroidElement element, AndroidDriver driver, int timeLimitInSeconds) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
