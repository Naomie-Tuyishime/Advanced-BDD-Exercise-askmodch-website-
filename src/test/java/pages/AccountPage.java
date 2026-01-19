package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pages.BasePage.driver;

public class AccountPage extends BasePage{
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public AccountPage(WebDriver driver) {
        super();
      PageFactory.initElements(driver, this);
    }
}
