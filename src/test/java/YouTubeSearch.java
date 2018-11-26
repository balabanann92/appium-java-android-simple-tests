import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;


public class YouTubeSearch {
  public static AndroidDriver<AndroidElement> mobiledriver;
  public static int elementPresetTimeout = 1500;



    @BeforeTest
    public void setUp() throws Exception{
        mobiledriver = AndroidSetup.getDriver(AndroidSetup.getLgDevice());
    }


    @Test
    public void testSearchTextInput() throws InterruptedException {
        //Given
        String searchText = "Appium";

        //When

        //Assert searchImageView
        String searchImageViewXPath = "//android.widget.ImageView[@content-desc=\"Search\"]";
        By searchImageViewBy = By.xpath(searchImageViewXPath);
        boolean isSearchImageViewPresent = waitForPresence(mobiledriver, 1500, searchImageViewBy);
      //  Assert.assertTrue(isSearchImageViewPresent);

        //Click searchImageView
        AndroidElement searchImageView = mobiledriver.findElement(By.xpath(searchImageViewXPath));
        searchImageView.click();

        //Assert searchEditText
        String searchEditTextId = "com.google.android.youtube:id/search_edit_text";
        By searchEditTextBy = By.id(searchEditTextId);
        boolean isSearchEditTextPresent = waitForPresence(mobiledriver, 100, searchEditTextBy);
      //  Assert.assertTrue(isSearchEditTextPresent);

        //Input searchText in to searchTextView
        AndroidElement searchTextView = mobiledriver.findElement(searchEditTextBy);
        searchTextView.sendKeys(searchText + "\n");

        // Then
        //Assert title
        String titleId = "com.google.android.youtube:id/title";
        By titleBy = By.id(titleId);
        boolean isTitlePresent = waitForPresence(mobiledriver, 500, titleBy);
//       Assert.assertTrue(isTitlePresent);



        //Assert input search text
        AndroidElement title = mobiledriver.findElement(titleBy);
        String actualText = title.getText();
        MatcherAssert.assertThat(actualText, containsString(searchText));
    }

    @AfterTest
   public void tearDown() throws Exception{
     mobiledriver.quit();
   }

    public static boolean waitForPresence(AndroidDriver driver, int timeLimitInSeconds, By by){
        try{
            AndroidElement mobileElement = (AndroidElement) driver.findElement(by);
            WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
            wait.until(ExpectedConditions.visibilityOf(mobileElement));
            boolean isElementPresent = mobileElement.isDisplayed();
            return isElementPresent;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }


    }
}



