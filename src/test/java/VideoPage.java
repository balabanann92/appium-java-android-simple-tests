import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class VideoPage  {
    AndroidDriver driver;

    public VideoPage(AndroidDriver mobiledriver) {
        PageFactory.initElements(new AppiumFieldDecorator(mobiledriver), this);
    }

    @AndroidFindBy(id = "player_overlays")
    public AndroidElement videoPlayerOverlays;

    @AndroidFindBy(id = "player_control_play_pause_replay_button")
    public AndroidElement playPauseButton;

    @AndroidFindBy(id = "watch_player")
    public  AndroidElement player;


}


