import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;


public class YouTubeSearch {
  public static AndroidDriver<AndroidElement> mobiledriver;
  public static int elementPresetTimeout = 100;

    @BeforeTest
    public void setUp() throws Exception{
        mobiledriver = AndroidSetup.getDriver(AndroidSetup.getLgDevice());
    }


    @Test
    public void testSearchTextInput() throws Exception {
        //Given
        String searchText = "Appium";

        //When
        //SearchImageView
        String searchImageViewXPath = "//android.widget.ImageView[@content-desc=\"Search\"]";
        By searchImageViewBy = By.xpath(searchImageViewXPath);
        AndroidElement searchImageView = waitForPresence(mobiledriver, elementPresetTimeout, searchImageViewBy);
        Assert.assertTrue(searchImageView.isDisplayed());
        searchImageView.click();

        //SearchEditText
        String searchEditTextId = "com.google.android.youtube:id/search_edit_text";
        By searchEditTextBy = By.id(searchEditTextId);
        AndroidElement searchTextView = waitForPresence(mobiledriver, elementPresetTimeout, searchEditTextBy);
        Assert.assertTrue(searchTextView.isDisplayed());
        searchTextView.sendKeys(searchText + "\n");

        // Then
        //Assert title
        String titleId = "com.google.android.youtube:id/title";
        By titleBy = By.id(titleId);

        AndroidElement title = (AndroidElement) mobiledriver.findElements(titleBy).get(0);
        WebDriverWait wait = new WebDriverWait(mobiledriver, elementPresetTimeout);
        wait.until(ExpectedConditions.visibilityOf(title));
        wait.until(ExpectedConditions.presenceOfElementLocated(titleBy));
        wait.until(ExpectedConditions.elementToBeClickable(title));

        //AndroidElement title = waitForPresence(mobiledriver, elementPresetTimeout, titleBy);
        Assert.assertTrue(title.isDisplayed());

        //Assert input search text
        String actualText = title.getText();
        MatcherAssert.assertThat(actualText, containsString(searchText));
    }

    @AfterTest
    public void tearDown() throws Exception{
        mobiledriver.quit();
    }

    public static AndroidElement waitForPresence(AndroidDriver driver, int timeLimitInSeconds, By by) throws Exception {
        try {
            AndroidElement mobileElement = (AndroidElement) driver.findElement(by);
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
