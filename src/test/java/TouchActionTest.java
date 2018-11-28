//import io.appium.java_client.TouchAction;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidElement;
//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//
//public class TouchActionTest {
//    public static AndroidDriver<AndroidElement> mobiledriver;
//
//    @BeforeTest
//    public void setUp() throws Exception {
//        mobiledriver = AndroidSetup.getDriver(AndroidSetup.getLgDevice());
//    }
//
//
//    @Test
//    public void testSearchTouchAction() throws InterruptedException {
//        //Given
//        String searchText = "Appium";
//
//        //When
//        TouchAction action = new TouchAction(mobiledriver);
//        String searchImageViewXPath = "//android.widget.ImageView[@content-desc=\"Search\"]";
//        By searchImageViewBy = By.xpath(searchImageViewXPath);
//        TouchAction tap = action.tap(searchImageViewBy);
//        // Then
//
//    }
//        @AfterTest
//        public void tearDown () throws Exception {
//            mobiledriver.quit();
//        }
//
//        public static boolean waitForPresence (AndroidDriver driver,int timeLimitInSeconds, By by){
//            try {
//                AndroidElement mobileElement = (AndroidElement) driver.findElement(by);
//                WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
//                wait.until(ExpectedConditions.visibilityOf(mobileElement));
//                boolean isElementPresent = mobileElement.isDisplayed();
//                return isElementPresent;
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//                return false;
//            }
//        }
//
//
//    }
