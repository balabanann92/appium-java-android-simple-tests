import io.appium.java_client.android.AndroidElement;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsString;

public class YouTubeSearch extends Base {
    @Test
    public void testSearchTextInput() throws Exception {
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

        // Then
        //Assert title
        WebDriverWait wait = new WebDriverWait(mobiledriver, elementPresetTimeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(titleBy));
        String actualText = mobiledriver.findElement(titleBy).getText();
        MatcherAssert.assertThat(actualText, containsString(searchText));
    }


}

// I. Refactor
// 1. Add marker annotation for repeated functions
// https://www.geeksforgeeks.org/annotations-in-java
// Sample:
// @find(xpath ="")
// public static function_name

// 2. Move waitForPresence to another class

// 3. Reduce size of tests

// II. Add new tests
// 1. Scroll and open
// - Find video with text "Appiun"
// - Scroll feed (few times)
// - Open video
// - Verify title for search text

// 2. Comments number
// - Find video with text "Appiun"
// - Scroll feed (few times)
// - Open video
// - Verify title for search text
// - Get number of comments


//test failed when locked scren
