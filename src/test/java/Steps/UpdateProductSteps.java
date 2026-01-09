package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UpdateProductSteps {
    private  WebDriver driver;
    @Given("I am in the cartPage  of the askomdch website")

    @Given("I am on the cart page")

    public void i_am_in_the_cartPage_of_the_askomdch_website() {

        driver = new ChromeDriver();
        driver.get("https://askomdch.com/store");
        driver.findElement(By.cssSelector("a[data-product_id='1198']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='View cart']")));
        cart.click();

    }


    @When("I increase or decrease the product quantity in cart")
    public void i_increase_or_decrease_the_product_quantity_in_cart() {
      driver.findElement(By.cssSelector(".input-text.qty.text")).sendKeys(Keys.ARROW_UP);


    }
    @When("I remove a product from the cart")
    public void i_remove_a_product_from_the_cart() {
        WebElement removeButton =  driver.findElement(By.cssSelector("a[aria-label='Remove this item']"));
        removeButton.click();

    }
    @Then("Product quantity in the cart should be updated")
    public void product_quantity_in_the_cart_should_be_updated() {
        WebElement productQuantity=driver.findElement(By.cssSelector(".input-text.qty.text"));
        WebElement updateButton = driver.findElement(By.name("update_cart"));
        updateButton.click();
        String increasedQ = productQuantity.getAttribute("value");

        WebElement updateMessage =driver.findElement(By.cssSelector(".woocommerce-notices-wrapper")) ;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-notices-wrapper")));
        cart.click();
        String textMessage= updateMessage.getText();
        assertTrue(
                "Quantity was not increased",
                Integer.parseInt(increasedQ) > 1
        );

        assertTrue(
                "Cart update message not shown. Actual message: " + textMessage,
                textMessage.contains("Cart updated.")
        );


    }
    @Then("the product should be removed from the cart")
    public void the_product_should_be_removed_from_the_cart() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-notices-wrapper"))
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", message);

        String text = message.getText();
        assertEquals("fail to remove item ",  text, text.contains("removed"));


    }

}
