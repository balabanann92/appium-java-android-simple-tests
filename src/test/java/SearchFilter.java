import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SearchFilter  extends Base {
    SearchPage objSearch;

    @Test
    public void testStopVideo() throws Exception {
        PageFactory.initElements(new AppiumFieldDecorator(mobiledriver), this);
        objSearch = new SearchPage(mobiledriver);

        //Given
        String searchText = "Appium";

        //When
        //SearchImageView
        MobileAction mobileAction = new MobileAction(mobiledriver);
        AndroidElement searchImageView = waitForPresence(mobiledriver, elementPresetTimeout, searchImageViewBy);
        Assert.assertTrue(searchImageView.isDisplayed());
        mobileAction.tapByElement(searchImageView);

        //SearchEditText
        objSearch.searchByText(searchText);
        AndroidElement searchResult = waitForPresence(mobiledriver, elementPresetTimeout, objSearch.searchResultBy);

        //Wait for filter
        Thread.sleep(4000);
        objSearch.FilterForResultSet.click();
        Thread.sleep(4000);
        AndroidElement filterSortBy = waitForPresence(mobiledriver, elementPresetTimeout, objSearch.filterSortByBy);
        Assert.assertTrue(filterSortBy.isDisplayed());

        //expectedResult
        List<String> expectedFilterValues = new ArrayList<String>();
        expectedFilterValues.add("View count");
        expectedFilterValues.add("Video");
        expectedFilterValues.add("This week");
        expectedFilterValues.add("Long (> 20 minutes)");

        //Sort By
        objSearch.SortBy.click();
        objSearch.LinkTextSort.click();

        // Type
        objSearch.TypeBy.click();
        objSearch.LinkTextType.click();

        // Upload
        objSearch.UploadBy.click();
        objSearch.LinkTextUpload.click();

        // Duration
        objSearch.DurationBy.click();
        objSearch.LinkTextDuration.click();
        objSearch.FilterApplyButton.click();

        //
        Thread.sleep(4000);
        objSearch.FilterForResultSet.click();

        //ActualResualt
        List<String> actualFilterValues = new ArrayList<String>();
        actualFilterValues.add(objSearch.LinkTextSort.getText());
        actualFilterValues.add(objSearch.LinkTextType.getText());
        actualFilterValues.add(objSearch.LinkTextUpload.getText());
        actualFilterValues.add(objSearch.LinkTextDuration.getText());
        Assert.assertEquals(expectedFilterValues, actualFilterValues);
    }
}

// home task
// delete com.google.android.youtube:id

//filter
// 1 Sort by - view coun
//type - video
//upl date this week
// duration - long

//   вынести поиск в текст
//   @find by -->  page obj   prior 1

//применить открыть снова и проверить жид результт
