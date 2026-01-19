package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class CartPage extends BasePage {

    @FindBy(css="a[data-product_id='1198']") private WebElement productitemBtn;
    @FindBy(css="a[title='View cart']") private WebElement viewCartLink;
    @FindBy(css=".input-text.qty.text") private WebElement quantityInput;
    @FindBy(css="a[aria-label='Remove this item']") private WebElement removeBtn;
@FindBy(name = "update_cart") private WebElement updateBtn;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
@FindBy(css= ".woocommerce-notices-wrapper") private WebElement message;
    public CartPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void addProductToCart() {
        wait.until(ExpectedConditions.visibilityOf(productitemBtn)).click();
        wait.until(ExpectedConditions.visibilityOf(viewCartLink)).click();
    }

    public void productIncrimenting() {
        quantityInput.sendKeys(Keys.ARROW_UP);
    }

    public void removeItem() {
        wait.until(ExpectedConditions.visibilityOf(removeBtn)).click();
    }
    public void clickUpdateBtn (){
        wait.until(ExpectedConditions.elementToBeClickable(updateBtn)).click();

        WebElement productQuantity = driver.findElement(By.cssSelector(".input-text.qty.text"));
        int quantity = Integer.parseInt(productQuantity.getAttribute("value"));

        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-notices-wrapper")));

        assertTrue("Quantity was not increased", quantity > 1);
        assertTrue("Cart update message not shown", message.getText().contains("Cart updated."));


    }
    public void productRemovedMsg (){


        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", message);
wait.until(ExpectedConditions.visibilityOf(message));
        assertTrue("Failed to remove item", message.getText().contains("removed"));

    }
}
