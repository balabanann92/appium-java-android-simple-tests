import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;

public class YouTubeSearch {
  public static AndroidDriver<?> mobiledriver;

    @BeforeTest
    public void setUp() throws Exception{
        mobiledriver = AndroidSetup.getDriver(AndroidSetup.getLgDevice());
    }

    @Test
    public void testSearchClick() {
        mobiledriver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Search\"]")).click();
    }

    @AfterTest
    public void tearDown() throws Exception{
        mobiledriver.quit();
    }
}


