package testvar;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StatusPage {
    private final static By ORDER_STATUS_SCREEN = By.xpath(".//div[@class='Track_OrderColumns__2r_1F']");

    public static void assertOrderStatusScreen(WebDriver driver) {
        WebElement statusScreen = driver.findElement(ORDER_STATUS_SCREEN);
        Assert.assertTrue("Order Status Screen is not visible", statusScreen.isDisplayed());
    }

    public static void assertWrongOrderStatusScreen(WebDriver driver){
        Boolean isScreenEmpty = new WebDriverWait(driver, 1)
                .until(ExpectedConditions.invisibilityOfElementLocated(ORDER_STATUS_SCREEN));
        Assert.assertTrue("Order Status Screen is visible", isScreenEmpty);
    }
}
