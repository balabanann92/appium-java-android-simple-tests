import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ScrollToComments extends Base {

    @Test
    public void testCommentsVisibility() throws Exception {
        PageFactory.initElements(new AppiumFieldDecorator(mobiledriver), this);
        //Given
        String searchText = "Appium";

        //When
        //SearchImageView
        MobileAction mobileAction = new MobileAction(mobiledriver);
        AndroidElement searchImageView = waitForPresence(mobiledriver, elementPresetTimeout, searchImageViewBy);
        Assert.assertTrue(searchImageView.isDisplayed());
        mobileAction.tapByElement(searchImageView);

        //SearchEditText
        AndroidElement searchTextView = waitForPresence(mobiledriver, elementPresetTimeout, searchEditTextBy);
        Assert.assertTrue(searchTextView.isDisplayed());
        searchTextView.sendKeys(searchText + "\n");

        //Wait for title
        Thread.sleep(2000);
        mobileAction.verticalSwipeByPercentages(0.8, 0.2, 0.5);
        mobileAction.verticalSwipeByPercentages(0.8, 0.3, 0.5);
        videoDetails.click();
        Thread.sleep(4000);
        AndroidElement channelTitle = waitForPresence(mobiledriver, elementPresetTimeout, channelTitleBy);
        Assert.assertTrue(channelTitle.isDisplayed());

        //Scroll to comment
        Thread.sleep(5000);
        mobileAction.scrollDownToElement(androidComment, 10);

        //Then
        //Assert comment
        Assert.assertTrue(Elements.isElementVisible(androidComment));
    }
}

//удалить скролл по поиску
//элемент видимый в басе
// цыкл по скролу до эл в мобэкшен
//остановить проигр видоса и проверить на кнопку плей