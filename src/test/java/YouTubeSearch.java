import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsString;


public class YouTubeSearch {
  public static AndroidDriver<AndroidElement> mobiledriver;
  public static int elementPresetTimeout = 15;

  // TouchAction action = new TouchAction(mobiledriver);

    @BeforeTest
    public void setUp() throws Exception{
        mobiledriver = AndroidSetup.getDriver(AndroidSetup.getLgDevice());
    }


    @Test
    public void testSearchTextInput() throws InterruptedException {
        //Given
        String searchText = "Appium";

        //When
//       mobiledriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        isElementPresent(mobiledriver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Search\"]")), elementPresetTimeout);
        AndroidElement searchImageView = mobiledriver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Search\"]"));
//        isElementPresent(searchImageView, elementPresetTimeout);
        searchImageView.click();
        //mobiledriver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Search\"]")).click();

        //AndroidElement searchTextView = mobiledriver.findElementById("com.google.android.youtube:id/search_edit_text");
        //isElementPresent(searchTextView, elementPresetTimeout);
        //searchTextView.sendKeys(searchText + "\n");
        mobiledriver.findElementById("com.google.android.youtube:id/search_edit_text").sendKeys(searchText + "\n");


        // Then
     //   mobiledriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //    AndroidElement title = mobiledriver.findElementById("com.google.android.youtube:id/title");

        isElementPresent(mobiledriver.findElementById("com.google.android.youtube:id/title"),elementPresetTimeout);
      //  AndroidElement title = mobiledriver.findElementById("com.google.android.youtube:id/title");
      //  isElementPresent(title,elementPresetTimeout);
      //  System.out.println( mobiledriver.findElementById("com.google.android.youtube:id/title"));

        String actualText = mobiledriver.findElementById("com.google.android.youtube:id/title").getText();
     //   String actualText = title.getText();
        //System.out.println(actualText);
        MatcherAssert.assertThat(actualText, containsString(searchText));

    }

    @AfterTest
    public void tearDown() throws Exception{
        mobiledriver.quit();


    }

    public boolean isElementPresent(AndroidElement title, int timeout){
        try{
            WebDriverWait wait = new WebDriverWait(mobiledriver, timeout, 10000);
            wait.until(ExpectedConditions.visibilityOf(title));
            return true;
        }catch(Exception e){
            return false;
        }
    } }



