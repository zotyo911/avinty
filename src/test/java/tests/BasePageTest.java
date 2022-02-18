package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.BasePage;

public class BasePageTest extends BaseTest {

    BasePage basePage;

    @Test
    public void goToLandingPage() {
        basePage = new BasePage(driver);
        basePage.navigateTo(Constraints.URL);

        Assertions.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'patients')]")).isDisplayed());
    }
}
