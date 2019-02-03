import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VideoDetails extends Base {
    VideoPage objVideo;

    @Test
    public void testStopVideo() throws Exception {
       PageFactory.initElements(new AppiumFieldDecorator(mobiledriver), this);


        objVideo = new VideoPage(mobiledriver);

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
        videoDetails.click();
        Thread.sleep(4000);
        AndroidElement channelTitle = waitForPresence(mobiledriver, elementPresetTimeout, channelTitleBy);
        Assert.assertTrue(channelTitle.isDisplayed());

        //Video player interaction
        objVideo.player.click();
        waitForElement(objVideo.videoPlayerOverlays, mobiledriver, elementPresetTimeout);
        objVideo.playPauseButton.click();

        //Video overlay disappear after few seconds of video playing
        //Waiting for this delay and verify, that play element visible
        Thread.sleep(3000);
        Assert.assertTrue(Elements.isElementPresent(objVideo.videoPlayerOverlays));
    }
}

