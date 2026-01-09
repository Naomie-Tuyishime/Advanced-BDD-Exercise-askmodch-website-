package Steps;

import Hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class PlaceOrderSteps {

   private final WebDriver driver = Hooks.driver;
   private final MproceedToCheckOutSteps checkout = new MproceedToCheckOutSteps();
   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    @Given("I am on the checkout page")
    public void i_am_on_the_checkout_page() {
        checkout.i_am_on_the_cart_page_then_the_proceed_to_checkout_button_is_visible();
        checkout.i_click_the_proceed_to_checkout_button();
        checkout.i_am_redirected_to_the_checkout_page();
    }
    @When("I enter valid billing details:")
    public void i_enter_valid_billing_details(io.cucumber.datatable.DataTable table) {

        Map<String, String> form = table.asMap(String.class, String.class);
        String firstName = form.get("First name");
        String lastName = form.get("Last name");
        String email = form.get("Email");
        String street = form.get("Street");
        String city = form.get("City");
        String zipCode = form.get("Zip code");
        String phone = form.get("Phone");
        driver.findElement(By.id("billing_first_name")).clear();
        driver.findElement(By.id("billing_first_name")).sendKeys(firstName);
        driver.findElement(By.id("billing_last_name")).clear();
        driver.findElement(By.id("billing_last_name")).sendKeys(lastName);
        driver.findElement(By.id("billing_email")).clear();
        driver.findElement(By.id("billing_email")).sendKeys(email);
        driver.findElement(By.id("billing_address_1")).clear();
        driver.findElement(By.id("billing_address_1")).sendKeys(street);
        driver.findElement(By.id("billing_city")).clear();
        driver.findElement(By.id("billing_city")).sendKeys(city);
        driver.findElement(By.id("billing_postcode")).clear();
        driver.findElement(By.id("billing_postcode")).sendKeys(zipCode);
        driver.findElement(By.id("billing_phone")).clear();
        driver.findElement(By.id("billing_phone")).sendKeys(phone);

    }

    @And("I click on Place order button")
    public void i_click_on() {
        WebElement placeOrder = driver.findElement(By.cssSelector("button[id='place_order']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", placeOrder);
        wait.until(ExpectedConditions.elementToBeClickable(placeOrder)).click();

    }
    @Then("the order is placed successfully")
    public void the_order_is_placed_successfully() {
        WebElement successMessage = driver.findElement(By.cssSelector("div.woocommerce-order p"));
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        String message = successMessage.getText();
        Assert.assertEquals("Thank you. Your order has been received.",message);

    }

    @When("I leave required billing fields empty")
    public void iLeaveRequiredBillingFieldsEmpty() {
        driver.findElement(By.id("billing_first_name")).clear();
        driver.findElement(By.id("billing_last_name")).clear();
        driver.findElement(By.id("billing_email")).clear();
        driver.findElement(By.id("billing_address_1")).clear();
        driver.findElement(By.id("billing_city")).clear();
        driver.findElement(By.id("billing_postcode")).clear();
        driver.findElement(By.id("billing_phone")).clear();

    }

    @And("I click on {string}")
    public void iClickOn(String arg0) {
        WebElement placeOrder = driver.findElement(By.cssSelector("button[id='place_order']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", placeOrder);
        wait.until(ExpectedConditions.elementToBeClickable(placeOrder)).click();

    }

    @Then("error messages are displayed for each empty required field")
    public void errorMessagesAreDisplayedForEachEmptyRequiredField() {
        WebElement firstNameError = driver.findElement(By.id("billing_first_name_field")).findElement(By.cssSelector("span.woocommerce-error"));
        WebElement lastNameError = driver.findElement(By.id("billing_last_name_field")).findElement(By.cssSelector("span.woocommerce-error"));
        WebElement emailError = driver.findElement(By.id("billing_email_field")).findElement(By.cssSelector("span.woocommerce-error"));
        WebElement addressError = driver.findElement(By.id("billing_address_1_field")).findElement(By.cssSelector("span.woocommerce-error"));
        WebElement cityError = driver.findElement(By.id("billing_city_field")).findElement(By.cssSelector("span.woocommerce-error"));
        WebElement postcodeError = driver.findElement(By.id("billing_postcode_field")).findElement(By.cssSelector("span.woocommerce-error"));
        WebElement phoneError = driver.findElement(By.id("billing_phone_field")).findElement(By.cssSelector("span.woocommerce-error"));

        Assert.assertEquals("Billing First name is a required field.", firstNameError.getText());
        Assert.assertEquals("Billing Last name is a required field.", lastNameError.getText());
        Assert.assertEquals("Billing Email address is a required field.", emailError.getText());
        Assert.assertEquals("Billing Street address is a required field.", addressError.getText());
        Assert.assertEquals("Billing Town / City is a required field.", cityError.getText());
        Assert.assertEquals("Billing Postcode / ZIP is a required field.", postcodeError.getText());
        Assert.assertEquals("Billing Phone is a required field.", phoneError.getText());
    }

    @And("the order is not placed")
    public void theOrderIsNotPlaced() {
        WebElement placeOrder = driver.findElement(By.cssSelector("button[id='place_order']"));
        Assert.assertTrue(placeOrder.isDisplayed());
    }
}
