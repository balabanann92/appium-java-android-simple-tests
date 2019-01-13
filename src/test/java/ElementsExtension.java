import io.appium.java_client.MobileElement;

public class ElementsExtension {
    public static boolean isElementVisible(MobileElement mobileElement) {
        return mobileElement.isDisplayed();
    }

    public static boolean isElementPresent(MobileElement mobileElement) {
        try {
            mobileElement.isDisplayed();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
