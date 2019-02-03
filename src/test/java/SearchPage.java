import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends Base{
    AndroidDriver driver;

    public SearchPage(AndroidDriver mobiledriver) {

        PageFactory.initElements(new AppiumFieldDecorator(mobiledriver), this);


    }

    @AndroidFindBy(id = "menu_filter_results")
    public AndroidElement FilterForResultSet;

    @AndroidFindBy(id = "apply")
    public AndroidElement FilterApplyButton;

    @AndroidFindBy(id = "spinner_0")
    public AndroidElement SortBy;

    @AndroidFindBy(id = "spinner_1")
    public AndroidElement TypeBy;

    @AndroidFindBy(id = "spinner_2")
    public AndroidElement UploadBy;

    @AndroidFindBy(id = "spinner_3")
    public AndroidElement DurationBy;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"View Count\")")
    public AndroidElement LinkTextSort;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Video\")")
    public AndroidElement LinkTextType;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"This week\")")
    public AndroidElement LinkTextUpload;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Long (> 20 minutes)\")")
    public AndroidElement LinkTextDuration;



//        @AndroidFindBy(id = "text1")
//        public List<AndroidElement> ActualValues;


        By filterSortByBy = By.id("spinner_0");
    By searchResultBy = By.id("results");

   // By SortByViewCountBy = By.LinkText("View Count");


    void searchByText(String searchText)  {
        AndroidElement searchTextView = waitForPresence(mobiledriver, elementPresetTimeout, searchEditTextBy);
        searchTextView.sendKeys(searchText + "\n");
    }
}

